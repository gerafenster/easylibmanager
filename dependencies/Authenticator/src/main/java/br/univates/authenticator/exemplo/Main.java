/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.authenticator.exemplo;

import br.univates.authenticator.Authenticator;
import br.univates.authenticator.GenericUser;
import java.util.ArrayList;

/**
 *
 * @author mouri
 */
public class Main
{
    public static void main(String[] args)
    {
        
        GenericUser u1 = new GenericUser() {
            @Override
            public String getLogin()
            {
                return "u1";
            }

            @Override
            public String getPassword()
            {
                return "u1".hashCode()+"";
            }
        };
        
        GenericUser u2 = new GenericUser() {
            @Override
            public String getLogin()
            {
                return "u2";
            }

            @Override
            public String getPassword()
            {
                return "u2".hashCode()+"";
            }
        };
        
        ArrayList<GenericUser> users = new ArrayList();
        users.add(u1);
        users.add(u2);
        
        Authenticator auth = new Authenticator(users);
        
        //LoginDialog dl = new LoginDialog(null,auth);
        //dl.setVisible(true);
        
        auth.runAuthentication();

        if (auth.getLoggedUser() == null)
        {
            System.out.println("não logado");
            System.exit(0);
        }
        else
        {
            System.out.println("abrir a tela do sistema");
        }
        
    }
}
