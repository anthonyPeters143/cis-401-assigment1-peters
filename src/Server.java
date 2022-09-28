import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class: Server, Used to connect with sockets from multiple clients. Creates
 * dictionary database, then create client threads for connections.
 *
 * @author Anthony Peters
 */
public class Server {

    /**
     * Method: main, Used to drive server side of socket connection of server.
     * Will initialize dictionary database, then runs a loop creating HandleClient
     * thread connections to handle searches through data.
     *
     * @param args System input
     * @throws Exception Suppress exception from socket connection
     */
    public static void main(String[] args) throws IOException {
        // Initialize server data
        String fileName = "Dictionary.txt";
        LinkedList dictionaryLinkedList = initializeDictionary(fileName);

        // Create server object
        ServerSocket server = new ServerSocket(8000);

        // Run client threads loop
        while (true) {
            // Accept socket connection
            Socket socket = server.accept();

            // Run handler thread
            new HandleClient(socket, dictionaryLinkedList).run();
        }
    }

    /**
     * Method : initializeDictionary, Initializes dictionary data from given file input into
     * a linked list of DictionaryEntry objects to be used in the server's thread handlers.
     * Will pull data from file by scanning line by line, splitting by tab characters,
     * separating word and definition inputs, then entering values into new DictionaryEntry
     * objects.
     *
     * @param fileName String, file name for data
     * @return LinkedList, initialized linked list
     * @throws FileNotFoundException Exception, File name from pass String doesn't match any in file in package
     */
    public static LinkedList initializeDictionary(String fileName) throws FileNotFoundException {
        // Create file and LinkedList
        File dictionaryFile = new File("src/data/" + fileName);
        LinkedList dictionaryList = new LinkedList();

        // Create Scanner for data document
        Scanner fileScanner = new Scanner(dictionaryFile);

        // Input data from txt file to Linked list of dictionaryEntry objects
        while (fileScanner.hasNext()){
            // Input new line of test and split by tab chars
            String[] splitInput = fileScanner.nextLine().split("\t");

            // Add DictionaryEntry to LinkedList
            dictionaryList.addNode(new DictionaryEntry(splitInput[0], splitInput[1]));
        }

        return dictionaryList;
    }

}