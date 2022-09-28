import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Class: HandleClient, Handler for client threads creating by the Server class.
 *
 * @author Anthony Peters
 */
public class HandleClient implements Runnable {
    // Global Variables
    Socket socket;
    LinkedList dictionary;

    /**
     * Constructor
     *
     * @param clientSocket Socket, Client connection from server class
     * @param dictionaryLinkedList LinkedList, Dictionary database to search though
     */
    HandleClient(Socket clientSocket, LinkedList dictionaryLinkedList) {
        socket = clientSocket;
        dictionary = dictionaryLinkedList;
    }

    /**
     * Method: run, Sets up connection between server and client sockets for in and out streams.
     * Will receive and verify input from client of a word, the server will validate input doesn't
     * contain any digit characters, then search the passed dictionary LinkedList for the input,
     * will output response to client. Client response: found = definition, not-found = not found message
     */
    @Override
    public void run() {
        // Set up scanners
        try {
            // Set up client scanners
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Process input
            boolean inputValid = false;
            String inputValue = "";

            // Receiving/Verifying input
            do {
                try {
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
                out.println(entry.getDefinition());

            } else {
                // Definition not found, output name w/ error message
                out.println(inputValue + " not found in the dictionary");

            }

        } catch (Exception e) {}


    }
}
