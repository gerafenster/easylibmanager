package br.univates.persistencia;

import br.univates.negocio.Usuario;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UsuarioDao extends IDAO<Usuario>
{

    public Usuario readLoginPassword(Usuario usuario) throws DataBaseException;
    
    public Usuario readName(String name) throws DataBaseException;
//    
//    
//    
//    
//    
//    
}
