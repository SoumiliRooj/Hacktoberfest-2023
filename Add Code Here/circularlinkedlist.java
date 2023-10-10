// Java Program to Sort the Elements
// of the Circular Linked List

import java.io.*;

public class GFG {
	// Stores Information about Node of List
	public class Node {
		int data;
		Node next;
		public Node(int data) { this.data = data; }
	}

	// Declaring Head of the Node
	public Node head_of_node = null;

	// A last pointer to help append values to our list
	public Node last = null;

	// Add method adds values to the end of the list
	public void add(int data)
	{
		Node newNode = new Node(data);
		if (head_of_node == null) {
			head_of_node = newNode;
			last = newNode;
			newNode.next = head_of_node;
		}
		else {
			last.next = newNode;
			last = newNode;
			last.next = head_of_node;
		}
	}
	// Sort_List method sorts the circular
	// linked list Using the algorithm
	public void Sort_List()
	{

		// current pointer pointing to the head of the list
		Node current = head_of_node;

		// a temp pointer
		Node temp = null;

		// variable value helps in swap of the values
		int value;

		// this is the Algorithm discussed above
		if (head_of_node == null) {
			System.out.println("Your list is empty");
		}
		else {
			while (current.next != head_of_node) {
				temp = current.next;
				while (temp != head_of_node) {
					if (current.data > temp.data) {
						value = current.data;
						current.data = temp.data;
						temp.data = value;
					}
					temp = temp.next;
				}
				current = current.next;
			}
		}
	}
	// Print_list method iterates through the list and
	// prints the values stored in the list
	public void Print_List()
	{
		Node current = head_of_node;
		if (head_of_node == null) {
			System.out.println("Your list is empty");
		}
		else {
			do {
				System.out.print(" " + current.data);
				current = current.next;
			} while (current != head_of_node);
			System.out.println();
		}
	}

	// Driver code
	public static void main(String[] args)
	{

		GFG circular_list = new GFG();
		circular_list.add(10);
		circular_list.add(6);
		circular_list.add(3);
		circular_list.add(8);
		circular_list.add(4);

		System.out.print("Original List -->	 ");
		circular_list.Print_List();
		circular_list.Sort_List();
		System.out.print("List after Sorting--> ");
		circular_list.Print_List();
	}
}
