package com.techbiosis.sortedballs;

import java.util.Scanner;

public class SortedBalls {
	
	public static void main(String[] args){
		Node rootNode = null;
		while(true){
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			if(rootNode!=null){
				insertInSortedOrder(number,rootNode);
			}else{
				rootNode = new Node(number);
			}
			printInOrder(rootNode);
			
		}
	}
	
	public static void insertInSortedOrder( int input,Node node){
		if(node==null){
			return;
		}
		if(input>node.value){
			if(node.right==null){
				node.right = new Node(input);
			}else{
				insertInSortedOrder(input,node.right);
			}
		}else{
			if(node.left==null){
				node.left = new Node(input);
			}else{
				insertInSortedOrder(input,node.left);
			}
		}
	}
	
	public static void printInOrder(Node node){
		if(node!=null){
			printInOrder(node.left);
			System.out.println(node.value);
			printInOrder(node.right);
		}
	}
}


class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
	}
}