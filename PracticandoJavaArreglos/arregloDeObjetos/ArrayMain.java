class ArrayMain{
	public static void main(String[] args){
		Persona[] clientes = new Persona[3]; // Es igual a decir 'Personas clientes = new Personas[3]'
		clientes[0] = new Persona("Ana",24);
		clientes[1] = new Persona("Jorge",20);
		clientes[2] = new Persona("Maria",25);

		for(Persona n : clientes){
			n.mostrar();
		}
		
	}
}