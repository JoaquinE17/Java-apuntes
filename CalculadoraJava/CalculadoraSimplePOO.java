import java.util.Scanner;

public class CalculadoraSimplePOO{
	private double numero1;
	private double numero2;

	public void leerumeros(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingresa el primer numero: ");
		numero1 = scanner.nextDouble();

		System.out.print("Ingrese el segundo numero: ");
		numero2 = scanner.nextDouble();
	}

	public double sumar(){
		return numero1 + numero2;
	}
	public double restar(){
		return numero1 - numero2;
	}
	public double multiplicar(){
		return numero1 * numero2;
	}
	public double dividir(){
		if (numero2 == 0){
			System.out.println("Error: Dovicin por cero.");
			return 0;
		}
		return numero1 / numero2;
	}

	// Principal
	public static void main(String[] args){
		CalculadoraSimplePOO calc = new CalculadoraSimplePOO();
		/*
		'CalculadoraSimplePOO' → Es el nombre de la clase. Esto define el tipo de objeto que vamos a crear.
		'calc' → Es una variable (o referencia) que apunta al objeto que vamos a crear. Es del tipo CalculadoraSimplePOO.
		'new' → Es un operador de Java que crea un nuevo objeto en memoria (en el heap). Reserva espacio y construye el objeto.
		'CalculadoraSimplePOO()' → Es una llamada al constructor de la clase. El constructor es un método especial que se ejecuta al crear el objeto.
		
		_Coloquialmente estas diciendo:
		"Crea una nueva calculadora basada en la clase 'CalculadoraSimplePOO' y guárdala en la variable 'calc' para poder usarla."
		*/
		Scanner scanner = new Scanner(System.in);

		calc.leerumeros();

        System.out.println("Selecciona una operación:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        int opcion = scanner.nextInt();
        double resultado = 0;

        switch (opcion){
        case 1:
        	resultado = calc.sumar();
        	break;
        case 2:
        	resultado = calc.restar();
        	break;
        case 3:
        	resultado = calc.multiplicar();
        	break;
        case 4:
        	resultado = calc.dividir();
        	break;
        default:
        	System.out.println("Opción invalida.");
        	return;
        }

        System.out.println("Resultado: "+resultado);
	}
}