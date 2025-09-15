## Explicacion de COLECCIONES en java:  

![Esquema de Colecciones](/diagramaColecciones.png)  
 + Tomando como referencia la imagen se explicaran a continuacion los conceptos tratados.   

### 1. Qué representa el diagrama (leyenda)  

Interfaz: define comportamiento (métodos) sin implementación (por ejemplo List, Set, Map).

Clases implementadoras: clases concretas que implementan la interfaz (por ejemplo ArrayList, HashSet, HashMap).

La imagen también marca con un asterisco las clases sincronizadas (seguras para hilos) en la implementación clásica.

### 2. Interfaces principales  

* Collection
	+ Es la interfaz raíz para colecciones de elementos (listas, conjuntos, colas). Define operaciones básicas: add, remove, contains, size, iterator, etc.
[Nota]: Map no extiende Collection (es una estructura de pares clave-valor distinta).

* List
	+ Una colección ordenada con índices (posiciones). Permite duplicados y acceso por índice.
	+ Implementaciones típicas: ArrayList, LinkedList, Vector.
	+ Operaciones típicas: get(index), add(index, e), remove(index), set(index, e).

* Set
	+ Colección que NO permite duplicados (cada elemento es único). No asegura orden (depende de implementación).
	+ Implementaciones típicas: HashSet, TreeSet.
	+ SortedSet (y NavigableSet)
	+ SortedSet extiende Set y mantiene los elementos en orden. NavigableSet añade operaciones como lower(), higher(), ceiling(), floor().
	+ Implementación habitual: TreeSet (orden natural o con Comparator).

* Map
	+ Estructura de pares clave → valor. No es Collection. Operaciones: put, get, remove, containsKey, keySet, values, entrySet.
	+ Implementaciones: HashMap, TreeMap, Hashtable.
	+ SortedMap (y NavigableMap)
	+ SortedMap mantiene las claves ordenadas; NavigableMap añade métodos de navegación. Ejemplo: TreeMap.

### 3. Implementaciones importantes (qué hacen y cuándo usarlas)  

* ***ArrayList***
	+ Implementa List con un array dinámico.
	+ Acceso por índice: O(1). Insertar/Eliminar en medio: O(n).
	+ add(e) al final es amortizado O(1).
	+ No es sincronizada (si necesitas sincronía usar Collections.synchronizedList(...) o clases de concurrencia).
	+ Uso: cuando necesitas acceso rápido por índice y pocas inserciones/remociones en medio.

* ***LinkedList***
	+ Implementa List (y Deque) como lista doblemente enlazada.
	+ get(i) es O(n) (malo para acceso aleatorio). Insertar/remover al principio/fin es O(1).
	+ Útil para colas/deques o cuando haces muchas inserciones/remociones en extremos.

* ***Vector***
	+ Similar a ArrayList pero sincronizado (legacy). Hoy en día se evita en favor de ArrayList o colecciones concurrentes.
	+ Tiene capacityIncrement y métodos heredados.

* ***HashSet***
	+ Backed por un HashMap internamente. No permite duplicados.
	+ Operaciones add, contains, remove promedio O(1) (depende de hashCode() y equals()).
	+ Desordenado: el orden no está garantizado.
	+ Permite un null (sí, HashSet acepta null).

* ***TreeSet***
	+ Implementa SortedSet (usualmente un árbol rojo-negro). Operaciones O(log n).
	+ Mantiene los elementos ordenados (por orden natural o por Comparator).
	+ No permite null si la comparación no soporta null (con orden natural null provoca NullPointerException).

* ***HashMap***
	+ Implementa Map con hashing. put, get, remove promedio O(1) (a depender de hashCode()).
	+ Permite una clave null y valores null.
	+ No ordenado.

* ***Hashtable***
	+ Versión antigua y sincronizada de HashMap. No acepta claves ni valores null.
	+ Hoy en día se prefiere HashMap + sincronización externa o ConcurrentHashMap.

* ***TreeMap***
	+ Implementa SortedMap con árbol (O(log n)). Mantiene las claves ordenadas.
	+ No permite null si la comparación natural no lo acepta.

### 4. Iteradores y enumeraciones (recorrido de colecciones)  

* **Iterator<E>**
	+ Métodos: hasNext(), next(), remove() (este último elimina el elemento retornado por next() de forma segura).
	+ La mayoría de iteradores son fail-fast: si la colección se modifica estructuralmente fuera del iterador (p. ej. desde otro hilo o con collection.remove(obj)), el iterador detecta y lanza ConcurrentModificationException. La excepción es detección, no garantía de corrección concurrente.
	+ El bucle for-each usa internamente un Iterator.

* **ListIterator<E>**
	+ Extiende Iterator para listas: hasPrevious(), previous(), nextIndex(), previousIndex(), add(e), set(e). Permite iterar en ambos sentidos y modificar la lista durante la iteración de forma controlada.

* **Enumeration**
	+ Interfaz antigua: hasMoreElements(), nextElement(). Usada por Vector, Hashtable antiguamente.
	+ No soporta remove() y no es fail-fast (no detecta modificaciones concurrentes). Hoy en día se prefiere Iterator.

### 5. Comparable vs Comparator  

* **Comparable<T>:** 
	+ La clase T implementa compareTo(T o) → define su orden natural. Ej:  
~~~java
class Persona implements Comparable<Persona> { ... public int compareTo(Persona o) { return this.edad - o.edad; } }.
~~~
* **Comparator<T>:** 
	+ Objeto externo que define un orden distinto. Es útil cuando no puedes modificar la clase o necesitas varios criterios. Es una interfaz funcional (se puede usar lambda).
	+ Se usan con Collections.sort(list) o list.sort(comparator) y con TreeSet, TreeMap al pasar un Comparator.
	- Ejemplo rápido Comparator (Java 8+):
~~~java
List<String> lista = Arrays.asList("manzana","pera","uva");
lista.sort(Comparator.comparingInt(String::length)); // ordena por longitud
~~~

### 6. Clases utilitarias: Collections y Arrays  

* **Collections (con 's')**
	+ Es una clase de utilidades para trabajar con colecciones: sort, binarySearch, shuffle, reverse, synchronizedList, unmodifiableList, emptyList, etc.
	- Ejemplo: `List<String> sync = Collections.synchronizedList(new ArrayList<>());`
		- Ojo: cuando iteres sobre sync debes sincronizar externamente:
~~~java
synchronized(sync) {
    for (String s : sync) { ... } // evitar concurrent modification
}
~~~
* **Arrays**
	+ Utilidades para arreglos: sort, binarySearch, asList, copyOf, etc.
	+ Arrays.asList(...) produce una lista fija (vista sobre el array), ojo con add/remove (lanzan UnsupportedOperationException).

### 7. Comportamientos importantes y recomendaciones prácticas  

+ Elegir por uso:
	- Necesitas acceso por índice frecuente → ArrayList.
	- Muchas inserciones/eliminaciones por los extremos → LinkedList o mejor ArrayDeque.
	- No quieres duplicados → HashSet (rápido) o TreeSet (si necesitas orden).
	- Map clave→valor sin orden → HashMap. Si necesitas orden por clave → TreeMap.
	- Nulls: HashMap permite null key/values; Hashtable no. TreeMap/TreeSet con orden natural no aceptan null.
	- Concurrencia: evitar Vector y Hashtable hoy en día; usar Collections.synchronized* o mejor java.util.concurrent (ConcurrentHashMap, CopyOnWriteArrayList, etc.) según necesidad.
	- Iteradores: usa Iterator.remove() para eliminar mientras iteras; no modifiques la colección por fuera o lanzará ConcurrentModificationException (fail-fast).
	- Rendimiento: Hash* (map/set) tiene accesos promedio O(1); Tree* O(log n). ArrayList es excelente para lectura y acceso aleatorio.

### 8. Ejemplos cortos (Java) — uso y diferencias

~~~java
// ArrayList vs LinkedList
List<Integer> al = new ArrayList<>();
al.add(1); al.add(2); al.add(0, 99); // get rápido

List<Integer> ll = new LinkedList<>();
ll.add(1); ll.add(2);
((LinkedList<Integer>)ll).addFirst(0); // insertar al inicio es O(1)

// HashSet
Set<String> hs = new HashSet<>();
hs.add("a"); hs.add("b"); hs.add("a"); // solo queda "a","b"

// TreeSet con Comparator
Set<String> ts = new TreeSet<>(Comparator.reverseOrder());
ts.addAll(Arrays.asList("b","a","c")); // orden inverso: c,b,a

// HashMap
Map<String,Integer> map = new HashMap<>();
map.put("uno",1); map.put("dos",2);
int v = map.get("uno");

// Iterador seguro para eliminar
Iterator<String> it = hs.iterator();
while(it.hasNext()){
    String s = it.next();
    if (s.equals("b")) it.remove(); // correcto
}
~~~

### 9. Resumen breve (cuando usar qué)
   + **`ArrayList`**: acceso rápido por índice.
   + **`LinkedList`**: muchas inserciones/eliminaciones en extremos.
   + **`HashSet`**: conjunto único, rápido, sin orden.
   + **`TreeSet`**: conjunto ordenado.
   + **`HashMap`**: mapeo clave→valor, rápido.
   + **`TreeMap`**: mapeo ordenado por clave.
   + **`Vector`**/Hashtable: legacy, sincronizados (mejor evitar hoy).
   + **`Iterator`**/ListIterator: recorrer y modificar de forma segura.
   + **`Comparator`**: ordenar externo, reusable.
   + **`Collections/Arrays`**: utilidades varias (ordenar, envolver en sincronizados, convertir).

----------------------------------------------------------------------------------------------------

¡Excelente! 🚀
Si recién estás entrando en el tema de colecciones en Java, lo mejor es empezar con una visión clara, sencilla y organizada. Te armo una guía paso a paso para que construyas una base sólida.

### 1. ¿Qué es una colección?

Una colección es un contenedor de objetos que te permite almacenar, acceder y manipular un conjunto de datos de manera más flexible que un simple array.
* Con un array:
~~~java
int[] numeros = {1,2,3};
~~~
   + Tamaño fijo.
   + Métodos limitados.
* Con una colección:
~~~java
List<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);
~~~
   + Tamaño dinámico.
   + Métodos poderosos (add, remove, contains, sort, etc.).

### 2. El árbol principal de colecciones

* Imaginálo como una familia:
	1) **Collection**
		- La interfaz mamá de casi todas las colecciones. Define operaciones básicas (add, remove, size, iterator).
* De aquí salen dos ramas importantes:
	+ List → lista ordenada, con índices, admite duplicados.
	+ Set → conjunto, sin duplicados.
[Importante]: Map no hereda de Collection porque no guarda elementos sueltos, sino pares clave→valor.

	2) **List (lista)**
		- Ordenada, accesible por índice.
		- Permite duplicados.
		- Ejemplos:
			+ `ArrayList` → rápido en acceso por índice.
			+ `LinkedList` → rápido en inserciones/eliminaciones.
			+ `Vector` → versión vieja, sincronizada.
 ~~~java
List<String> frutas = new ArrayList<>();
frutas.add("Manzana");
frutas.add("Pera");
frutas.add("Pera"); // duplicados permitidos
 ~~~

	3) **Set (conjunto)**
	- No permite duplicados.
	- No usa índice, solo elementos únicos.
	- Ejemplos:
		+ `HashSet` → rápido, desordenado.
		+ `TreeSet` → mantiene ordenado.
 ~~~java
Set<String> colores = new HashSet<>();
colores.add("Rojo");
colores.add("Azul");
colores.add("Rojo"); // ignorado, ya existe
 ~~~

	4) **Map (diccionario)**
	- Estructura de pares clave→valor.
	- La clave es única, el valor puede repetirse.
	- Ejemplos:
		+ `HashMap` → rápido, desordenado.
		+ `TreeMap` → ordena por clave.
~~~java
Map<String,Integer> edades = new HashMap<>();
edades.put("Ana", 20);
edades.put("Luis", 25);
edades.put("Ana", 30); // reemplaza el valor de "Ana"
~~~  

### 3. Cómo recorrer colecciones

* Para acceder a sus elementos, usamos:

	1) For-each (lo más común)
 ~~~java
for(String fruta : frutas){
    System.out.println(fruta);
}
 ~~~

	2) Iterator
 ~~~java
Iterator<String> it = frutas.iterator();
while(it.hasNext()){
    System.out.println(it.next());
}
 ~~~
	3) ListIterator (sólo listas)
		- Permite ir hacia adelante y atrás:
 ~~~java
ListIterator<String> it = frutas.listIterator();
while(it.hasNext()){
    System.out.println(it.next());
}
~~~

### 4. Orden y comparadores

* Cuando necesitamos ordenar:
	- Comparable → el objeto sabe cómo compararse (compareTo).
	- Comparator → reglas externas de comparación (útil si querés varios criterios).
	+ Ejemplo con Comparator:
 ~~~java
frutas.sort(Comparator.comparingInt(String::length)); // por longitud
 ~~~  

### 5. Clases utilitarias

* `Collections` → métodos para colecciones (sort, reverse, shuffle, synchronizedList, etc.).
* `Arrays` → utilidades para arrays (sort, asList, etc.).

### 6. Resumen fácil (cuándo usar qué)

`Interfaz/Clase:`	`¿Para qué sirve?:`
-	ArrayList			Lista rápida para leer, lenta al insertar en medio.
-	LinkedList			Lista buena para colas e inserciones.
-	HashSet				Conjunto rápido, sin orden.
-	TreeSet				Conjunto ordenado.
-	HashMap				Diccionario rápido, clave→valor.
-	TreeMap				Diccionario ordenado por clave.

### 7. Idea sólida

* Colecciones = estructuras listas para almacenar y manipular grupos de objetos.
	+ Se dividen en `List, Set y Map`.
	+ Se recorren con `for-each` o `iteradores`.
	+ Se ordenan con `Comparable/Comparator`.
	+ Se apoyan en `Collections` y `Arrays` para *operaciones comunes*.
* Lo más recomendable es empezar jugando con ArrayList, HashSet y HashMap, ya que son las más usadas en la práctica.

----------------------------------------------------------------------------------------------------

### Vamos a hacer un ejemplo práctico en Java usando ArrayList, HashSet y HashMap, para que veas sus diferencias en la misma situación.

* Ejemplo: lista de nombres de personas
	- Queremos guardar nombres de personas y trabajar con ellos:
	- Guardarlos en una lista (puede haber repetidos).
	- Guardarlos en un conjunto (sin repetidos).
	- Guardarlos en un mapa con su edad (clave = nombre, valor = edad).

Código en Java
--------------
~~~java
import java.util.*;

public class EjemploColecciones {
    public static void main(String[] args) {
        
        // 1. LISTA (ArrayList)
        System.out.println("---- ArrayList ----");
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Ana");
        listaNombres.add("Luis");
        listaNombres.add("Ana"); // duplicado permitido
        
        System.out.println("Lista con duplicados: " + listaNombres);
        
        // Recorrido con for-each
        for(String nombre : listaNombres){
            System.out.println("Nombre: " + nombre);
        }
        
        
        // 2. CONJUNTO (HashSet)
        System.out.println("\n---- HashSet ----");
        Set<String> conjuntoNombres = new HashSet<>();
        conjuntoNombres.add("Ana");
        conjuntoNombres.add("Luis");
        conjuntoNombres.add("Ana"); // duplicado ignorado
        
        System.out.println("Conjunto sin duplicados: " + conjuntoNombres);
        
        
        // 3. MAPA (HashMap)
        System.out.println("\n---- HashMap ----");
        Map<String,Integer> mapaEdades = new HashMap<>();
        mapaEdades.put("Ana", 20);
        mapaEdades.put("Luis", 25);
        mapaEdades.put("Ana", 30); // reemplaza valor de "Ana"
        
        System.out.println("Mapa (nombre → edad): " + mapaEdades);
        
        // Recorrido de claves y valores
        for(String clave : mapaEdades.keySet()){
            System.out.println(clave + " tiene " + mapaEdades.get(clave) + " años.");
        }
    }
}
~~~

Salida del programa
-------------------
* ***ArrayList***
	+ Lista con duplicados: [Ana, Luis, Ana]
		- Nombre: Ana
		- Nombre: Luis
		- Nombre: Ana

* ***HashSet***
	+ Conjunto sin duplicados: [Luis, Ana]   // el orden puede variar

* ***HashMap***
	+ Mapa (nombre → edad): {Luis=25, Ana=30}
		- Ana tiene 30 años.
		- Luis tiene 25 años.

### Lo que aprendimos

   + ArrayList permite duplicados y mantiene el orden de inserción.

   + HashSet elimina duplicados automáticamente y no garantiza orden.

   + HashMap asocia clave→valor y si repites clave, se reemplaza el valor.

* Este ejemplo es clave porque muestra la misma información representada en tres colecciones distintas, cada una útil en un contexto diferente.