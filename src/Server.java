import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // Initialize server data
        String fileName = "Dictionary.txt";
        LinkedList dictionaryLinkedList = initializeDictionary(fileName);

        // Create server object
        ServerSocket server = new ServerSocket(8000);

        // Run server object loop
        while (true) {
            Socket socket = server.accept();

            // Run handler thread
            new HandleClient(socket,dictionaryLinkedList);


        }
    }

    // Initializes data from file input, will place data into returned linked list
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
            dictionaryList.addLast(new DictionaryEntry(splitInput[0], splitInput[1]));
        }

        return dictionaryList;
    }

}