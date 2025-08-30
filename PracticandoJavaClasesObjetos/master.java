
// Punto de entrada
public class master{								// Estructura
	public static void main(String[] args){			// Basica
		var per1 = new persona("Jorge","Ramirez", 24, "1231231"); // [var]: Evita redundancia infiereiendo el tipo de dato que se quiere instanciar
		//per1.nombre = "Jorge";
		//per1.edad = 24;
		per1.saludar();

		//person.id = 223423; NO esposible esta accion, porque el elemento es pirvado
		System.out.println(per1.nombre+per1.apellido/*+per1.edad+per1.id*/);
		System.out.println(per1.getEdad());
		System.out.println(per1.getID()); // La unica forme de obtener el id es con get (funcion creda, nombrada asi por convencion)
		
	}
}