//1. Crea una clase Vehicle con un método move(). Luego crea una subclase Car que herede de Vehicle y agrega el método honk().

class practica1{

	public static void main(String[] args) {
		vehiculo car1 = new vehiculo();
		car1.marca = "materazzi";
		car1.mover();

		auto car2 = new auto(car1);
		car2.marca = "fiat";
		car2.mover();

		auto2 car3 = new auto2();
		car3.marca = "renault";
		car3.mover();
		car3.vocina();
	}

	public static class vehiculo{
		String marca;

		void mover(){
			System.out.println("El vehiculo "+marca+" se esta moviendo.");
		}
	}

	public static class auto extends vehiculo{
		vehiculo otroAuto;
		auto(vehiculo otroAuto){
			this.otroAuto = otroAuto;
		}
		@Override
		void mover(){
			System.out.println("El vehiculo "+marca+" esta en movimiento pero no supera a "+otroAuto.marca);
		}
	}

	public static class auto2 extends vehiculo{
		void vocina(){
			System.out.println(" '-> pi, pi, pi!! (ruido de claxo).");
		}
	}
}