/*
Ejercicio 1: Lista de Estudiantes y Notas (List)
Enunciado:
	Crea una clase Estudiante con los campos:
		- String nombre
		- double notaFinal
	Luego, en el main, hacé lo siguiente:
		Crea una List<Estudiante> y agregá al menos 5 estudiantes con distintas notas.
			- Mostrá todos los estudiantes.
			- Ordená la lista por nota final descendente y mostrála.
			- Eliminá todos los estudiantes que tengan una nota menor a 6.
			- Mostrá la lista final.
Objetivos:
Practicar List
	- Usar Comparator.comparingDouble(...)
	- Usar .removeIf(...)
	- Usar .forEach(...)
Métodos que podrías usar:
	- list.add(...)
	- list.sort(...)
	- list.removeIf(...)
	- list.forEach(...)
	- Comparator.comparingDouble(...)
*/
//package PracticandoJavaColecciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Practica1 {// Clase estudiante
	private String nombre;
	private double notaFinal;
	Practica1(String nombre, double notaFinal){
		this.nombre = nombre;
		this.notaFinal = notaFinal;
	}
	public double getNotaFinal() {
	    return notaFinal;
	}
	@Override
	public String toString() {
	    return "[ Nombre: "+nombre+", Nota Final: "+notaFinal+"]";
	}

	public static void main(String[] args) {
		List<Practica1> estudiantes = new ArrayList<Practica1>();
		Practica1 estudiante1 = new Practica1("Pedro Pascal",67.21);
		estudiantes.add(estudiante1);
		Practica1 estudiante2 = new Practica1("Enzo Perez",23.65);
		estudiantes.add(estudiante2);
		Practica1 estudiante3 = new Practica1("Rocio Arce",45.23);
		estudiantes.add(estudiante3);
		Practica1 estudiante4 = new Practica1("Ana Castro",99.12);
		estudiantes.add(estudiante4);
		Practica1 estudiante5 = new Practica1("Hugo Panza",75.78);
		estudiantes.add(estudiante5);

		System.out.println("Lista original:");
		for (Practica1 student : estudiantes)
			System.out.println(student);

		System.out.println("Lista ordenada (decreciente):");
		estudiantes.sort(Comparator.comparingDouble(Practica1::getNotaFinal));// [Practica1::getNotaFinal]:“Usá el método getNotaFinal() de cada objeto Practica1 para comparar y ordenar.”
		for (Practica1 student : estudiantes)
			System.out.println(student);

		System.out.println("Elementos eliminados:");
		estudiantes.removeIf(est -> {
			if (est.getNotaFinal()<70){
				System.out.println(" "+est);
				return true;
			} 
			return false;
		});
/*
		System.out.println("Elementos eliminados: ");
		int i = estudiantes.size()-1;
		while(i>=0){
			if (estudiantes.get(i).getNotaFinal()<70.0){
				System.out.println(" "+estudiantes.get(i));
				estudiantes.remove(i);
			}
			i--;
		}*/
		System.out.println("Lista final:");
		for (Practica1 student : estudiantes)
			System.out.println(student);
	}
}

/*
Porque querés recorrer todos los elementos de la lista asignaturas, uno por uno, y:
	- No necesitás el índice (i)
	- Solo querés acceder directamente a cada objeto Asignatura para hacer algo con él
¿Qué hace el for-each?
	- Es una forma simplificada y más legible de escribir un bucle for cuando:
	- Solo necesitás leer o modificar cada elemento
	- No vas a hacer nada con el índice (i, j, etc.)

*/