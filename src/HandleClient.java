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
        String inputValue;

        do {
            try {
                // Get input from client

                // Check input

            } catch () {}

        } while (inputValid);

        // Check dictionary for value
        for (int index = 0; index < dictionary.size; index++){

            // TODO NEED TO FIGURE OUT WHAT TO DO WITH LINKED LIST, TEACHER'S GIVEN CODE DOESN'T ALLOW FOR NEXT


        }

    }
}
