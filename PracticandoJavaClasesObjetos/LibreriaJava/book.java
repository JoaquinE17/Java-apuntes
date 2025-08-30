public class book{

	//Atributos
	String titulo;
	String autor;

	//Constructor
	public book(String titulo, String autor){
		this.titulo="' "+titulo+" '";
		this.autor=autor;
	}

	//Metodos
	public void verDatos(){
		System.out.println("El libro "+titulo+" del autor "+autor);
	}
}