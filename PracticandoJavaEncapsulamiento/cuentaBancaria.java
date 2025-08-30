public class cuentaBancaria{
	final private int id; 
	private String nombre;
	private double fondo;

	public cuentaBancaria(int id, String nombre, double fondo){
		if (id <= 100) {
			throw new IllegalArgumentException("El ID debe ser mayor a 100"); // Exepciones: para validar atributos declarados "final private"
		}
		this.id=id;
		this.nombre = nombre;
		this.fondo = fondo;
	}

	public void mostrarCuenta(){
		System.out.println("Informcion de cuenta:\n ID: "+id+"\n Nombre: "+nombre+"\n Fondo: $ "+fondo);
	}
}