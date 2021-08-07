package br.univates.system32.menu2;

import br.univates.system32.Entrada;
import java.util.ArrayList;

public class Menu
{
    private ArrayList<ItemMenu> itens;
    private String titulo;
    private boolean repetir;
    private char atalhoSair;
    private String descrSair;
    
    public Menu()
    {
        itens = new ArrayList();
        titulo = "M E N U";
        repetir = true;
        atalhoSair = 'x';
        descrSair = "Sair";
    }
    
    public void addItem( ItemMenu item )
    {
        this.itens.add(item);
    }
    
    public void gerar()
    {
        String m = "M E N U\n\n";
        
        if (!titulo.isEmpty())
        {
            m = titulo+"\n\n";
        }

        for (ItemMenu itemMenu: itens)
        {
            m += "["+itemMenu.getAtalho()+"] "+itemMenu.getDescr()+"\n";
        }
        
        
        if (this.repetir)
        {
            String sair = "[x] Sair";

            if (!descrSair.isEmpty())
            {
                sair = "["+atalhoSair+"] "+descrSair;
            }

            m += sair;
        }
        char op = '?';
        
        while (op != atalhoSair)
        {
            op = Entrada.leiaChar(m);
            op = Character.toLowerCase(op);
            for (int i = 0; i < itens.size(); i++)
            {
                if (op == Character.toLowerCase( itens.get(i).getAtalho() ))
                {
                    itens.get(i).executar();
                    break;
                }
            }
            if (!repetir)
            {
                op = atalhoSair;
            }
        }
    }
}
