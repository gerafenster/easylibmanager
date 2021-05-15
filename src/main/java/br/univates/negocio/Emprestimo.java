package br.univates.negocio;

import java.time.LocalDate;

public class Emprestimo
{
    
    int id;
    LocalDate dataEmprestimo;
    LocalDate dataDevolução;
    Cliente cliente;
    Livro livro;

    public Emprestimo(int id, LocalDate dataEmprestimo, LocalDate dataDevolução, Cliente cliente, Livro livro)
    {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolução = dataDevolução;
        this.cliente = cliente;
        this.livro = livro;
    }

    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataDevolução, Cliente cliente, Livro livro)
    {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolução = dataDevolução;
        this.cliente = cliente;
        this.livro = livro;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public LocalDate getDataEmprestimo()
    {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo)
    {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolução()
    {
        return dataDevolução;
    }

    public void setDataDevolução(LocalDate dataDevolução)
    {
        this.dataDevolução = dataDevolução;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Livro getLivro()
    {
        return livro;
    }

    public void setLivro(Livro livro)
    {
        this.livro = livro;
    }

        
}
