public class abstraccion{

	public static void main(String[] args){

		// ABSTRACCION {abstract, implements} - (ocultar la implementacion y solo mostrar lo esencial)

		// Clase Abstracta
		// var animal = new animal(); Error
		var dog = new perro("pepe");
		dog.dormir();
		dog.sonido();

		// Interface
		var fly = new pajaro("Cotorra");
		fly.dormir();
		fly.sonido();
		fly.volar();

	}

	/* Clase Abstracta - no se puede instanciar, solo pueden [hederarse] y modificar/agregar (polimorfismo) metodos*/
	public static abstract class animal{
		String nombre;
		public animal(String nombre){
			this.nombre=nombre;
		}
		public void dormir(){
			System.out.println("El animal " + nombre +" esta durmiendo.");
		}
		public abstract void sonido();
	}
	public static class perro extends animal{
		public perro(String nombre){
			super(nombre);
		}
		@Override
		public void dormir(){
			System.out.println("El PERRO " + nombre + " esta durmiendo.");			
		}
		@Override
		public void sonido(){
			System.out.println("guau");
		}
	}

	/* Interface - declarar metodos e implementacion (funciona solo para definir). NO se pueden instanciar
	No se permiten atributos, solo constantes. Estas si se pueden hederar varias a una
	clase en concreto, herencia multiple de comportamiento
	Ejemplo:
	- Creo dos 'interfaces' (volando y volando2)
	- Despues creo la clase 'pajaro' e implemento las operacones contnidas en las interfaces
	
	public interface volando{
		public void subir();
	}public interface volando2{
		public void bajar();
	}

	public static class pajaro extends animal implements volando,volando2{
		@Override
		public void subir(){
			System.out.println("Esta elevandose");
		}
		@Override
		public void bajar(){
			System.out.println("Esta aterrizando");
		}
	}
	*/	
	public interface volando{
		public void volar();
	}
	public static class pajaro extends animal implements volando{
		public pajaro(String nombre){
			super(nombre);
		}
		// dormir() no se modifica
		@Override
		public void sonido(){
			System.out.println("piopio");
		}
		@Override
		public void volar(){
			System.out.println("El pajaro esta volando");
		}
	}
}