//Shakib Hossen Shanto
//CSE, Begum Rokeya University Rangpur

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException { 

    try (ServerSocket serverSocket = new ServerSocket(2222)) {

        //Connection and introducing first time

        System.out.println("Welcome to Server ChatSide");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected Successfully, Now Chat (Client writes first): ");

        //Declaring ObjectIOs
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());


        //As the client text first, server is always in receive and reply mode , continuous chatting

        while(true){

            //receiving texts sms from client

            Object sms = in.readObject();
            System.out.println("Client Says: "+ (String)sms);
                

            //sending sms to client 

            Scanner scnn = new Scanner(System.in);
            String sms1= scnn.nextLine();

            out.writeObject(sms1);
        }
    }
        
    }
}
