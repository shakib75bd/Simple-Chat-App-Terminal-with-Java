//Shakib Hossen Shanto
//CSE, Begum Rokeya University Rangpur

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {

        //Connection and introducing first time

        System.out.println("Welcome to Client ChatSide");
        Socket socket = new Socket("127.0.0.1",2222); //For connection, ip address of server Device here. For localhost no change is needed
        System.out.println("ServerSide connected successfully, Now Chat: ");


        //Declaring ObjectIOs
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            

        //sending sms to server for the first time
        Scanner scn = new Scanner(System.in);
        String sms = scn.nextLine();
        out.writeObject(sms);

        //Continuos Chatting now

        while(true){
            try {
                //receiving text

                Object getSms = in.readObject();
                System.out.println("Server Says: " + (String)getSms);

                //replying text

                String sms2 = scn.nextLine();
                out.writeObject(sms2);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
