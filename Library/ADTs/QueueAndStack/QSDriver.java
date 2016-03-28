package com.peter.adts.QueueAndStack;

public class QSDriver {

	public static void main(String[] args) {
		FlexStack stack = new FlexStack();
		
		stack.push(5);
		stack.push(6);
		stack.push(12034);
		stack.push(10);
		
		stack.pop(0);
		
//		System.out.println(stack);
		
		FlexQueue queue = new FlexQueue();
		
		queue.push(1);
		queue.push(2);
		queue.push(500);
		queue.push(8);
		queue.push(15);
		
		queue.pop(3);
		
//		System.out.println(queue);
	}

}
