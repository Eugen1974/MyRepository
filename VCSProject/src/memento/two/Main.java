package memento.two;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(new Data("1-й уровень"));
		System.out.println(game.getData().getStr());

		File file = new File(game.save());

		game.setData(new Data("2-й уровень"));
		System.out.println(game.getData().getStr());

		game.load(file.getSave());
		System.out.println("Откатился на " + game.getData().getStr());
	}
}
