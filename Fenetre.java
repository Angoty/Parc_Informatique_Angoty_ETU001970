package window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;

import plan.Display;
import client.Client;


public class Fenetre extends JFrame{
    public Fenetre(){
        this.setVisible(true);
        this.setTitle("Parc Informatique");
        this.setSize(800, 300);
		this.setLocationRelativeTo(null);

    }

    public Display addInfo(String[][] data){
        Display info=new Display(data);
        info.setBackground(Color.getHSBColor(1,1,200));
        return info;
    }
}