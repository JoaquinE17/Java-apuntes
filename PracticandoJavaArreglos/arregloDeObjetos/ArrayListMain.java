import java.util.ArrayList; // Impertar la clase ArrayList
class ArrayListMain{
	public static void main(String[] args){
		
		// Crea un ArrayList de objetos Persona
		ArrayList<Persona> clientes = new ArrayList<>();

		// Agregar objetos a la lista
		clientes.add(new Persona("Pablo",12));
		clientes.add(new Persona("Cristina",15));
		clientes.add(new Persona("Rodrigo",23));
		
		// Mostrar
		for (Persona n : clientes)
			n.mostrar();

	}
}