// Los import siempre se colocan fuera de la clase creada *
import java.util.Scanner;

// Crea una CLASE publica llamada Intro 
// Las clases deben empezar con mayusculas por convencion (CamelCase)
public class Intro{ 
	
	// Crea un METODO publico - estatico - ejecuta codigo (sin retornar valores) - nombre del metodo (main es el punto de partida) - argumentos (arrays de strings) con el nombre args
	public static void main(String[] args){ 
	
		// Imprime por consola:
		// Accede a la clase 'sistema' de Java, despues a la intancia 'out' (salida standar), ejecuta el metodo 'imprimir' seguido de un salto de linea (\n)
		System.out.println("Hola Java"); 
		/*
		- System: Es una clase final del paquete java.lang.
		- out: Es un atributo estático de la clase System que representa la salida estándar (normalmente, la consola).
		- println(): Es un método del objeto PrintStream que imprime texto seguido de un salto de línea.
		*/

		// Ejercicios:
		System.out.println("Pepito Perez");
		System.out.println("Hola\nmundo");
		System.out.println("2 + 2 = " + (2+2));
		System.out.print("Esto está en la misma linea ");
		System.out.println("que esto.");

		// Variables:
		int edad = 25;
		String nombre1 = "Laura";
		System.out.println(nombre1+" tiene "+edad+" años."); // Los espacios son necesarios

		// Entrada por teclado:
		//import java.util.Scanner; *
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa tu nombre: ");
		String nombre2 = scanner.nextLine();
		System.out.println("Hola, "+nombre2);
		// No es posible re-asignar valores a las variables

	}

} 