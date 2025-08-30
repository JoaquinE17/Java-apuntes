// El polimorfismo permite que distintos obgetos respondan de manera diferente al mismo mensaje/metodo (segun el contexto)
public class Polimorfismo{

	public static void main(String[] args){

		//Polimorfimo {por herencia, por sobrecarga}

		var animal = new  animal();
		animal.sonido();

		//Polimorfismo - Por herencia (sobreescritura)
		var dog = new perro();
		dog.sonido();

		//Polimorfismo - Por sobrecarga (sobrecarga de metodos) - definir varios metodos con el misno nombre pero con parametros diferentes
		var calculadora = new calculadora();
			System.out.println(calculadora.suma(2.55,2.20));
	}
	
	public static class animal{
		public void sonido(){
			System.out.println("Algun sonido");
		}
	}
	public static class perro extends animal{
		// Aqui entra el concepto de 'polimorfismo' porque lo estamos redefiniendolo
		@Override
		public void sonido(){
			System.out.println("Guau");
		}
	} 

	public static class calculadora{
		public int suma(int a, int b){
			return a+b;
		}
		public double suma(double a, double b){
			return a+b;
		}
	}
}  

