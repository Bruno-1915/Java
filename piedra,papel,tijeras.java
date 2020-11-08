import java.util.*;

public class ejercicio3 {

	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
	Random aleatorios = new Random();
	int punto = 0;
	boolean bandera = true;
	int contador = 0;
	boolean punto_bool = false;

	while (bandera) {
		System.out.println("*****Elige una opcion*****");
		System.out.println("1: Tirar dados");
		System.out.println("2: Dejar de jugar");
		int eleccion = scan.nextInt();
		switch(eleccion) {
			case 2:
			bandera = false;
			break;

			case 1:
			int dado1 = aleatorios.nextInt(5) + 1;
			int dado2 = aleatorios.nextInt(5) + 1;
			int suma = dado1 + dado2;
			System.out.println("Dado 1: " + dado1 + ", dado 2: " + dado2);
			System.out.println("La suma fue: " + suma);
			if (contador == 0) {
				if (suma == 7 || suma == 11) { System.out.println("Has ganado!"); bandera = false; }
				else if (suma == 2 || suma == 3 || suma == 12) { System.out.println("Has perdido"); bandera = false; }
				else { punto = suma; punto_bool = true; }
				}
			else {
				if (suma == punto) { System.out.println("Has ganado!"); bandera = false; punto_bool = false;}
				else if (suma == 7) { System.out.println("Has perdido!"); bandera = false; punto_bool = false;}
				}
			contador++;
			if (punto_bool) { System.out.println("Tu punto es: " + punto); System.out.println(" "); }
			}
		}
	System.out.println("El juego ha terminado");
	}
}
