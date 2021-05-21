package br.univates.persistencia;

import br.univates.negocio.Autor;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.IDAO;
import java.util.ArrayList;

public interface AutorDao extends IDAO<Autor>
{
    public Autor readName(String name) throws DataBaseException;
    public ArrayList<Autor> readFilter(Autor autor) throws DataBaseException;
//    
//    
//    
//    
//    
//    
}
