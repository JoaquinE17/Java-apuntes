public class herencia{
	public static void main(String[] args){
		// HERENCIA -> {extends, super}

		var animal = new animal("cuadrupedo");
		animal.nombre = "cuadrupedo";
		animal.comer();

		var perro = new perro("Perrito",5);
		//perro.nombre = "Perrito";
		perro.comer();

		var gato = new gato("Gatito");
		//gato.nombre = "Gatito";
		gato.comer();

		var pajaro = new pajaro("Pajarito");
		pajaro.nombre = "Pajaro loco"; 
		/* Para evitar que se reescriba. Se debe crear el elemento [nombre] como Constante con 'final private'
		 o solo 'private' para solo reescribirlo con setter*/
		pajaro.comer();
		pajaro.volar();
	}

	public static class animal{
		String nombre;
		public animal(String nombre){ // Se nesecita su replica en las subclases que se creen 
			this.nombre = nombre;
		}
		public void comer(){
			System.out.println("El animal "+nombre+" esta comiendo.");
		}
	}

	/* Herencia simple
	public static class perro extends animal{}

	public static class gato extends animal{}

	public static class pajaro extends animal{}
	*/

	/* Herencia cascada 
	En Java solo se puede generar una subclase de una superclase. Pero 
	se puede ir encadenando las subclases como se requiera

	public static class perro extends animal{} // Hereda de la clase animal

	public static class gato extends perro{} // Hereda de la clase perro

	public static class pajaro extends gato{} // Hereda de la clase gato
	*/

	// Formas de especializar (modificar, agregar, restringir o adaptar el uso de una clase para un proposito)
	public static class perro extends animal{
		int edad;
		// Formas de llamar al Constructor
		public perro(String nombre, int edad){ // Replica del constructor (superclase)
			super(nombre); // Referencia a la superclase (animal)
			this.edad = edad; // Referencia a la clase local (perro) 
		}

		// MODIFICAR (Reescribir el metodo comer())
		public void comer(){
			System.out.println("El "+nombre+" de "+edad+" años esta bebiendo agua.");
		}
	}

	public static class gato extends animal{
		public gato(String nombre){ // Replica del constructor (superclase)
			super(nombre); 
		}
		// MODIFICAR (Reescribir el metodo comer())
		@Override // Le dice al compilador que vas a reescribir el metodo comer(). Modificar comportamiento heredado. RECOMENDADO
		public void comer(){
			System.out.println("El gato esta comiendo lasaña");
		}
	}

	public static class pajaro extends animal{
		public pajaro(String nombre){ // Replica del constructor (superclase)
			super(nombre);
		}
		public void volar(){
			// AGREGAR (codigo especial de esta clase)
			System.out.println("El "+nombre+" Esta volando.");
		}
	}

	/*En Java[extends]: Hereda los atributos y metodos de la clase Padre
		-Usar los métodos y atributos de la clase padre.
		-Sobrescribir (reescribir) métodos de la clase padre.
		-Agregar nuevos métodos propios (especialización).
	*/

	/*En Java, [super] es una palabra clave que se utiliza para referirse a la clase padre 
	(superclase) desde una clase hija (subclase). Puedes usar super para:
		- Llamar a métodos definidos en la superclase.
		- Acceder a atributos heredados (si no están ocultos).
		- Llamar al constructor de la superclase (usando super(...)).
	EJEMPLO:
	Si agregamos esta linea: [super.comer();], a la clase gato (antes de Sistem.out...)
	Devolveria esto:
	El animal Gatito está comiendo
	El gato esta comiendo lasaña
	*/

}