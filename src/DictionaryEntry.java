/**
 * Class: Node, Used as object storage in LinkedList. Will store
 * DictionaryEntry and Address for next Node in LinkedList.
 *
 * @author Anthony Peters
 */
public class DictionaryEntry {
    String word, definition;

    /**
     * Constructor
     *
     * @param wordInput String, Word input to be stored
     * @param definitionInput String, Definition to be stored
     */
    DictionaryEntry(String wordInput, String definitionInput) {
        word = wordInput;
        definition = definitionInput;
    }

    /**
     * Method: getDefinition, Returns definition of DictionaryEntry object.
     *
     * @return String, Definition value stored in object
     */
    String getDefinition() {
        return definition;
    }

    /**
     * Method: getWord, Returns word of DictionaryEntry object.
     *
     * @return String, Word value stored in object
     */
    String getWord() {
        return word;
    }
}
