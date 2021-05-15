/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Emprestimo;
import br.univates.system32.db.Filter;

/**
 *
 * @author cristian
 */
public class EmprestimoFiltro implements Filter<Emprestimo>
{

    @Override
    public boolean isApproved(Emprestimo emprestimo)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
