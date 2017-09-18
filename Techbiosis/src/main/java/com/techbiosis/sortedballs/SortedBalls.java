package com.techbiosis.sortedballs;

import java.util.Scanner;

public class SortedBalls {
	
	public static void main(String[] args){
		Node rootNode = null;
		int count = 0;
		while(true){
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			if(rootNode!=null){
				insertInSortedOrder(number,rootNode);
			}else{
				rootNode = new Node(number);
			}
			count+=1;
			int[] arr = new int[count];
			
			printInOrder(rootNode,arr,new Count(0));
			for(int i=0;i<count;i++){
				System.out.println(arr[i]);
			}
			
			
			
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
	
	public  static void printInOrder(Node node,int[] arr,Count count){
		if(node!=null){
			printInOrder(node.left,arr,count);
			arr[count.getCount()] = node.value;
			count.increment();
			//System.out.println(node.value);
			printInOrder(node.right,arr,count);
			
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

class Count {
	int count;
	public Count(int count){
		this.count = count;
	}
	
	public void increment(){
		this.count= count+1;
	}
	
	public int getCount(){
		return this.count;
	}
}