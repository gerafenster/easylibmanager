package br.univates.persistencia;

public class Validacao2
{

    public static boolean validarIsbn(String isbn)
    {
        return !(isbn == null || (isbn.length() != 11 && isbn.length() != 13));
    }

    public static boolean validarAno(int ano)
    {
        return !(ano < 1450 || ano > 2021);
    }
    
}