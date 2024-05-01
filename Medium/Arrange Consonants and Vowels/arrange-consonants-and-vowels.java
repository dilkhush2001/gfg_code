//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        ArrayList<Character> vowel=new  ArrayList<>();
        ArrayList<Character> cons= new ArrayList<>();
        while(head!=null){
            if(check(head.data)){
                vowel.add(head.data);
            }
            else
                cons.add(head.data);
            head=head.next;
        }
        Node dummy=new Node('a');
        Node curr=dummy;
        for(char ch: vowel){
            curr.next=new Node(ch);
            curr=curr.next;
        }
        for(char ch: cons){
            curr.next=new Node(ch);
            curr=curr.next;
        }
        return dummy.next;
    }
    public static boolean check(char ch){
        return ch=='a' || ch=='e'|| ch=='i' || ch=='o'|| ch=='u';
    }
}