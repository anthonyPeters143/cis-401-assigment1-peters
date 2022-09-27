import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class: Client, Used to connect with socket from IP:______. Sends a word input
 * then receives a response definition from Server.
 *
 * @author Anthony Peters
 */
public class Client {

    /**
     * Method: main, Used to drive client side of socket connection to IP:_____ server.
     * Will prompt and send word input to server, then receive and output response.
     *
     * @param args System input
     * @throws Exception Suppress exception from socket connection
     */
    public static void main(String[] args) throws Exception
    {
        // Initialize client data
        Scanner input = new Scanner(System.in);
        String responseInput, responseOutput;

        // Set up socket connection
        // TODO WILL NEED TO CHANGE TO COMPUTER IP BEFORE TURNING IN
        Socket socket = new Socket("localhost",8000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Prompts and store input
        System.out.println("Enter a word:");
        responseInput = input.next();

        // Send input to server
        out.println(responseInput);

        // Get output from server
        responseOutput = in.readLine();

        // Output string to user
        System.out.println(responseOutput);
    }


}
