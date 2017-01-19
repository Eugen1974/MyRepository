package lambda1;

@FunctionalInterface
public interface IPersonFabrica<T extends Person> {
	T create(String name, int age); 
}
