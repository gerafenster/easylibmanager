/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.system32.splash;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *
 * @author mouri
 */
public class Splash
{
    private JWindow frame;
    private JProgressBar progressBar;
    private JLabel progressInfo;
    private int counter;
    private int delay;
    
    public Splash(String imagePath) 
    {
        SplashPanel splashPanel = new SplashPanel();
        splashPanel.setImagePath( imagePath );
        
        this.frame = new JWindow();
        this.frame.add( splashPanel );
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        
        this.progressBar = splashPanel.getProgressBar();
        this.progressInfo = splashPanel.getProgressInfo();
        this.counter = 0;
        this.delay = 1500;
    }

    public void setDelay(int delay) 
    {
        this.delay = delay;
    }
    
    public void showSplash()
    {
        frame.setVisible(true);
        try {
            sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dispose()
    {
        frame.dispose();
    }
    
    public void setSteps( int number )
    {
        progressBar.setMaximum( number );
    }

    public void next()
    {
        next( "Inicializando a aplicação..." );
    }
    
    public void next(String text)
    {
        counter ++;
        progressBar.setValue( counter );
        progressInfo.setText(" "+text);
        try {
            sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String[] args) {
        
        String[] vet = { "Testando conexão com o banco de dados...", "Criando schema do banco de dados...", "Carregando usuários..." };

        Splash s = new Splash("/br/univates/agenda/resources/images/foto.png");
        s.setSteps(3);
        s.showSplash();
        
        for (int i = 0; i < 3; i++) 
        {
            s.next( vet[i] );
        }
        s.dispose();
        
        System.exit(0);
    }
    
       
}
