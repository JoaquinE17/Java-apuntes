package AccesoDatos;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	private List<Cliente> clientes = new ArrayList<>();

	public ClienteDAO(){
		clientes.add(new Cliente(1, "Jose Perez", "josepQgmail.com"));
		clientes.add(new Cliente(1, "Jose Perez", "josepQgmail.com"));
		clientes.add(new Cliente(1, "Jose Perez", "josepQgmail.com"));
	}
}