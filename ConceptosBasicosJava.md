1. CLASE:  
Una **Clase** es una _plantilla para objetos_. Define _propiedades_ (**atributos**) y comportamientos (**metodos**).  
~~~java
public class Persona {
    String nombre;   // atributo
    int edad;        // atributo

    void saludar() { // método
        System.out.println("Hola, soy " + nombre);
    }
}

~~~  
> _Ejemplo real_: Imagina una clase Auto. Todos los autos tienen marca, color, velocidad. Esa es la plantilla. Cada auto específico (tu auto, mi auto) es un objeto creado a partir de esa clase.  

2. OBJETO:  
Un **objeto** es una instancia de una clase. Es como decir: "Ahora tengo un auto especifico basado en la clase Auto".  
~~~java
Persona p = new Persona(); // p es un objeto de tipo Persona
~~~  

3. ATRIBUTO: (o campo)  
Un **atributo** es una variable que pertenece a una clace u objeto.  
~~~java
String nombre;  // Atributo de la clase Persona
~~~  

4. METODO:  
Un **metodo** es una funcion que pertenece a una clase. -define el comportamiento.  
~~~java
void saludar() {
    System.out.println("Hola");
}
~~~  
 + Metodo estatico:  
  	Un metodo o atributo estatico pertenece a la clase, no a un atributo especifico.  
  	Por ejemplo: `public static void main(String[] args)`
  	* Aqui _main_ es un metodo estatico, lo que significa que Java puede ejecutarlo sin tener que crear un objeto.  
  Ejemplo:  
 ~~~java
public class Util {
    static int sumar(int a, int b) {
        return a + b;
    }
}
// Se llama asi: Util.sumar(3,4);
 ~~~  

### Explicacion de codigo:  
Ejemplo:  
-------  
~~~java
import java.util.Scanner;

public class Intro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Hola, " + nombre);
    }
}
~~~
Desmenuzado:  
-----------  
~~~java
import java.util.Scanner;
~~~  
Esto **importa** la clase `Scanner` desde la libreria estandar de Java (_java.util_) para poder leer datos del teclado.  

~~~java
public class Intro {
~~~  
Se define una **clase** llamada `Intro`. Debe coincidir con el nombre del archivo `Intro.java`.  

~~~java
	public static void main(String[] args) {
~~~  
Método principal (main) donde comienza la ejecución del programa.  
Es **public** (accesible desde fuera), **static** (no necesita objeto para ejecutarse), y _no devuelve nada_ (**void**).  

~~~java
        Scanner scanner = new Scanner(System.in);
~~~  
Se crea un **objeto** llamado _scanner_ de la **clase Scanner**.  
**System.in** es el flujo de entrada estándar, o sea, el teclado.  
Esto permite leer lo que el usuario escriba.  

~~~java
        System.out.print("Ingresa tu nombre: ");
~~~  
Muestra un mensaje en pantalla, sin salto de línea (print, no println).  
Sirve para pedir al usuario que escriba algo.  

~~~java
        String nombre = scanner.nextLine();
~~~  
Se lee una línea completa de texto ingresada por el usuario.  
El texto se guarda en una variable tipo String llamada nombre.  

~~~java
        System.out.println("Hola, " + nombre);
~~~  
Se muestra un saludo con el nombre ingresado.  
El símbolo + concatena (une) texto con la variable nombre.  

---------------------------------------------------------

¿Qué deberías tener en cuenta como principiante en Java?  

- Sigue las convenciones de nombres (clases con mayúscula, variables con minúscula).  
- Aprende las estructuras básicas: variables, condicionales (if), bucles (for, while), métodos.  
- Usa System.out.print y Scanner para interactuar.  
- Estudia la diferencia entre clases y objetos.  
- Practica escribiendo tus propias clases y métodos.  
- Usa un IDE como IntelliJ o VS Code con el plugin de Java para ayudarte.  

---------------------------------------------------------  

CURSO JAVA [@Mouredev]https://www.youtube.com/watch?v=JOAqpdM36wI 
1:27:20