package AccesoDatos;

public class Cliente {

	private int id;
	private String nombre;
	private String email;

	public Cliente(int id, String nombre, String email){
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public int getId(){return this.id;}

	public String getNombre(){return this.nombre;}

	public String getEmail(){return email;}
}