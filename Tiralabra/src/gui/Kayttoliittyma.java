
package gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author maef
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    /**
     *
     */
    public Kayttoliittyma() {
    }
    
    /**
     *
     */
    @Override
    public void run() {
        frame = new JFrame("Labyrintti");
        frame.setPreferredSize(new Dimension(600, 400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  
            luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
/**
 * Metodi luo tarvittavat komponentit ja lisää ne kehykseen.
 * @param container 
 */
    private void luoKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        JPanel kehys = new JPanel();
        kehys.setPreferredSize(new Dimension(600, 400));
        kehys.setBackground(Color.BLACK);
        container.add(kehys);
        
        JLabel kuva = new JLabel();
        kehys.add(kuva);
        
        JPanel napit = new JPanel();
        napit.setLayout(new BoxLayout(napit, BoxLayout.Y_AXIS));
        kehys.add(napit);
        
        JButton nappi = new JButton("Aloita suunnistus");
        napit.add(nappi);
        
        Kuuntelija kuuntelija = new Kuuntelija(nappi);
        
        nappi.addActionListener(kuuntelija);

    }
    
    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

}