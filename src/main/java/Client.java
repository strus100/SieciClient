import java.io.*;
import java.net.*;

public class Client {
    public static void main(String argv[]) throws Exception {
         String sendto;
         String recvfrom;

        System.out.println("Czekam na rozpoczęcie gry..");
         //Tworzenie socketu
         Socket clientSocket = new Socket("localhost", 3333);


        //Komunikacja od servera
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //Komunikacja do servera
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //Wpisz z klawy testy...
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        recvfrom = inFromServer.readLine();
        System.out.println("FROM SERVER: " + recvfrom);

        System.out.println("Podaj login: ");
        sendto = inFromUser.readLine();
        outToServer.writeBytes("LOGIN " + sendto +'\n');

        recvfrom = inFromServer.readLine();
        System.out.println("FROM SERVER: " + recvfrom);

        for (int i = 0; i < 25 ; i++) {
            recvfrom = inFromServer.readLine();
            System.out.println("FROM SERVER: " + recvfrom);

        }

        while (true){


            recvfrom = inFromServer.readLine();
            System.out.println("FROM SERVER: " + recvfrom);

            System.out.println("Wpisz coś: ");
             sendto = inFromUser.readLine();
             outToServer.writeBytes(sendto + '\n');

             recvfrom = inFromServer.readLine();
             System.out.println("FROM SERVER: " + recvfrom);
         }
     }
}






