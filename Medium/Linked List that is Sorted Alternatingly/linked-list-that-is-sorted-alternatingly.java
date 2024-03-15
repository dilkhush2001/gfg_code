//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
   public Node sort(Node head){
    //   if(head==null || head.next==null)return head;
       
    //     Node dummy1=new Node(-1);
    //     Node cur1=dummy1;
    //     Node slow=head;
        
    //     Node dummy2=new Node(-1);
    //     Node cur2=dummy2;
    //     Node fast=head.next;
        
    //     while(slow!=null && fast!=null && slow.next!=null && fast.next!=null){
    //         cur1.next=slow;
    //         cur1=cur1.next;
    //         slow=slow.next.next;
            
            
    //         cur2.next=fast;
    //         cur2=cur2.next;
    //         fast=fast.next.next;
    //     }
    ArrayList<Integer> list=new ArrayList<>();
    while(head!=null){
        list.add(head.data);
        head=head.next;
    }
    Node dummy=new Node(-1);
    head=dummy;
    Collections.sort(list);
    for(int ele : list){
        head.next=new Node(ele);
        head=head.next;
    }
    
        
        
        
        
       
        
        return dummy.next;
        
   }


}