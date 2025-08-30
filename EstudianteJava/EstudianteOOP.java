

public class EstudianteOOP{

	// ATRIBUTOS (Definen el estado y caracteristicas de un objeto)
	String nombre; 	
	String apellido; 
	int edad; 			
	boolean esEstudiante;
	carreraEstudiantes titulo;

	// CONSTRUCTOR
	public EstudianteOOP(String nombre, String apellido, int edad, String nameCarr){ 
		titulo = new carreraEstudiantes();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.titulo.nombre = nameCarr;
		/*[this] se utiliza para acceder a variables de instancia o metodos de la 
		clase actual y puede ser util para evitar ambiguedades en casos donde hay nombres
		de variables locales que coinciden con nombres de variables de instancia.*/
	}

	// METODOS (comportamiento de un objeto)
	public String imprimirNombre(){
		return nombre+" "+apellido;
	}

	public String saludar(String name){
		if (edad > 30)
			return "Buenas tardes "+name;
		return "Hola "+name;
	}
}