package com.tpwang.adts.QueueAndStack;

import com.tpwang.adts.Node;

public class QSNode extends Node {
	private QSNode previous, next;
	
	public QSNode(int value, QSNode previous, QSNode next) {
		setValue(value);
		this.previous = previous;
		this.next = next;
	}
	
	public boolean isHead() {
		return this.previous == null && this != null;
	}
	
	public boolean isTail() {
		return this.next == null && this != null;
	}
	
	public QSNode getPrevious() { return previous; }
	
	public QSNode setPrevious(QSNode previous) { this.previous = previous; return this; }
	
	public QSNode getNext() { return next; }
	
	public QSNode setNext(QSNode next) { this.next = next; return this; }
	
}
