package com.tpwang.adts.DoublyLinkedList;

import com.tpwang.adts.Node;

public class DLLNode extends Node {
	private DLLNode previous, next;
	
	public DLLNode(int value, DLLNode previous, DLLNode next) {
		setValue(value);
		this.previous = previous;
		this.next = next;
	}
	
	public boolean isHead() {
		return previous == null;
	}
	
	public boolean isTail() {
		return next == null;
	}
	
	public DLLNode getPrevious() { return previous; }
	
	public DLLNode setPrevious(DLLNode previous) { this.previous = previous; return this; }
	
	public DLLNode getNext() { return next; }
	
	public DLLNode setNext(DLLNode next) { this.next = next; return this; }
	
}
