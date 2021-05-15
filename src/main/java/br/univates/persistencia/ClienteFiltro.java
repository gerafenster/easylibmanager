/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import br.univates.negocio.Cliente;
import br.univates.system32.db.Filter;

/**
 *
 * @author cristian
 */
public class ClienteFiltro implements Filter<Cliente>
{

    private String cpf;

    public ClienteFiltro(String cpf)
    {
        this.cpf = cpf;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    @Override
    public boolean isApproved(Cliente cliente)
    {
        if (cliente.getCpf().equals(cpf))
        {
            return true;
        }
        return false;
    }

}
