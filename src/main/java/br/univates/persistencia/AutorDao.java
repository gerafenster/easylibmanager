package br.univates.dao;

import br.univates.model.Autor;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;

public interface AutorDao extends IDAO<Autor>
{
    public Autor readName(String name) throws DataBaseException;
//    
//    
//    
//    
//    
//    
}
