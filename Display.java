package plan;

import information.Information;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;

import listener.Ecouteur;

public class Display extends JPanel{
    public Display(String[][] inf){

        String[] header={"Messages","User", "Name", "Version", "Architecture", "Max Memory", "Free Memory", "Using Memory"};

        JLabel label=new JLabel("Les informations des ordinateurs connectes");
        Font font=new Font("Century", 25, 25);
        JPanel a = new JPanel();
        JTable table=new JTable(inf, header);
        JScrollPane scroll=new JScrollPane(table);
        JPanel panel=new JPanel();
        JButton button=new JButton("deconnecter");
        button.addMouseListener(new Ecouteur(table,0));
    
        label.setFont(font);
        panel.setLayout(new GridLayout(2, 1, 1, 1));
		scroll.setPreferredSize(new Dimension(700, 100));        
        table.setBackground(Color.getHSBColor(45, 58, 245));

        a.add(label);
        a.add(button);
        panel.add(a);
        panel.add(scroll);
        this.add(panel);
    }
}