import java.util.*;
public class proyecto1 {

	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
	Scanner scanInt = new Scanner(System.in).useLocale(Locale.ENGLISH);
	Random aleatorios = new Random();

	System.out.println("¿Cual es tu nombre?");
	String nombre = scan.nextLine();
	boolean bandera = true;
	int opcion;
	int total = 0;
	int vict_us = 0;
	int vict_comp = 0;
	//Peliculas
	String pelicula1 = "EL GLADIADOR";
        String pelicula2 = "EL ORIGEN";
        String pelicula3 = "BATMAN";
        String pelicula4 = "TROYA";
        String pelicula5 = "HARRY POTTER";
        String pelicula6 = "LA ESTAFA MAESTRA";
        String pelicula7 = "LOS ILUSIONISTAS";
        String pelicula8 = "DJANGO";
        String pelicula9 = "SCOOBY DOO";
        String pelicula10 = "EL SEÑOR DE LOS ANILLOS";
        String pelicula11 = "CONSTANTINE";
        String pelicula12 = "CAPITAN DE MAR Y GUERRA";
        String pelicula13 = "EL JINETE SIN CABEZA";
        String pelicula14 = "BELLEZA AMERICANA";
        String pelicula15 = "EL CLUB DE LA PELEA";
	String pelicula16 = "HERCULES";
	String pelicula17 = "PIE PEQUEÑO";

	//String para imprimir el ahorcado
	String fallo1 = "#######\n#  0  # \n#######";
	String fallo2 = "#######\n#  0  # \n#  |  # \n#######";
	String fallo3 = "#######\n#  0  # \n# /|  # \n#######";
	String fallo4 = "#######\n#  0  # \n# /|\\ # \n#######";
	String fallo5 = "#######\n#  0  # \n# /|\\ # \n# /   # \n#######";
	String fallo6 = "#######\n#  0  # \n# /|\\ # \n# / \\ # \n#######";


	while (bandera) {

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%  Bienvenido al juego del ahorcado %");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(" ");
		System.out.println("Escoge una opcion");
		System.out.println(" ");
		System.out.println("1: Jugar al ahorcado");
		System.out.println("2: Ver estadisticas");
		System.out.println("3: Salir");
		opcion = scanInt.nextInt();
		switch(opcion) {
			case 1:

			String pelicula = "";
			int pel = aleatorios.nextInt(17) + 1;
			switch(pel) {
				case 1:
				pelicula = pelicula1;
				break;
		
		                case 2:
		                pelicula = pelicula2;
		                break;

		                case 3:
		                pelicula = pelicula3;
		                break;
		
		                case 4:
		                pelicula = pelicula4;
		                break;
		
		                case 5:
		                pelicula = pelicula5;
		                break;
		
		                case 6:
		                pelicula = pelicula6;
		                break;
	
		                case 7:
		                pelicula = pelicula7;
		                break;
	
		                case 8:
		                pelicula = pelicula8;
		                break;

		                case 9:
		                pelicula = pelicula9;
		                break;
		
		                case 10:
		                pelicula = pelicula10;
		                break;
		
		                case 11:
		                pelicula = pelicula11;
		                break;
		
		                case 12:
		                pelicula = pelicula12;
		                break;
	
		                case 13:
		                pelicula = pelicula13;
		                break;
	
		                case 14:
		                pelicula = pelicula14;
		                break;
		
		                case 15:
		                pelicula = pelicula15;
		                break;

                                case 16:
                                pelicula = pelicula15;
                                break;

                                case 17:
                                pelicula = pelicula15;
                                break;


				}

			int contador_fallas = 0;
			boolean bandera_juego = true;
			String temp = "";
			//Espacio para una bandera que detenga el juego si pierde muchas veces
			//while (bandera_juego) {
			for (int i = 0; i < pelicula.length(); i++) {
				if (pelicula.charAt(i) != ' ') {
					temp += "_";
					}
				else {temp += " ";}
				}
			String cond_fallo = temp;
			System.out.println(temp);
			while(bandera_juego) {
			boolean auxiliar = false;
			System.out.println("¿Que letra escoges?");
			String input = scan.nextLine();
			char letra = ' ';
			if (input.length() > 1) {
				if(input.equals(pelicula)){
					System.out.println("Muy bien, has adivinado la pelicula!");
					vict_us++;
					total++;
					bandera_juego = false;
					}
				else {auxiliar = true;}


				}
			//INICIO DEL ELSE GIGANTE
			else {
				letra = input.charAt(0);
				
			String temp1 = "";

			for (int i = 0; i < pelicula.length(); i++) {
				if (letra == pelicula.charAt(i)) {
					temp1 += letra;
					}
				else if (pelicula.charAt(i) != ' '){temp1 += "_";}
				else {temp1 += " ";}
				}

			if (temp1.equals(cond_fallo)) {auxiliar = true;}
			else {
				String temp2 = "";
				for (int i = 0; i < pelicula.length(); i++) {
					if(temp.charAt(i) != '_') {temp2 += temp.charAt(i);}
					else if (temp1.charAt(i) != '_') {temp2 += temp1.charAt(i);}
					else {temp2 += '_';}
					}
				temp = temp2;
				System.out.println(temp);
				}
			
			if (temp.equals(pelicula)) {
				System.out.println("Muy bien, has adivinado la pelicula!");
				vict_us++;
				total++;
				bandera_juego = false;
				}
	//FIN DEL ELSE GIGANTE
				}
			if (auxiliar) {
				System.out.println("Fallaste!");
				System.out.println("");
				contador_fallas++;
				switch(contador_fallas) {
					case 1:
					System.out.println(fallo1);
					System.out.println("");
					System.out.println("Llevas un fallo");
					break;

                                        case 2:
                                        System.out.println(fallo2);
					System.out.println("");
                                        System.out.println("Llevas dos fallos");
                                        break;

                                        case 3:
                                        System.out.println(fallo3);
					System.out.println("");
                                        System.out.println("Llevas tres fallos");
                                        break;

                                        case 4:
                                        System.out.println(fallo4);
					System.out.println("");
                                        System.out.println("Llevas cuatro fallos");
                                        break;

                                        case 5:
                                        System.out.println(fallo5);
					System.out.println("");
					System.out.println("Llevas cinco fallos");
                                        break;

                                        case 6:
                                        System.out.println(fallo6);
					System.out.println("");
					bandera_juego = false;
					System.out.println("Has alcanzado el maximo de fallos");
					System.out.print("La pelicula era: ");
					System.out.println(pelicula);
					System.out.println("Mas suerte la proxima :)");
					vict_comp++;
					total++;
                                        break;

					}
			}


			System.out.println(" ");
		//Fin del while del juego
		}
			break;

			case 2:
			System.out.println("%%%%%%%%%%%%%%%%");
			System.out.println("% Estadisticas %");
			System.out.println("%%%%%%%%%%%%%%%%");
			System.out.println("");
			System.out.println("Total de juegos: " + total);
			System.out.println("Victorias de " + nombre + ": " + vict_us);
			System.out.println("Victorias de la computadora: " + vict_comp);
			System.out.println("");
			break;

			case 3:
			System.out.println("Adios");
			bandera = false;
			break;

			}

		}
	//Fin main
	}
}
