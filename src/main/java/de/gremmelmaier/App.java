package de.gremmelmaier;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
	/**
	 * Main Methode
	 * @param args Parameter f\"ur die \"ubergabe von Kommandozeilenparametern
	 */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		a = a.toUpperCase();
		System.out.println(a);
		scan.close();
    }
}
