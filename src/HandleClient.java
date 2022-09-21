import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HandleClient implements Runnable {
    // Global Variables
    Socket socket;
    LinkedList dictionary;

    // Var. Constructor
    HandleClient(Socket clientSocket, LinkedList dictionaryLinkedList) {
        this.socket = clientSocket;
        this.dictionary = dictionaryLinkedList;
    }

    @Override
    public void run() {
        // Set up scanners
        try {
            // Set up client scanners
            Scanner input = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (Exception e) {}

        // Process input
        Boolean inputValid = false;
        String inputValue = "";

        // Verifying input
        do {
            try {
                // Get input from client
                    // in / out !!!!!!!!!!!!!!!!!!!!!!!!!

                // Check input

            } catch () {}

        } while (inputValid);

        // Check dictionary for value
        DictionaryEntry entry = dictionary.getEntry(inputValue);
        if (entry != null) {
            // Definition found


        } else {
            // Definition not found


        }




    }
}
