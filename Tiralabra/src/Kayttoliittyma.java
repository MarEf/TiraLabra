


import java.awt.*;
import javax.swing.*;
import rakenteet.Jarjestysjono;

/**
 *
 * @author maef
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Labyrintti laby = new Labyrintti("laby20x20");

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
        frame.setPreferredSize(new Dimension(700, 350));
        
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
        Image sokkelo = laby.haeLaby();
        
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        
        JPanel kehys = new JPanel();
        kehys.setPreferredSize(new Dimension(700, 350));
        kehys.setBackground(Color.LIGHT_GRAY);
        container.add(kehys);
        
        JPanel labyt = new JPanel();
        labyt.setLayout(new BoxLayout(labyt, BoxLayout.Y_AXIS));
        labyt.setBackground(Color.LIGHT_GRAY);
        
        JButton valitse = new JButton("Vaihda labyrintti");
        
        JTextField labyrintti = new JTextField();
        labyt.add(labyrintti);
        
        JLabel laby1 = new JLabel("laby20x20");
        JLabel laby2 = new JLabel("laby2");
        JLabel laby3 = new JLabel("laby3");
        JLabel laby4 = new JLabel("labyEiSeinia");
        JLabel laby5 = new JLabel("labyMetsa");
        
        labyt.add(laby1);
        labyt.add(laby2);
        labyt.add(laby3);
        labyt.add(laby4);
        labyt.add(laby5);
        labyt.add(labyrintti);
        labyt.add(valitse);
        kehys.add(labyt);
        
        JLabel kuva = new JLabel();
        kuva.setIcon(new ImageIcon(sokkelo.getScaledInstance(300, 300, 0)));
        kehys.add(kuva);
        
        JPanel napit = new JPanel();
        napit.setLayout(new BoxLayout(napit, BoxLayout.Y_AXIS));
        kehys.add(napit);
        
        JButton nappi = new JButton("Aloita suunnistus");
        napit.add(nappi);
        
        Kuuntelija kuuntelija = new Kuuntelija(nappi, kuva, laby);
        
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
