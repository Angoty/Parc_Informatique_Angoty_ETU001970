package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import java.util.Vector;
import plan.Display;
import window.Fenetre;
import client.Client;
public class Ecouteur implements MouseListener{
    JTable table;
    int value;

    public JTable getTable(){
        return this.table;
    }
    public void setTable(JTable t){
        this.table=t;
    }
    public int getValue(){
        return this.value;
    }
    public void setValue(int v){
        this.value=v;
    }
    public Ecouteur(JTable t, int v){
        this.setTable(t);
        this.setValue(v);
    }

    public void mouseClicked(MouseEvent e){
        int i=this.getTable().getSelectedRow();
        try{
            try{
                if(value==0){ 
                    if(this.getTable().isRowSelected(i)==true){
                        System.out.println(i+" range Row selected");
                        this.getTable().remove(i);
                        System.out.println("Disconnect");
                        System.exit(1);
                    }else{
                        System.out.println("No row selected!");
                    }
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }catch(Exception io){
            System.out.println(io.getMessage());
        }
        
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}