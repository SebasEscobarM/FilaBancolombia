package model;

public class Node {
	
	private Node next;
	private Node prev;
	private int val;
	private int pass;
	
	public Node(int val) {
		this.val=val;
		this.pass=0;
		this.next=null;
		this.prev=null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}
	
	
}
