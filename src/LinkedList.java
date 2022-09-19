public class LinkedList{
	int size;
	Node head = null;
	Node tail = null;
	
	public void addFirst(DictionaryEntry element){
		Node newNode = new Node(element);
		
		newNode.next = head;
		head = newNode;
		size++;
		
		if(tail == null)
			tail = head;
	}
	
	
	public void addLast(DictionaryEntry element){
		Node newNode = new Node(element);
		if(head == null){ // empty linked list
			head = tail = newNode;
		}
		
	   tail.next = newNode;
	   tail = tail.next;
	   size++;
	}
	
	public void deleteFirst(){
		if(head == null){
			System.out.println("Empty list. Cannot delete");
		}
		
		if(head == tail)
			head = tail = null;
		
		head = head.next;
		size--;
	}
	
	public void deleteLast(){
		if(tail == null){
			System.out.println("Empty list. Cannot delete");
		}
		Node temp = head;
		
		while(temp.next!=tail)
			temp = temp.next;
		
		tail = temp;
		temp.next = null;
		size--;
		}
	
	
	public void add(DictionaryEntry element, int index){
		if(index < 0 || index > size) 
			System.out.println("Invalid index");
		else if(index == 0) addFirst(element);
		else if(index == size) addLast(element);
		else {
		Node newNode = new Node(element);
		Node temp = head;
		}
	}
	
	public void delete( int index) {
		
		if(index>=size) System.out.println("Invalid index");
		else if(index == 0) deleteFirst();
		else if(index == size-1)  deleteLast();
		else 
		{
			Node temp = head;
			for(int i=0; i<index-1; i++){
				temp = temp.next;
			}
			
			Node current = temp.next;
			temp.next = current.next;
			
			size--;
		}
	}
		
	
	public void displayList(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.element);
			temp = temp.next;
		}
	}
}
