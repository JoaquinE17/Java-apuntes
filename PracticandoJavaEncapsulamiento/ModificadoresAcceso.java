public class ModificadoresAcceso{ // Las cclases por buena practica son Publicas
// Si se arma una clase privada, ésta NO podra ser accedida desde otras partes del programa. 
/*NO se recomienda hacer una clase privada: 'private class ModificadoresAcceso' */
	public static void main(String[] args) {
		
		// ENCAPSULAMIENTO (modificadores de acceso) -> {public,private,protected}

		/*Objetivo Principal: proteger los datos de una clase, para poder controlar 
		el acceso desde fuera de esta */

		// [public]: Se puede acceder desde cualquier parte del programa

		// [private]: Restringe el acceso al objeto/calse/metodo/atributo que se lo aplique. Solo se puede acceder desde dentro de la clase en donde se encuentre

		// [protected]: Significa que SOLO se puede acceder dentro de la clase y de las subclases

		// (default): Permite trabajar/acceder solo desde dentro del mismo paquete (carpeta/estructura que compone el archivo .java)

		// [getters] Una forma de leer variables privadas
		// [setters] Una forma de establecer condisiones al asignar o solo asignar vlores
		/*Son metodos/funciones que creamos para poder permitir el acceso
		 a la variable en cuestion, a la cual hemos limitado el acceso */
		
	}
}