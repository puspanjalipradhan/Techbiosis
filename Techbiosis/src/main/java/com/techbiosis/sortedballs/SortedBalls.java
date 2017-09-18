package com.techbiosis.sortedballs;

import java.util.Scanner;

public class SortedBalls {
	
	private Node rootNode = null;
	private int count = 0; 
	private int[] balls = null;
	public static void main(String[] args){
		SortedBalls sortedBalls = new SortedBalls();
		while(true){
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			sortedBalls.add(number);
		}
	}
	
	public void add(int number){
		if(rootNode!=null){
			insertInSortedOrder(number,rootNode);
			
		}else{
			rootNode = new Node(number);
		}
		
		count+=1;
		int[] arr = new int[count];
		prepareInOrder(rootNode,arr,new Count(0));
		balls = arr;
	}
	
	public int[] balls(){
		return balls; 
	}
	
	public  Node insertInSortedOrder( int input,Node node){
		if(node==null){
			return node;
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
		return node;
	}
	
	public  void prepareInOrder(Node node,int[] arr,Count count){
		if(node!=null){
			prepareInOrder(node.left,arr,count);
			arr[count.getCount()] = node.value;
			count.increment();
			//System.out.println(node.value);
			prepareInOrder(node.right,arr,count);
			
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