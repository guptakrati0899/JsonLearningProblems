package inventorydetailmodel;
import java.util.Scanner;

public class Scanner1 {
	
	static Scanner s = new Scanner(System.in);

	// For Scanning Integer from User
	public static int integerScanner() {
		return s.nextInt();
	}

	// For Scanning String from User
	public static String stringScanner() {
		return s.next();
	}
	
	public static long longScanner() {
		return s.nextLong();
	}

	// For Scanning String Single Word from User
	public static String stringSingleWordScanner() {
		return s.next();
	}

	// For Scanning Char from User
	public static char charScanner() {
		return s.next().charAt(0);
	}
}