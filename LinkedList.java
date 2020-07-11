package Stack;

public class LinkedList {
     Node head;
	public static class Node{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
	public void push(int data)
	{
		Node first=new Node(data);
		if(head==null)
		{
			head=first;
		}
		else {
		Node k=head;
		head=first;
		first.next=k;
	
	}
		System.out.println(data);
	}
	public void pop()
	{
		int popped;
		if(head==null)
		{
			System.out.println("underflow  - stack is empty");
		}
		else
		{
			popped=head.data;
			head=head.next;
			System.err.println("removed element is "+popped);
		}
	}
	public void peek()
	{
		if(head==null)
		{
			System.out.println("stack is empty");
		}
		else
		{
			System.out.println("top value of the stack is "+head.data);
		}
	}
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		else
			return false;
	}
	public static void main(String args[])
	{
		LinkedList list=new LinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.pop();
		list.peek();
		System.out.println(list.isEmpty());
		}
	
}
