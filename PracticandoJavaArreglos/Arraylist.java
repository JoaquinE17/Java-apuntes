import java.util.ArrayList; // Importar la utilidad

public class Arraylist{
	public static void main(String[] args){
		/* Es una estructura de datos mas flexible que los arrays, su longitud no es estatica sino DINAMICA (depende del contenido)
		que solo admite datos que no sean primitivos (tipo de dato objeto). No es necesario declarar un tamaño fijo. Su navegacion es mediante funciones 
		Es una estructura ordenada (de acuerdo al ingreso de cada dato)*/
		
		// Declaracion de arraylist
		ArrayList<String> names = new ArrayList<>();
		var number = new ArrayList<Integer>(); // Crear un arraylist de enteros (integer), por que no int por que es un tipo de dato primitivo

		// Saber el tamaño
		System.out.println(names.size()); // Tamaño 0

		// Agregar elementos
		names.add("Josesito");
		names.add("Pablo");
		names.add("Martinez");
		System.out.println(names.size());// Tamaño 3

		// Acceder a elementos del arraylist
		System.out.println(names.get(1));
		//System.out.println(names.getFirst());
		//System.out.println(names.getLast());
		
		// Modificar valor de un elemento
		names.set(1, "Joaquin");
		System.out.println(names.get(1));

		// Eliminar elementos
		names.remove(2); // Elimina el indice 2
		//System.out.println(names.get(2)); ERROR
		System.out.println(names.size()); // Tamaño 2

		// Buscar elementos
		names.contains("Pablo"); // Retorna true o false

		// Limpiar arraylist
		names.clear();
	}
} 