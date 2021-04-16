package br.univates.dao;

import br.univates.model.Usuario;
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
