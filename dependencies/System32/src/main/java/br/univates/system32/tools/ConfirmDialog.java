package br.univates.system32.tools;

import br.univates.system32.menu1.ConfigMenu;
import br.univates.system32.menu1.Menu;

public class ConfirmDialog
{
    private boolean confirma;
    private String questionamento;

    public ConfirmDialog(String questionamento)
    {
        this.confirma = false;
        this.questionamento = questionamento;
    }

    public boolean isConfirmado()
    {
        Menu m = new Menu(new ConfigMenu()
        {
            @Override
            public int getNumItens()
            {
                return 2;
            }

            @Override
            public char getAtalho(int i)
            {
                char[] at =
                {
                    'S', 'N'
                };
                return at[i];
            }

            @Override
            public String getDesc(int i)
            {
                String[] des =
                {
                    "Sim", "Não"
                };
                return des[i];
            }

            @Override
            public void executar(int op)
            {
                confirma = false;
                if (op == 0)
                {
                    confirma = true;
                }
            }

            @Override
            public String getTitulo()
            {
                return questionamento;
            }

            @Override
            public char getAtalhoSair()
            {
                return ' ';
            }

            @Override
            public String getDescrSair()
            {
                return "";
            }

            @Override
            public boolean isRepetir()
            {
                return false;
            }
        });
        m.gerar();
        
        return confirma;
    }

    
}
