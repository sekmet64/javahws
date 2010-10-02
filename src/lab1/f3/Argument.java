package lab1.f3;

public class Argument {

	/**
	 * @param args
	 * @author Pal Csongor
	 * Írjunk programot, amely kiszámolja a parancssor argumentumainak összegét, 
	 * csak az egész számokat véve figyelembe (kivételkezelést alkalmazzunk). Írjuk meg a
	 * programnak egy másik változatát is, amelyik minden numerikus argumentumot
	 * figyelembe vesz. Ezt az utóbbit egészítsük ki olyan módon, hogy a program külön
	 * számolja ki a páratlan, illetve páros argumentumok összegeit.
	 */
	public static void main(String[] args) {
		System.out.println("Summing integer arguments:");
		int count = 0;
		int invalidCount = 0;
		for (String i : args) {
			try {
				count += Integer.parseInt(i);
			} catch(NumberFormatException e) {
				invalidCount++;
			}
		}
		System.out.println(count + " (" + invalidCount + " invalid argument was skipped)\n");
		
		System.out.println("Summing all numeric arguments:");
		double dcount = 0;
		invalidCount = 0;
		for (String i : args) {
			try {
				dcount += Double.parseDouble(i);
			} catch(NumberFormatException e) {
				invalidCount++;
			}
		}
		System.out.println(dcount + " (" + invalidCount + " invalid argument was skipped)\n");
		
		System.out.println("Summing odd/even arguments:");
		int oddCount = 0;
		int evenCount = 0;
		invalidCount = 0;
		int cur;
		for (String i : args) {
			try {
				cur = Integer.parseInt(i);
				if (cur % 2 == 0)
					evenCount += cur;
				else
					oddCount += cur;
			} catch(NumberFormatException e) {
				invalidCount++;
			}
		}
		System.out.println("Even: " + evenCount + " Odd: " + oddCount + " (" + invalidCount + " invalid argument was skipped)");
	}

}
