/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.system32.exemplo;

import br.univates.system32.Entrada;
import br.univates.system32.Validacao;

/**
 *
 * @author mouri
 */
public class TesteValidarCPF
{
    public static void main(String[] args)
    {
        String cpf = Entrada.leiaString("Digite o CPF no formato xxx.xxx.xxx-xx");
        cpf = cpf.replaceAll("[^0-9]","");
        if (Validacao.validarCPF(cpf))
        {
            System.out.println("Está correto");
        }
        else
        {
            System.out.println("Está errado");
        }
        System.exit(0);
    }
}
