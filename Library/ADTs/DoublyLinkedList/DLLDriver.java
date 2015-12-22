package com.peter.adts.DoublyLinkedList;

public class DLLDriver {

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.add(5);
		dll.add(6);
		dll.add(3);
		dll.add(7);
		dll.add(9);
		dll.add(6);
		dll.printAll();
		
		dll.slice(2, 9).printAll();
	}

}
