/**
 * Class: Node, Used as object storage in LinkedList. Will store
 * DictionaryEntry and Address for next Node in LinkedList.
 *
 * @author Anthony Peters
 */
public class Node {
	
	DictionaryEntry element;
	Node next;

	/**
	 * Constructor
	 *
	 * @param inputElement DictionaryEntry, DictionaryEntry object to be stored
	 */
	public Node(DictionaryEntry inputElement){
		this.element = inputElement;
	}

}