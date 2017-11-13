package chain_of_responsibility.two;

import java.util.Objects;

public abstract class AbstractBankomat implements IBanknote {

	private int amountBanknotes;
	private IBanknote nextBanknote;

	public AbstractBankomat(int amountBanknotes) {
		this.amountBanknotes = amountBanknotes;
	}

	public int getAmountBanknotes() {
		return amountBanknotes;
	}

	public void setAmountBanknotes(int amountBanknotes) {
		this.amountBanknotes = amountBanknotes;
	}

	public IBanknote getNextBanknote() {
		return nextBanknote;
	}

	public void setNextBanknote(IBanknote nextBanknote) {
		this.nextBanknote = nextBanknote;
	}

	@Override
	public int payment(int startSuma) {
		int nominalBanknote = getNominalBanknote();
		int amountMoney = amountBanknotes * nominalBanknote;
		if (amountMoney < startSuma && Objects.isNull(nextBanknote)) {
			throw new IllegalArgumentException(
					"Недостаточно денег ! В наличии = " + amountMoney + ", надо снять " + startSuma);
		}

		int integerPart, fractionalPart = 0;
		if (amountBanknotes == 0) {
			integerPart = 0;
			fractionalPart = startSuma;

		} else {
			integerPart = startSuma / nominalBanknote;
			if (amountBanknotes < integerPart) {
				fractionalPart = (integerPart - amountBanknotes) * nominalBanknote + (startSuma % nominalBanknote);
				integerPart = amountBanknotes;
			} else {
				fractionalPart = startSuma % nominalBanknote;
			}
			amountBanknotes -= integerPart;
		}

		int withDrawMoneyCurrentBanknote = integerPart * nominalBanknote;
		System.out.printf("Номинал %4d: Снято %4d, остаток = %3d, банкнот %3d\n", nominalBanknote,
				withDrawMoneyCurrentBanknote, fractionalPart, amountBanknotes);

		int withDrawMoneyNextBanknote = 0;
		if (Objects.nonNull(nextBanknote)) {
			withDrawMoneyNextBanknote = nextBanknote.payment(fractionalPart);
		}

		return withDrawMoneyCurrentBanknote + withDrawMoneyNextBanknote;
	}

	@Override
	public int allMoneyInBankomat() {
		int nextBanknoteAllMoney = 0;
		if (Objects.nonNull(nextBanknote)) {
			nextBanknoteAllMoney = nextBanknote.allMoneyInBankomat();
		}
		return amountBanknotes * getNominalBanknote() + nextBanknoteAllMoney;
	}

	public int getNominalBanknote() {
		if (this instanceof Banknote100) {
			return 100;
		} else if (this instanceof Banknote50) {
			return 50;
		} else if (this instanceof Banknote20) {
			return 20;
		} else {
			throw new RuntimeException("Illegal case for " + this.getClass().getName() + " !");
		}
	}
}
