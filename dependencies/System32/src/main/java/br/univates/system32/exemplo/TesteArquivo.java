package br.univates.system32.exemplo;

import br.univates.system32.Arquivo;

public class TesteArquivo
{

    public static void main(String[] args)
    {
        Arquivo x = new Arquivo("teste.txt");

        if (x.abrirEscrita())
        {
            x.escreverLinha("esta é a primeira linha");
            x.escreverLinha("oi tudo bem");
            x.escreverLinha("lkgjlkasdfjlkafsdj");

            x.fecharArquivo();
        }

        if (x.abrirLeitura())
        {
            String linha = "";
            while (linha != null)
            {
                linha = x.lerLinha();
                System.out.println(linha);
            }
            x.fecharArquivo();
        }

    }
}
