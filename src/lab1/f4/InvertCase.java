package lab1.f4;

public class InvertCase {

	/**
	 * @param args
	 * Írjunk programot, amely kiírja a konzolra a parancssor argumentumait, a kisbetűket
	 * nagybetűkbe, a nagybetűket kisbetűkbe alakítva. Útmutatás:  egy  String  objektum
	 * esetében egy adott karaktert a  charAt(index) metódus segítségével kérdezhetünk le,
	 * az ellenőrzés és átalakítás a  Character  osztály statikus metódusainak segítségével
	 * történhet. 
	 */
	private static String invertCase(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (Character.isUpperCase(ch))
				sb.append(Character.toLowerCase(ch));
			else
				if (Character.isLowerCase(ch))
					sb.append(Character.toUpperCase(ch));
				else
					sb.append(ch);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		for (String s : args) 
			System.out.print(invertCase(s) + " ");
	}
}
