package lab1.f3;

public class Argument {

	/**
	 * @param args
	 * @author Pal Csongor
	 * �rjunk programot, amely kisz�molja a parancssor argumentumainak �sszeg�t, 
	 * csak az eg�sz sz�mokat v�ve figyelembe (kiv�telkezel�st alkalmazzunk). �rjuk meg a
	 * programnak egy m�sik v�ltozat�t is, amelyik minden numerikus argumentumot
	 * figyelembe vesz. Ezt az ut�bbit eg�sz�ts�k ki olyan m�don, hogy a program k�l�n
	 * sz�molja ki a p�ratlan, illetve p�ros argumentumok �sszegeit.
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
