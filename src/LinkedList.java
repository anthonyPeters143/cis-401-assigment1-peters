/**
 * Class: LinkedList, Used to store Node objects in a List, will keep track of head
 * and tail address as well as the size counter
 *
 * @author Anthony Peters
 */
public class LinkedList {
	int size;
	Node head = null;
	Node tail = null;

	/**
	 * Method: addNode, Adds new Node object to LinkedList object. Will add to end of
	 * existing List or will create new List with object.
	 *
	 * @param element DictionaryEntry, Element to be added to LinkedList
	 */
	public void addNode(DictionaryEntry element){
		// Create new Node object
		Node newNode = new Node(element);

		if (head == null) {
			// LinkedList is empty, create add new object to end and beginning of list
			head = tail = newNode;
		} else {
			// LinkedList has another object stored in it, add new object
			// to tail of last object
			tail.next = newNode;
		}

		// Move tail address to the new object
		tail = tail.next;

		// Increase size counter of LinkedList object
		size++;
	}

	/**
	 * Method: getEntry, Will search through LinkedList for passed String value.
	 * Will return DictionaryEntry object with word value matching passed String
	 * value or null.
	 *
	 * @param element String, Word value to search through LinkedList for
	 * @return DictionaryEntry, Found DictionaryEntry object
	 */
	public DictionaryEntry getEntry(String element) {
		int index = 0;
		Node temp = head;

		do {
			if (temp.element.word.equals(element)) {
				return temp.element;
			}
			else {
				temp = temp.next;
				index++;
			}
		} while (index < size);

		// Element not found
		return null;
	}

}
