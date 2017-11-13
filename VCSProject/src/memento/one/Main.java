package memento.one;

import memento.two.Data;

public class Main {

	public static void main(String[] args) {
		Originator originator = new Originator(new Data("1-й объект"));
		System.out.println(originator.getData());

		Caretaker caretaker = new Caretaker(originator.createMemento());

		originator.setData(new Data("2-й объект"));
		System.out.println(originator.getData());

		originator.setMemento(caretaker.getMemento());
		System.out.println("Откатился на " + originator.getData());
	}
}
