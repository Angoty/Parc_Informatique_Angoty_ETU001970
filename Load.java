package plan;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class Load extends JPanel{
    public Load(){
        JLabel label=new JLabel("En attente d'un client...");
        Font f = new Font("Century", 40, 40);
        label.setFont(f);
        this.add(label);
    }
}