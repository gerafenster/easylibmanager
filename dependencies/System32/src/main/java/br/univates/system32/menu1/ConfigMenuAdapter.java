package br.univates.system32.menu1;

import br.univates.system32.menu1.ConfigMenu;

public class ConfigMenuAdapter implements ConfigMenu
{

    @Override
    public int getNumItens()
    {
        return 1;
    }

    @Override
    public char getAtalho(int i)
    {
        String x = (i+1)+"";
        return x.charAt(0);
    }

    @Override
    public String getDesc(int i)
    {
        return "Descrição da opção";
    }

    @Override
    public void executar(int op)
    {
        
    }

    @Override
    public String getTitulo()
    {
        return "M E N U    D O    S I S T E M A";
    }

    @Override
    public char getAtalhoSair()
    {
        return 'x';
    }

    @Override
    public String getDescrSair()
    {
        return "Sair do Sistema";
    }

    @Override
    public boolean isRepetir()
    {
        return true;
    }
    
}
