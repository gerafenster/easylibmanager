package br.univates.system32.menu1;

import br.univates.system32.Entrada;
import br.univates.system32.Entrada;

public class Menu
{
    private ConfigMenu config;

    public Menu(ConfigMenu config)
    {
        this.config = config;
    }
    
    public void gerar()
    {
        String m = "M E N U\n\n";
        
        if (!config.getTitulo().isEmpty())
        {
            m = config.getTitulo()+"\n\n";
        }

        for (int i = 0; i < config.getNumItens(); i++)
        {
            m += "["+config.getAtalho(i)+"] "+config.getDesc(i)+"\n";
        }
        
        if (config.isRepetir())
        {
            String sair = "[x] Sair";

            if (!config.getDescrSair().isEmpty())
            {
                sair = "["+config.getAtalhoSair()+"] "+config.getDescrSair();
            }

            m += sair;
        }
        char op = '?';
        
        while (op != config.getAtalhoSair())
        {
            op = Entrada.leiaChar(m);
            op = Character.toLowerCase(op);
            for (int i = 0; i < config.getNumItens(); i++)
            {
                if (op == Character.toLowerCase( config.getAtalho(i) ))
                {
                    config.executar(i);
                    break;
                }
            }
            if (!config.isRepetir())
            {
                op = config.getAtalhoSair();
            }
        }
    }
}
