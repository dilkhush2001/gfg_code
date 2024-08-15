//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        head=rev(head);
        int carry=(head.data+1)/10;
        head.data=(head.data+1)%10;
        Node temp=head;
        temp=temp.next;
        Node curr=head;
        while(carry>0 && temp!=null){
            int data=temp.data+carry;
            temp.data=data%10; 
            carry=data/10;
            
            curr=temp;
            temp=temp.next;
        }
        if(carry!=0){
            curr.next=new Node(1);
        }
        return rev(head);
    }
    
    private Node rev(Node node){
        Node curr=node;
        Node prev=null;
        Node fast=node;
        while(curr!=null){
            fast=fast.next;
            curr.next=prev;
            prev=curr;
            curr=fast;
        }
        return prev;
    }
    
}

