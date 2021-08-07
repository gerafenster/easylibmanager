package br.univates.system32.tools;

import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @author Mouriac
 */
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

/**
 * Um conjunto de ferramentas para trabalhar com aplicacoes GUI
 * @author Mouriac
 */
public class UI {
    
    final public static int WINDOWS = 0;
    final public static int WINDOWS_CLASSIC = 1;
    final public static int MOTIF = 2;
    final public static int METAL = 3;
    final public static int NIMBUS = 4;
    
    private static UI instancia = new UI();
    
    /** Creates a new instance of UI */
    private UI() 
    {
    }
    
    /**
     * Retorna uma instância da classe SwingTools
     * @return uma instância de SwingTools
     */
    public static UI getInstance() {
        return (instancia);
    }
    
    /**
     * Seleciona o padrão de visualização da interface GUI
     * @param tipo um inteiro WINDOWS, WINDOWS_CLASSIC, MOTIF ou METAL
     */
    public void selectInterface( int tipo ) {
        String[] newLookAndFeel = { "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
        "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel",
        "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
        "javax.swing.plaf.metal.MetalLookAndFeel",
        "javax.swing.plaf.nimbus.NimbusLookAndFeel" };
        
        tipo = tipo < 0 || tipo > 4 ? 4 : tipo;
        
        try {
            UIManager.setLookAndFeel( newLookAndFeel[ tipo ] );
        } catch (Exception e) { }
    }
    
    /**
     * Retorna um vetor com a resolução do vídeo
     * @return um vetor com largura e altura do vídeo em número de pixels
     */
    public int[] getVideoResolution() {
        Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();
        int[] retorno = { resolucao.width, resolucao.height };
        return (retorno);
    }
    
}
