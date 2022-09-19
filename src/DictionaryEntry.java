import java.util.Objects;

public class DictionaryEntry {
    String word, definition;

    DictionaryEntry(String wordInput, String definitionInput) {
        word = wordInput;
        definition = definitionInput;
    }

    // Check input against entry's word value and returns boolean value
    boolean checkWord(String wordInput) {
        return Objects.equals(word, wordInput);
    }

    String getDefinition() {
        return definition;
    }

    String getWord() {
        return word;
    }
}
