package br.univates.persistencia;

import br.univates.negocio.Cliente;
import br.univates.negocio.Usuario;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;
import java.util.ArrayList;

public interface ClienteDao extends IDAO<Cliente>
{
    public Cliente readName(String name) throws DataBaseException;
    public Cliente readCpf(String cpf) throws DataBaseException;
    public ArrayList<Cliente> readFilter(Cliente cliente) throws DataBaseException;
//    
//    
//    
//    
//    
//    
//    
}
