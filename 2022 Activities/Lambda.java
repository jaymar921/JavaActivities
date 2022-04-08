public class Lambda{

	public static void main(String... args){
		/* lambda expression = 	feature for Java 8 and above
		* 						also known as an anonymous method
		* 						a shorter way to write anonymous classes with only one method
		*
		*						need to use a functional interface or use a pre-defined functional interface
		*						they contain only one abstract method
		*						ex. ActionListener, Runnable, (user-defined)
		*
		*						A Lambda expression can be used in any place where a functional interface is required
		*						How to use a lambda expression:
		*						(arguments) -> {statement/s}
		*/

		String name = "Jayharron Abejar";
		String partner = "Pia Abellana";

		MyInterface couple = (a,b) -> {
			System.out.println(a + "'s partner is " + b);
		};

		couple.message(name, partner);

	}
}

@FunctionalInterface
interface MyInterface{
	public void message(String name, String partner);
}