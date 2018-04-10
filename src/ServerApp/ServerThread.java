package ServerApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ServerThread extends Thread {
    
    ServerForm serverForm;
    
    ObjectInputStream oin;
    ObjectOutputStream out;
    
    ServerSocket serverSocket;
    
    Socket socket;
    
    public ServerThread(ServerForm serverForm) {
        this.serverForm = serverForm;
        
        try {
            serverSocket = new ServerSocket(Settings.port);
            JOptionPane.showMessageDialog(this.serverForm, "Server Started");
            start();
            
         }
         catch(Exception e) {
             e.printStackTrace();
         }
        
        
    }
    
    public void sendMessage(String message) {
        try {
            out.writeObject(message.toString());
             
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void run () {
        
        while(true) {
        try {
            
         socket = serverSocket.accept();
         openReader();
        }
         catch(Exception e) {
            
            e.printStackTrace();
         }
        }
    }

    private void openReader() {
       try {
           oin = new ObjectInputStream(socket.getInputStream());
           out = new ObjectOutputStream(socket.getOutputStream());
           MsgRecThread nmt = new  MsgRecThread (serverForm , oin , out);
           
       }
       catch(Exception e) {
           e.printStackTrace();
       }
    }
    
    public class MsgRecThread   extends Thread{
        ServerForm serverForm;
         ObjectInputStream oin;
         ObjectOutputStream out;
        public MsgRecThread (ServerForm serverForm , ObjectInputStream oin , ObjectOutputStream out) {
            this.serverForm = serverForm;
            this.oin = oin;
            this.out = out;   
            start();
        }
       
        public void run () {
           while(true) {
            try {
               serverForm.recievedTextArea.append(oin.readObject().toString() + "\n"); 
            }
             catch(Exception e) {
                 e.printStackTrace();
             }
           }
        }
    }
    
}
