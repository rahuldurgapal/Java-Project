import java.net.*;
import java.io.*;
public class Server{

     ServerSocket server;
     Socket socket;

     BufferedReader br;
     PrintWriter out;
    //constructor
    public Server(){
        try{
        server = new ServerSocket(7777); //pass the random port number for contacting to client
        System.out.println("Server is ready to accept connection");
        System.out.println("Waiting...");
        
        socket=server.accept();

        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        startReading();
        startWriting();


        }catch(Exception e){
            System.out.println("Exception "+e.getMessage());
        }
    }

    public void startReading(){
         

         //thread-read karke deta rahega

         Runnable r1 = ()->{
         try{
           while(true){
           
            String msg  = br.readLine();
            if(msg.equals("exit")){
                System.out.println("Client Terminated the chat...");
                socket.close();
                break;
            }
            System.out.println("Client: "+msg);
           
           }
         }catch(Exception e){
            System.out.println("Connection is closed..");
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
        System.out.println("This is server...going to start server"); 
        new Server();
    }
}