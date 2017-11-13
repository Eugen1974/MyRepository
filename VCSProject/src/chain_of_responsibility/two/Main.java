package chain_of_responsibility.two;

public class Main {

	public static void main(String[] args) {
		Banknote100 banknote100 = new Banknote100(10);
		Banknote50 banknote50 = new Banknote50(8);
		Banknote20 banknote20 = new Banknote20(5);

		banknote100.setNextBanknote(banknote50);
		banknote50.setNextBanknote(banknote20);

		calculation(banknote100, 1100);
		System.out.println();
		calculation(banknote100, 720);
		System.out.println();
		calculation(banknote100, 390);
	}

	public static void calculation(AbstractBankomat banknote, int startSuma) {
		System.out.println("Надо снять " + startSuma);
		int allMoneyInBankomat = banknote.allMoneyInBankomat();
		System.out.println("Всего в банкомате " + allMoneyInBankomat);
		if (startSuma > allMoneyInBankomat) {
			System.out.println("Сумма снятия превышает остаток. Невозможно выполнить операцию.");
		} else {
			System.out.println("---------------------------------------");
			int withDrawMoney = banknote.payment(startSuma);
			System.out.println("---------------------------------------");
			System.out.println("Снято " + withDrawMoney + ", остаток " + (startSuma - withDrawMoney));
			System.out.println("Всего в банкомате " + banknote.allMoneyInBankomat());
		}
	}
}
