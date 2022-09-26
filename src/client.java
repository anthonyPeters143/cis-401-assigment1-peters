import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception
    {
        // Initialize client data
        Scanner input = new Scanner(System.in);
        String response;

        // Set up socket connection
        // TODO WILL NEED TO CHANGE TO COMPUTER IP BEFORE TURNING IN
        Socket socket = new Socket("localhost",8000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Server prompts for input
        // TODO

    }


}
