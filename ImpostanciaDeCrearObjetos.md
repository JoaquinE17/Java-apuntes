## IMPORTANCIA DE CREAR OBJETOS EN JAVA  

En **Java** (y en muchos lenguajes orientados a objetos), una clase es como un _plano o molde_. No hace nada por sí misma hasta que creas un `objeto` a partir de ella.  

CLASE vs OBJETO  
---------------  
* _Clase:_ El plano o definición (ej: "Auto", "Calculadora", "Usuario").  
* _Objeto:_ Una `instancia` real de esa `clase` (ej: un auto específico que tiene color rojo y velocidad 100 km/h).  

¿Por qué es importante crear objetos?  
-------------------------------------  
- Porque los **atributos** y **métodos no estáticos** pertenecen al `objeto`, NO a la clase.  
- Si no creas un objeto, no puedes acceder a su estado (`atributos`) ni a sus comportamientos (`métodos de instancia`).
- El **diseño orientado a objetos** te ayuda a _modelar el mundo real_: ***cada objeto tiene su propio estado y comportamiento.***  

## DIFERENCIA ENTRE MÉTODOS ESTÁTICOS Y NO ESTÁTICOS  

METODOS ESTATICOS (static)  
--------------------------  
* **Pertenecen a la clase**, no a una instancia.  
* Se pueden usar sin crear un objeto.  
* Son útiles para operaciones generales que no dependen del estado de un objeto.  
~~~java
public class Utilidades {
    public static int sumar(int a, int b) {
        return a + b;
    }
}

// Usar sin crear objeto
int resultado = Utilidades.sumar(5, 3);
~~~  
+ Aquí, NO necesitas hacer `new Utilidades()` porque _sumar_ es **estático**.  

METODOS NO ESTATICOS (de instancia)  
-----------------------------------  
* Pertenecen a un **objeto específico**.  
* Necesitan que **crees** una _instancia de la clase para poder usarlos_.  
* Pueden acceder y modificar los atributos de instancia.  
~~~java
public class Calculadora {
    double numero1;
    double numero2;

    public double sumar() {
        return numero1 + numero2;
    }
}

// Crear objeto
Calculadora calc = new Calculadora();
calc.numero1 = 10;
calc.numero2 = 5;
System.out.println(calc.sumar()); // 15
~~~
+ Aquí, `sumar()` usa los _atributos_ del **objeto calc**, así que necesitas _instanciar la clase_.  

¿Cuándo usar cada uno?  
----------------------  
+ Usa métodos estáticos cuando:  
    - No necesitas guardar estado.  
    - La función es genérica (como Math.sqrt() o sumar(a, b)).  
    - Estás en una clase de utilidad (como Math, Arrays, etc.).  
+ Usa métodos no estáticos (de instancia) cuando:  
    - La función depende del estado interno del objeto.  
    - Necesitas trabajar con los atributos de la instancia.  

Conclusión  
----------  
+ Crear un objeto (`new Clase()`) te permite usar los **métodos y atributos** que pertenecen a esa _instancia_.  
+ Si algo es **static**, lo puedes usar sin crear objeto, pero no puedes acceder al _estado específico_ de ningún objeto.  
+ **POO** en Java se basa en ___crear y manipular objetos___, por eso entender esta diferencia es esencial para programar bien en Java.  

## ¿QUÉ SON LOS ATRIBUTOS DE INSTANCIA?

* Son _variables_ que pertenecen a cada **objeto**.  
* Cada objeto tiene su propia copia de los atributos.  
* Se declaran fuera de los métodos, dentro de la clase.  
~~~java
public class Persona {
    String nombre;  // atributo de instancia
    int edad;       // atributo de instancia

    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}
~~~  
Ahora imagina esto:
-------------------
~~~java
Persona p1 = new Persona();
p1.nombre = "Ana";
p1.edad = 25;

Persona p2 = new Persona();
p2.nombre = "Luis";
p2.edad = 30;

p1.saludar(); // Hola, soy Ana y tengo 25 años.
p2.saludar(); // Hola, soy Luis y tengo 30 años.
~~~  
+ Cada **objeto** (p1, p2) _tiene sus propios valores de nombre y edad_.  

## QUE ES UNA INSTANCIA EN JAVA  

Una **instancia** es simplemente un `objeto` creado a partir de una `clase`.  

Definición clara:  
----------------  
_Instanciar_ una `clase` significa **crear un objeto** real en _memoria_ basado en la plantilla que define esa `clase`.  
* Ejemplo simple:  
~~~java
public class Perro {
    String nombre;
    int edad;
    
    public void ladrar() {
        System.out.println(nombre + " está ladrando.");
    }
}
~~~  
* Aquí:
    - `Perro` es una **clase** (el molde).  
    - Para usarla, necesitas crear una **instancia** de ella, así:  
    ~~~java
Perro miPerro = new Perro();
miPerro.nombre = "Firulais";
miPerro.edad = 3;

miPerro.ladrar(); // Firulais está ladrando.
    ~~~  

* ¿Qué pasa en esa línea? -> `Perro miPerro = new Perro();`
    - `new Perro()` → crea una nueva instancia de la clase Perro.  
    - `miPerro` → es una referencia que apunta a esa instancia.  
Ahora, puedes acceder a los **atributos** (nombre, edad) y **métodos** (ladrar()) de esa _instancia_.  

!!! Cada instancia es un objeto independiente  
---------------------------------------------  
~~~java
Perro p1 = new Perro();
p1.nombre = "Luna";

Perro p2 = new Perro();
p2.nombre = "Max";

p1.ladrar(); // Luna está ladrando.
p2.ladrar(); // Max está ladrando.
~~~  
+ [p1] y [p2] son dos **instancias diferentes** de la misma **clase**. Cada una tiene su propio _estado_.  

* En resumen:  
    - **Clase**: Plantilla o molde para crear objetos.  
    - **Instancia**: Objeto real creado a partir de una clase.  
    - **Instanciar**: El acto de crear un objeto con new.  
    - **Referencia**: Variable que apunta al objeto en memoria.  

* Frase para recordar:  
> “Una **clase** es como un plano de una casa, y una **instancia** es una casa real construida con ese plano.”  

## QUE SIGNIFICA ESTADO DE UN OBJETO  

* Cuando decimos que un objeto tiene un **estado**, nos referimos a:  
    - Los *valores actuales de sus atributos* (variables de instancia) en un momento determinado.  

¿Qué son los atributos (variables de instancia)?  
------------------------------------------------  
* Son las características o propiedades que _describen al objeto_.
* Cada **objeto** tiene su propia copia de estos **atributos**, y sus valores forman el _estado del objeto_.

* Veamos un ejemplo claro:  
~~~java
public class Persona {
    String nombre;
    int edad;
}
~~~  
+ Aquí, `nombre` y `edad` son _atributos de instancia_.  

* Crear objetos (instancias):  
~~~java
Persona p1 = new Persona();
p1.nombre = "Ana";
p1.edad = 25;

Persona p2 = new Persona();
p2.nombre = "Luis";
p2.edad = 30;
~~~  

* ¿Cuál es el estado de cada objeto?:  
    + El estado de p1 es:  
        - nombre = "Ana"  
        - edad = 25  
    + El estado de p2 es:    
        - nombre = "Luis"  
        - edad = 30  

+ Aunque ambos **objetos** vienen de la misma _clase (Persona)_, tienen `estados distintos` porque sus atributos tienen valores distintos.

Analogía real  
-------------  
Imagina que tienes una plantilla para fabricar autos:
~~~java
class Auto {
    String color;
    int velocidad;
}
~~~  
+ Cada auto fabricado (cada instancia) puede tener un color y velocidad distintos:  
~~~java
Auto auto1 = new Auto();
auto1.color = "Rojo";
auto1.velocidad = 120;

Auto auto2 = new Auto();
auto2.color = "Azul";
auto2.velocidad = 80;
~~~  
+ Entonces:  
    - Estado de auto1: "Rojo", 120  
    - Estado de auto2: "Azul", 80  

Por qué es importante el estado?  
--------------------------------  
El **estado de un objeto** define cómo se comporta o qué representa en un momento dado.  
Un mismo **método** puede producir diferentes resultados dependiendo del estado del `objeto`.
 Ejemplo:  
~~~java
public void mostrarInfo() {
    System.out.println(nombre + " tiene " + edad + " años.");
}
~~~  
+ Este método usará el estado actual del objeto para mostrar la información correcta.

* En resumen:  
    - **Estado**: Es el conjunto de valores actuales de los atributos de un objeto.  
    - **Se guarda en**: Las variables de instancia (atributos).  
    - **Cambia cuando**: Se modifican los atributos del objeto.  
    - **Es único para cada**: Objeto (instancia).  