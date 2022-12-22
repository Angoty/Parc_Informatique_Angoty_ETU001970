package client;

import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.util.Scanner;

import information.Information;
import window.Fenetre;

public class Client extends Thread{

    Socket socket=null;
    DataOutputStream output=null;

    public Socket getSocket(){
        return this.socket;
    }
    public DataOutputStream getOutput(){
        return this.output;
    }
    public void setSocket(Socket socket){
        this.socket=socket;
    }
    public void setOutput(DataOutputStream output){
        this.output=output;
    }

    public Client(){}

    public void connect(String adresse, int port) throws Exception{
        this.setSocket(new Socket(adresse, port));
        this.setOutput(new DataOutputStream(this.getSocket().getOutputStream()));
    }
    public void disconnect()throws Exception{
        this.getSocket().close();
        this.getOutput().close();
    }

    public void writeMessage(String message)throws Exception{
        this.getOutput().writeUTF(message);
    }

    public void run(){
        try{
            Client c=new Client();
            try{
                Scanner scanf=new Scanner(System.in);
                String message=scanf.nextLine();
                Information info=new Information();
                String method=info.getAllInformations();
                while(message.equals("exit")==false){
                    c.connect("localhost", 51);
                    c.writeMessage(message+";"+method);
                    c.disconnect();
                    Thread.sleep(2000000);
                }
            }catch(Exception e){e.printStackTrace();}
        }catch(Exception io){System.out.println(io.getMessage());}
    }

    public static void main(String[] args){
        try{
            System.out.print("Envoi du message: ");
            Client c=new Client();
            c.start();
        }catch(Exception e){System.out.println(e.getMessage());}
    }
}   