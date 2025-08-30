// Importar Scanner para estrada de datos
import java.util.Scanner;

// Esqueleto basico del programa
public class CalculadoraSimpleComun{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in); // Crear Scanner para entrada

        // Mostrar mensaje de bienvenida
        System.out.println("=== Calculadora Simple ===");

        // Solicitar dos números al usuario
        System.out.print("Ingresa el primer número: ");
        double numero1 = scanner.nextDouble();  // Leer número

        System.out.print("Ingresa el segundo número: ");
        double numero2 = scanner.nextDouble();

        // Mostrar menú de operaciones
        System.out.println("Selecciona una operación:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        double resultado = 0;

        // Lógica con switch para decidir qué hacer
        switch (opcion) {
            case 1:
                resultado = sumar(numero1, numero2);
                break;
            case 2:
                resultado = restar(numero1, numero2);
                break;
            case 3:
                resultado = multiplicar(numero1, numero2);
                break;
            case 4:
                if (numero2 != 0) {
                    resultado = dividir(numero1, numero2);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                    return; // Termina el programa
                }
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        // Mostrar resultado
        System.out.println("Resultado: " + resultado);
    }

    // Métodos auxiliares
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }
}