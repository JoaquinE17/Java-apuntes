public class Persona{
	String names;
	int age;

	public Persona(String names, int age){
		this.names = names;
		this.age = age;
	}

	public void mostrar(){
		System.out.println("Nombre "+names+", Edad: "+age); // No es necesario colocar 'this'
	}
}