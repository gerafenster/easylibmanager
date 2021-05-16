package br.univates.negocio;

import java.math.BigDecimal;

public class Definicoes
{
    private BigDecimal valorMulta;
    private int prazoEmprestimo;

    public Definicoes(BigDecimal valorMulta, int prazoEmprestimo)
    {
        this.valorMulta = valorMulta;
        this.prazoEmprestimo = prazoEmprestimo;
    }

    public BigDecimal getValorMulta()
    {
        return valorMulta;
    }

    public void setValorMulta(BigDecimal valorMulta)
    {
        this.valorMulta = valorMulta;
    }

    public int getPrazoEmprestimo()
    {
        return prazoEmprestimo;
    }

    public void setPrazoEmprestimo(int prazoEmprestimo)
    {
        this.prazoEmprestimo = prazoEmprestimo;
    }
    
    
}
