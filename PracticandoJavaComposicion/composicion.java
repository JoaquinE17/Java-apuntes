public class composicion{
	// Herencia == "es un"
	// Compocision == "tiene un"

	public static void main(String[] args){ 
		// Composicion
		var coche = new auto();
		coche.motor.encender();
		coche.motor.movimiento();

		/*coche.encender();
		coche.movimiento();*/

	}
	// Creo la clase motor
	public static class motor{
		public void encender(){
			System.out.println("Motor encendido");
		}
		public void movimiento(){
			System.out.println("Coche en movimiento");
		}
	}

	// [Composicion]: 
	public static class auto{
		public motor motor = new motor();

		/*private motor motor = new motor(); // Instancio la clase motor como privado
		public void encender(){ // Accedo al metodo encender
			motor.encender();
		}

		public void movimiento(){ // Accedo al metodo mivimiento
			motor.movimiento();
		}*/

	}
}