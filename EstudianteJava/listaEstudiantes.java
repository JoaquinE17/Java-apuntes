

class listaEstudiantes{

	public static void main(String[] args){
		EstudianteOOP estudent1 = new EstudianteOOP("jose","ramirez",5,"Ing. Sistemas");

		/*//carreraEstudiantes titulo1 = new carreraEstudiantes(); // Instanciar
		estudent1.nombre = "Jorge";
		estudent1.apellido = "Armando";
		estudent1.edad = 34;
		estudent1.esEstudiante = true;
		//titulo1= "Ing. Informatica";
		//titulo1 = 4;
		estudent1.titulo.nombre = "Ing. Informatica";

		// Nuevo estidiante
		EstudianteOOP estudent2 = new EstudianteOOP(); 
		//carreraEstudiantes titulo2 = new carreraEstudiantes(); // Se puede obviar este paso, creando un constructor
		estudent2.nombre = "Maria Jose";
		estudent2.apellido = "Hernandez";
		estudent2.edad = 27;
		estudent2.esEstudiante = false;
		estudent2.titulo.duracion = 3;
		//estudent2.titulo = titulo2;*/

		System.out.println(estudent1.nombre+" / "+estudent1.edad+" / "+estudent1.esEstudiante);
		//System.out.println(estudent2.nombre+" / "+estudent2.edad+" / "+estudent2.esEstudiante);

		System.out.println("\nHola soy "+estudent1.imprimirNombre()+" el profesor de "+estudent1.titulo.nombre);
		System.out.println(estudent1.saludar(estudent1.nombre));
		//System.out.println(estudent2.saludar(estudent2.nombre)+" este es tu "+estudent2.titulo.duracion+"er año en la carrera");

	}
}