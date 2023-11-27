import java.net.*;
import java.io.*;
public class Client{

    Socket socket;

    BufferedReader br;
    PrintWriter out;

    public Client(){
       
       try{
         
       System.out.println("Sending request to server");  
       socket= new Socket("127.0.0.1",7777);
       System.out.println("Connection Done");

        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        startReading();
        startWriting();


       }catch(Exception e){
        System.out.println("Exeption "+e.getMessage());
       }
    }
   
   public void startReading(){
         

         //thread-read karke deta rahega

         Runnable r1 = ()->{
         try{
           while(true){
           
            String msg  = br.readLine();
            if(msg.equals("exit")){
                System.out.println("Server Terminated the chat...");
                socket.close();
                break;
            }
            System.out.println("Server: "+msg);
           }
           }catch(Exception ex){
            System.out.println("Connection is closed..");;
           }
           
         };

         new Thread(r1).start();
    }

    public void startWriting(){
         
         //wo data ko user se lega and then usko send karega clinet tak

         Runnable r2 = ()->{
           System.out.println("Writer Started..");
           try{
            while(!socket.isClosed()){

              
                 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                 
                 String content = br1.readLine();


                 out.println(content);
                 out.flush();
                if(content.equals("exit")){
                    socket.close();
                    break;
                 }
                
            }

            
         }catch(Exception e){
            System.out.println("Connection is closed..");
         }
         };
         new Thread(r2).start();
    }


    public static void main(String [] args){
        System.out.println("This is client...");
        new Client();
    }
}