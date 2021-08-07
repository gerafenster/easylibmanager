/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.authenticator;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author mouri
 */
public class Authenticator
{
    private ArrayList<? extends GenericUser> validUsers;
    private GenericUser loggedUser;

    public Authenticator(ArrayList<? extends GenericUser> validUsers)
    {
        this.validUsers = validUsers;
        this.loggedUser = null;
    }
    
    public void runAuthentication()
    {
        runAuthentication( null );
    }
    
    public void runAuthentication( java.awt.Frame parent )
    {
        LoginDialog l = new LoginDialog(parent,this);
        l.setVisible(true);
    }

    public GenericUser getLoggedUser()
    {
        return loggedUser;
    }

    public void setLoggedUser(GenericUser loggedUser)
    {
        this.loggedUser = loggedUser;
    }
    
    public void validate( String login, String pw ) throws UserNotFoundException, PasswordException
    {
        boolean ok = false;
        GenericUser loggedUser = null;
        for (GenericUser user: validUsers)
        {
            if (user.getLogin().equals(login) )
            {
                loggedUser = user;
                ok = true;
            }
        }
        if (ok)
        {           
            if (loggedUser.getPassword().equals( pw.hashCode()+"" ))
            {
                this.loggedUser = loggedUser;
            }
            else
            {
                this.loggedUser = null;
                throw new PasswordException();
            }
        }
        else
        {
            throw new UserNotFoundException();
        }
    }
}
