package br.univates.negocio;

import java.time.LocalDate;

public class Emprestimo
{
    
    int id;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    Cliente cliente;
    Livro livro;

    public Emprestimo(int id, LocalDate dataEmprestimo, LocalDate dataDevolucao, Cliente cliente, Livro livro)
    {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.cliente = cliente;
        this.livro = livro;
    }

    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucao, Cliente cliente, Livro livro)
    {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
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

    public LocalDate getDataDevolucao()
    {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao)
    {
        this.dataDevolucao = dataDevolucao;
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
