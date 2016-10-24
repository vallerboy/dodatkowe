package oskarpolak.lombok;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// Jak widać adnotacja "data" działa.
		// Oskar oskar = new Oskar();
		// oskar.getName();

		// Odnośnik do klasy pokazującej refleksje.
		//new Refleksje();

		// Odnośnik do klasy ukazującej działanie na plikach
		 FilesOperation filesOperation = new FilesOperation(false);
		// filesOperation.writeToFileJSON();
		 filesOperation.readFromFileWithCharset();

		// Odnośnik do klasu pokazującej funckje biblioteki JodaTime
		// new Time();

		// new SimpleCalculator().run();

		// new Threads();

		// new Regex();
		
		 
		
		
		
	}
}
