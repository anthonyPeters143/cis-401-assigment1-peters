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

            // CODE BODY

        }


    }

    // Initializes data for dictionary
    public static LinkedList initializeDictionary(String fileName) throws FileNotFoundException {
        // Create file and LinkedList
        File dictionaryFile = new File("src/data/" + fileName);
        LinkedList dictionaryList = new LinkedList();

        // Create Scanner for data document
        Scanner fileScanner = new Scanner(dictionaryFile);

        // Input data from txt file to Linked list of dictionaryEntry objects
        while (fileScanner.hasNext()){
            String fileLine = fileScanner.nextLine();

            // Replace whitespace char with "," then split input by ","
            String[] splitInput = fileLine.replaceAll("//s",",").split(",");

            // Get word input and definition from input
            String wordInput = splitInput[0];

            // Index though rest of input array for definition input
            int splitIndex = 1;
            String definitionInput = "";
            while (splitInput.length >= splitIndex) {
                definitionInput = definitionInput.concat(" " + splitInput[splitIndex]);
                splitIndex++;
            }

            // Add DictionaryEntry to LinkedList
            dictionaryList.addLast(new DictionaryEntry(wordInput, definitionInput));
        }

    }

}