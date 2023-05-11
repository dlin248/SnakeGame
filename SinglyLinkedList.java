import java.util.NoSuchElementException;

/**
 * get is little sketchy
 * clear as well
 *	SinglyLinkedList - (description)
 *	All the methods to make a singlylinkedlist function to an extent
 *	@author	Darren Lin
 *	@since	4 - 25 - 2023
 */
public class SinglyLinkedList<E extends Comparable<E>>
{
	/* Fields */
	private ListNode<E> head, tail;		// head and tail pointers to list
	
	/* No-args Constructors */
	public SinglyLinkedList() 
	{
		head = new ListNode<E>(null,null);
		tail = new ListNode<E>(null,null);
	}
	
	/** Copy constructor */
	public SinglyLinkedList(SinglyLinkedList<E> oldList) {}
	
	/**	Clears the list of elements */
	public void clear() 
	{
		head = new ListNode<E>(null,null);
		tail = new ListNode<E>(null,null);
	}
	
	/**	Add the object to the end of the list
	 *	@param obj		the object to add
	 *	@return			true if successful; false otherwise
	 */
	public boolean add(E obj) 
	{
		if(head != null && head.getValue()!= null)
		{
			tail.setNext(new ListNode<E>(obj,null));
			tail = tail.getNext();
		}
		else
		{
			tail = new ListNode<E>(obj,null);
			head = tail;
		}
		return true;
	}
	
	/**	Add the object at the specified index
	 *	@param index		the index to add the object
	 *	@param obj			the object to add
	 *	@return				true if successful; false otherwise
	 *	@throws NoSuchElementException if index does not exist
	 */
	public boolean add(int index, E obj) {
		return false;
	}
	
	/**	@return the number of elements in this list */
	public int size() {
		ListNode<E> node = head;
		int counter = 0;
		if(node.getNext() != null)
			counter++;
		while(node.getNext() != null)
		{
			node = node.getNext();
			counter++;
		}
		return counter;
	}
	
	/**	Return the ListNode at the specified index
	 *	@param index		the index of the ListNode
	 *	@return				the ListNode at the specified index
	 *	@throws NoSuchElementException if index does not exist
	 */
	public ListNode<E> get(int index) 
	{
		ListNode<E> node = head;
		for(int i = 0; i < index; i++)
		{
			if(node == null)
			{
				System.out.println("ERROR: no index = " + index);
				break;
			}
			try
			{
				node = node.getNext();
			}
			catch(NoSuchElementException PeterJayChen)
			{
				System.out.println("ERROR: no index = " + index);
				break;
			}
		}
		return node;
	}
	
	/**	Replace the object at the specified index
	 *	@param index		the index of the object
	 *	@param obj			the object that will replace the original
	 *	@return				the object that was replaced
	 *	@throws NoSuchElementException if index does not exist
	 */
	public E set(int index, E obj) {
		ListNode<E> node = head;
		for(int i = 0; i < index; i++)
		{
			if(node == null)
			{
				System.out.println("ERROR: no index = " + index);
				return null;
			}
			try
			{
				node = node.getNext();				
			}
			catch(NoSuchElementException PeterJayChen)
			{
				System.out.println("ERROR: no index = " + index);
				break;
			}
		}
		ListNode<E> old = node;
		node.setValue(obj);
		return old.getValue();
	}
	
	/**	Remove the element at the specified index
	 *	@param index		the index of the element
	 *	@return				the object in the element that was removed
	 *	@throws NoSuchElementException if index does not exist
	 */
	public E remove(int index) {
		ListNode<E> node = head;
		ListNode<E> temp = head;
		if(index < 0 || index >= size())
			throw new NoSuchElementException();
		if(index == 0)
		{
			head = head.getNext();
			return node.getValue();
		}
		for(int i = 0; i < index-1; i++)
			node = node.getNext();
		temp = node.getNext();
		node = node.getNext().getNext();
		return temp.getValue();
	}
	
	/**	@return	true if list is empty; false otherwise */
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	
	/**	Tests whether the list contains the given object
	 *	@param object		the object to test
	 *	@return				true if the object is in the list; false otherwise
	 */
	public boolean contains(E object) {
		ListNode<E> node = head;
		while(node.getNext() != null)
		{
			if(node.getValue().compareTo(object) == 0)
				return true;
			node = node.getNext();
		}
		return false;
	}
	
	/**	Return the first index matching the element
	 *	@param element		the element to match
	 *	@return				if found, the index of the element; otherwise returns -1
	 */
	public int indexOf(E element) {
		int counter = 0;
		ListNode<E> node = head;
		while(node.getNext() != null)
		{
			if(node.getValue().compareTo(element) == 0)
				return counter;
			counter++;
			node = node.getNext();
		}
		return -1;
	}
	
	/**	Prints the list of elements */
	public void printList()
	{
		ListNode<E> ptr = head;
		while (ptr != null)
		{
			System.out.print(ptr.getValue() + "; ");
			ptr = ptr.getNext();
		}
	}
	

}
