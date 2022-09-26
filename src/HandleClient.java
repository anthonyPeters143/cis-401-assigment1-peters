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

            // Process input
            boolean inputValid = false;
            String inputValue = "";

            // Receiving/Verifying input
            do {
                try {
                    // Output prompt
                    out.println("Enter a word");

                    // Get input from client, trim for whitespaces
                    inputValue = in.readLine().trim();

                    // Check input to be not numbers
                    if (inputValue.matches("/D")) {
                        // Input valid
                        inputValid = true;
                    }

                } catch (Exception e) {}

            } while (inputValid);

            // Check dictionary for value
            DictionaryEntry entry = dictionary.getEntry(inputValue);
            if (entry != null) {
                // Definition found, output definition
                out.println(entry);

            } else {
                // Definition not found, output name w/ error message
                out.println(inputValue + " not found in the dictionary");

            }

        } catch (Exception e) {}






    }
}
