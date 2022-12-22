package server;

import java.net.Socket;
import java.net.ServerSocket;

import java.io.DataInputStream;
import java.io.BufferedInputStream;

import java.util.Vector;

import window.Fenetre;
import plan.Load;
public class Server{

    int port;
    Socket socket=null;
    ServerSocket serversocket=null;
    DataInputStream input=null;

    public int getPort(){
        return this.port;
    }
    public Socket getSocket(){
        return this.socket;
    }
    public ServerSocket getServerSocket(){
        return this.serversocket;
    }
    public DataInputStream getInput(){
        return this.input;
    }

    public void setPort(int port){
        this.port=port;
    }
    public void setSocket(Socket socket){
        this.socket=socket;
    }
    public void setServerSocket(ServerSocket serversocket){
        this.serversocket=serversocket;
    }
    public void setInput(DataInputStream input){
        this.input=input;
    }
    
    public Server(int port) throws Exception{
        this.setPort(port);
        this.setServerSocket(new ServerSocket(port));
    }

    public void open() throws Exception{
        this.setSocket(this.getServerSocket().accept());
        this.setInput(new DataInputStream(new BufferedInputStream(this.getSocket().getInputStream())));
    }

    public void close() throws Exception{
        this.getSocket().close();
        this.getInput().close();
    }

    public String readMessage() throws Exception{
        String message=this.getInput().readUTF();
        return message;
    }

    public String[][] donnees(Vector<String>data){
        String[] info=data.get(0).split(";");
        String[][] donnees=new String[data.size()][info.length];
        for(int i=0; i<data.size(); i++){
            info=data.get(i).split(";");
            donnees[i]=info;
        }
        return donnees;
    }

    public boolean vectorString(Vector<String> liste, String mess){
        String[] message=mess.split(";");
        for(int i=0;i<liste.size();i++){
            String[] info=liste.get(i).split(";");
            if(info[0].equals(message[0])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        try{
            Server s=new Server(51);
            Vector<String> information=new Vector<String>();
            Fenetre window=new Fenetre();
            window.setContentPane(new Load());
            try{
                System.out.println("En attente du client");
                while(1!=0){
                    s.open();
                    String read=s.readMessage();
                    
                    if(!s.vectorString(information, read)) 
                    information.add(read);

                    System.out.println(read);
                    window.setContentPane(window.addInfo(s.donnees(information)));
                    s.close();
                    Thread.sleep(100);
                    System.out.println();   
                    
                }
            }catch(Exception e){System.out.println(e.getMessage());}
        }catch(Exception io){System.out.println(io.getMessage());}
    }
    
}