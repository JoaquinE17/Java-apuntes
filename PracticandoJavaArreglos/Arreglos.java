public class Arreglos{
	public static void main(String [] args){
		int[] lista = new int[5]; // Declaracion y creacion de arreglo de enteros
		for (int i=0; i<lista.length; i++){ // Alternativa clasica para recorrer el arreglo (indices)
			lista[i] = i+1;
		}
		/* Es una estructura de datos que almacena datos indexsados, ordenados (respetan el orden que son ingresados), son inmutables
		Los indices de  empiezan desde 0, es decir si creas 'int[3] los indices seran {0,1,2}
		 En los Arrays no se pueden eliminar datos, solo se pueden asignarles el valor por defecto (null, 0, false)*/

		System.out.print("Valores iniciales: ");
		for (int n : lista) { // Uso de foreach para recorrer el arreglo (valor almacenado)
			System.out.print(n+",");
		}
		System.out.println("\n");

		for (int j : lista){
			if (j == 3)
				lista[j] = 0; // Modificacion de un arreglo
		}
		System.out.print("Valores modificados: ");
		for (int n : lista) {
			System.out.print(n+",");
		}
		System.out.println("\n");

		// Inicializacion directa
		int[] lista2 = {12,13,14,15,16,17};
		String[] nombres = new String[] {"jose","ana","pepe","maria"};
		// Saber el tamaño del arreglo
		for (String n : nombres) {
			System.out.print(n+",");
		}
		System.out.println("");
		System.out.println("Longitud de lista de nombres: "+nombres.length+"\n"); // Utilizacion de length para obtener la longitud

		for (int n : lista2) {
			System.out.print(n+",");
		}
		System.out.println("");
		System.out.println("Longitud de lista de numeros: "+lista2.length+"\n");

		// Arreglos multidimencionales
		int[][] matriz = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		for (int[] n : matriz) {
			for (int e : n){
				System.out.print(e+",");
			}
		}
		System.out.println("\n");

		System.out.println((new String[4])[0]);// Crea un Array y accede al primer elemento en una sola linea


	}
}


// Habilidad blanda == tolerancia a la frustracion