package builder.one;

public class Main {

	public static void main(String[] args) {
		Car car = new CarBuilder().setName("Tesla")
								  .setBoxTransfer(BoxTransfer.AUTO)
								  .setMaxSpeed(120)
								  .getCar();
		System.out.println(car);
		
		car = new CarBuilder().setName("Mersedes")
							  .setBoxTransfer(BoxTransfer.MANUAL)
							  .getCar();
		System.out.println(car);
		
		car = new CarBuilder().setName("Ford")
					 		  .getCar();
		System.out.println(car);
		
		car = new CarBuilder().getCar();
		System.out.println(car);
	}
}
