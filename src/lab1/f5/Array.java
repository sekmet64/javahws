package lab1.f5;

/**
 * Hozzunk létre egy tömbökből álló tömböt, amelynek első sora 1, második sora 2, n-
 * edik sora n elemet tartalmaz. Az elemek egész számok 1-től n*(n+1)/2-ig, ahol n, a
 * sorok száma,  a parancssor argumentuma. Amennyiben nem adunk meg
 * argumentumot (vagy az nem egy numerikus érték), a sorok alapértelmezett száma
 * legyen 10. Figyeljünk arra, hogy mindenik tömb esetében csak annyi elemnek
 * foglaljunk helyet, amennyire valóban szükség van. A tömb elemeit írassuk ki a
 * konzolra az alábbi példához hasonlóan: 
 */


public class Array {
	public static void main(String[] args) {
		int n;
		try { 
			n = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			n = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			n = 10;
		}
		
		int[][] a = new int[n][];
		int k = 1;
		for (int i = 0; i < n; i++) {
			a[i] = new int[i + 1];
			for (int j = 0; j < i; j++) {
				a[i][j] = k++;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
