package com.peter.adts.BinarySearchTree;

public class BSTDriver {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
//		bst.addNode(100);
//		bst.addNode(95);
//		bst.addNode(105);
//		bst.addNode(85);
//		bst.addNode(90);
//		bst.addNode(98);
//		bst.addNode(102);
//		bst.addNode(110);
//		bst.addNode(60);
//		bst.addNode(115);
//		bst.addNode(101);
//		
////		bst.deleteNode(100);
////		bst.deleteNode(98);
////		bst.deleteNode(105);
		
		bst.addNode(7);
		bst.addNode(1);
		bst.addNode(0);
		bst.addNode(3);
		bst.addNode(2);
		bst.addNode(5);
		bst.addNode(4);
		bst.addNode(6);
		bst.addNode(9);
		bst.addNode(8);
		bst.addNode(10);
		
		bst.printLevelOrder();
		System.out.println();
		bst.printPreOrder();
		System.out.println();
		bst.printInOrder();
		System.out.println();
		bst.printPostOrder();
	}

}