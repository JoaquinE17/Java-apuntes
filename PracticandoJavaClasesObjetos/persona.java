public class persona{

	//[Atributos]: Variableas que definen el estado/caracteristicas del objeto (tambien mencionados como propiedades)
	protected String nombre;
	String apellido;
	//int edad; Si es publica puede ser modificada desde cualquier parte del programa
	private int edad; // Para evitar problemas de asignacion
	final private String id; // Establese una varible que solo podra ser creada pero NO modificada
	/*[final]: Significa que una vez que se le asigna un valor a una variable,
	no puede cambiar. Es decir, es inmutable después de su inicialización. 
	Evita que accidentalmente se sobrescriba el valor más adelante en el código.
	Sin [final] Puedes cambiar el valor de id cuantas veces quieras. Esto da más 
	flexibilidad, pero también menos protección contra errores. Se usa cuando 
	esperas que la propiedad cambie (por ejemplo, nombre, estado, etc.).*/

	//[Constructor]: Permite inicializar valores en el mometo de su creacion, obligando a que cualquier instancia creada contenga estos valores
	/*Ademas dentro de un constructor puedes agregar modificaciones a los parametros resibidos 
	(ejemplo en *apellido) <Tener en cueta el tipo de dato de la variable>	*/
	public persona(String nombre, String lastname, int edad, String id){
		/* Una cosa son las parametro pasados al constructor y otra cosa es 
		Estableser la relacion con las propiedades internas de la clase */
		this.nombre = nombre;
		apellido = " {"+lastname+"}";
		//this.edad = edad; Guarda cualquier valor incluso valores negativos
		this.setEdad(edad); // Solo asigna el valor si cumple la condicion establesida en el setter
		this.id = id;
		//[this]: Hace referencia al contexto de la clase (tanto propiedades como metodos)
		/* Se puede obviar el 'this' estableciendo, a los parametros del constructor,
		 un nombre distinto a los de la clase en si (ejemplo en *apellido), pero no es una buena practica. De 
		 hecho se recomienda que los nombres sean los mismos y referenciar a los 
		 atributos internos de la clase con [this.]*/
	/*¿Cuándo necesitas un constructor? (SOLO SI SE TIENE ATRIBUTOS PPIVADOS)
		Si quieres inicializar atributos privados al momento de crear el objeto, 
		entonces sí te conviene (pero no es obligatorio) definir un constructor.
		Si no defines ningún constructor, el compilador (en lenguajes como Java o C++) 
		usa un constructor por defecto, sin parámetros, que simplemente crea el objeto 
		sin inicializar los atributos explícitamente (quedarán con sus valores 
		por defecto: null, 0, false, etc.).
	  	Si no hay un constructor dedicado la unica opcion es utilizar getters y setter*/
	}

	//[Metodos]: Funciones que definen el comportamiento del objeto (funciones o procedimientos)
	public void saludar(){
		//this.id = "32342342"; NO se permite la asignacion
		System.out.println("Hola señor soy " + nombre + apellido+ " tengo " + edad + " años y mi id es "+ id);
	}
	//[Objeto]: son las instancias que tienen los atributos y pueden utilizar los metodos de la clase llamada

	// Getter
	public String getID(){ // Este (getters) brinda la posibilidad de poder accader al valor privado (id) pero no modificarlo
		return id;
	}

	// Setter
	public void setEdad(int edad){ // Este (setters) brinda la posibilidad de estableser datos
 		if (edad>0)
 			this.edad = edad;
 		else
 			System.out.println("Edad no valida.");
 	}
 	public int getEdad(){ // Este (getters) brinda la posibilidad de poder accader al valor privado (id) pero no modificarlo
		return edad;
	}
}
/*Generalmente se sigue este orden de creacion: 
	- [atributos->constructores->metodos]*/