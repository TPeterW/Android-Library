package com.peter.adts.DoublyLinkedList;

public class DoublyLinkedList {
	private DLLNode head, tail;
	private int size;
	
	public int getHead() { return head.getValue(); }
	
	public int getTail() { return tail.getValue(); }
	
	public int size() { return size; }
	
	/***
	 * Constructor
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/***
	 * print from head to tail
	 */
	public void printAll() {
		if (size == 0)
			return;
		
		DLLNode current = head;
		while (!current.isTail()) {
			System.out.print(current.getValue() + " ");
			current = current.getNext();
		}
		
		System.out.println(current.getValue());
	}
	
	/***
	 * print from tail to head
	 */
	public void printAllReversed() {
		DLLNode current = tail;
		while (!current.isHead()) {
			System.out.print(current.getValue() + " ");
			current = current.getPrevious();
		}
		
		System.out.println(current.getValue());
	}
	
	/***
	 * add value to the end of the DLL
	 * @param value
	 * @return
	 */
	public DoublyLinkedList add(int value) {
		if (tail == null) {		// list is empty
			head = new DLLNode(value, null, null);
			tail = head;
			size = 1;
			return this;
		}
		
		tail.setNext(new DLLNode(value, tail, null));
		tail = tail.getNext();
		size++;
		
		return this;
	}
	
	/***
	 * insert at index
	 * if positive, insert before the index
	 * if negative, insert after the negative index
	 * @param value
	 * @param index
	 * @return
	 */
	public DoublyLinkedList insertAt(int value, int index) {
		int i;
		DLLNode current;
		if (index < 0) {
			if (Math.abs(index) > size)
				return null;
			current = tail;
			for (i = size - 1; i > size + index; i--)
				current = current.getPrevious();
		} else {
			if (index >= size)
				return null;
			current = head;
			for (i = 0; i < index; i++)
				current = current.getNext();
		}
		
		if (current.isHead()) {
			head.setPrevious(new DLLNode(value, null, head));
			head = head.getPrevious();
		} else if (current.isTail() && index < 0) {
			tail.setNext(new DLLNode(value, tail, null));
			tail = tail.getNext();
		} else {			// neither head nor tail
			DLLNode newNode = new DLLNode(value, current.getPrevious(), current);
			if (!current.isHead())
				current.getPrevious().setNext(newNode);
			if (!current.isTail())
				current.getNext().setPrevious(newNode);
		}
		
		size++;
		
		return this;
	}
	
	/***
	 * insert a value at the start of list
	 * @param value
	 * @return
	 */
	public DoublyLinkedList insertAtStart(int value) {
		head.setPrevious(new DLLNode(value, null, head));
		head = head.getPrevious();
		
		return this;
	}
	
	/***
	 * insert a value at the end of list
	 * @param value
	 * @return
	 */
	public DoublyLinkedList insertAtEnd(int value) {
		tail.setNext(new DLLNode(value, tail, null));
		tail = tail.getNext();
		
		return this;
	}
	
	/***
	 * remove the first node with value
	 * returns true if successful, false otherwise
	 * @return
	 */
	public boolean remove(int value) {
		if (size == 0)
			return false;
		
		int index = indexOf(value);
		System.out.println("Index is: " + index);
		
		DLLNode current = head;
		
		int i;
		for (i = 0; i < index; i++) {
			current = current.getNext();
		}
		removeNode(current);
		
		return true;
	}
	
	/***
	 * remove the first node
	 * returns true if successful, false otherwise
	 * @return
	 */
	public boolean removeFromStart() {
		if (size == 0)
			return false;
		if (size == 1) {
			size = 0;
			head = null;
			tail = null;
			return true;
		}
		
		head = head.getNext();
		head.setPrevious(null);
		size--;
		
		return true;
	}
	
	/***
	 * remove the last node
	 * returns true if successful, false otherwise
	 * @return
	 */
	public boolean removeFromEnd() {
		if (size == 0)
			return false;
		if (size == 1) {
			size = 0;
			head = null;
			tail = null;
			return true;
		}
		
		tail = tail.getPrevious();
		tail.setNext(null);
		size--;
		
		return true;
	}
	
	/***
	 * remove the node at index
	 * positive means starting from beginning, negative means starting from end
	 * returns true if successful, false if out of boundary
	 * @param index
	 * @return
	 */
	public boolean removeAtIndex(int index) {
		DLLNode current;
		
		int i;
		if (index < 0) {		// start from end
			if (Math.abs(index) > size)						// out of bound
				return false;
			
			current = tail;
			for (i = -1; i > index; i--)
				current = current.getPrevious();
		} else {				// start from beginning
			if (index >= size)								// out of bound
				return false;
			
			current = head;
			for (i = 0; i < index; i++)
				current = current.getNext();
		}
		removeNode(current);
		
		return true;
	}
	
	/***
	 * internal method to delete a specific node
	 * @param nodeToDelete
	 */
	private void removeNode(DLLNode nodeToDelete) {
		if (nodeToDelete.isHead()) {
			if (nodeToDelete.isTail())		// just one nodes
				removeFromEnd();
			else
				removeFromStart();
		} else if (nodeToDelete.isTail())
			removeFromEnd();
		else {
			nodeToDelete.getPrevious().setNext(nodeToDelete.getNext());
			nodeToDelete.getNext().setPrevious(nodeToDelete.getPrevious());
			size--;
		}
	}
	
	/***
	 * return the value at index
	 * if out of boundary, return the value at boundary
	 * @param index
	 * @return
	 */
	public int get(int index) {
		int i;
		DLLNode current;
		if (index < 0) {		// start from tail
			if (Math.abs(index) > size)
				index = Math.negateExact(size);
			current = tail;
			for (i = size - 1; i > size + index; i--)
				current = current.getPrevious();
		} else {				// start from head
			if (index >= size)
				index = size - 1;
			current = head;
			for (i = 0; i < index; i++)
				current = current.getNext();	
		}
		
		return current.getValue();
	}
	
	/***
	 * find the first appearance of value
	 * @param value
	 * @return
	 */
	public int indexOf(int value) {
		DLLNode current = head;
		int index = 0;
		
		while (current.getValue() != value) {
			current = current.getNext();
			index++;
		}
		
		return index;
	}
	
	/***
	 * get truncated list from start to end (inclusive, exclusive)
	 * only supports positive index (for now)
	 * @param start
	 * @param end
	 * @return
	 */
	public DoublyLinkedList slice(int start, int end) {
		if (start < 0)
			start = 0;
		if (end >= size)
			end = size;
		
		int i;
		DLLNode current = head;
		
		for (i = 0; i < start; i++)
			current = current.getNext();
		
		DoublyLinkedList newList = new DoublyLinkedList();
		for (i = start; i < end; i++) {
			newList.add(current.getValue());
			if (!current.isTail())
				current = current.getNext();
		}
		
		return newList;
	}
	
}
