//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends




/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node ans=new Node(-1);
    Node mergeResult(Node node1, Node node2)
    {
        Node temp=ans;
        Node curr1=node1;
        Node curr2=node2;
        while(curr1!=null && curr2!=null){
            if(curr1.data<curr2.data){
                temp.next=curr1;
                curr1=curr1.next;
            }
            // else if(curr1.data==curr2.data){
            //     temp.next=curr1;
            //     temp=temp.next;
            //     temp.next=curr1;
            //     curr2=curr2.next;
            //     curr1=curr1.next;
            // }
            else{
                temp.next=curr2;
                curr2=curr2.next;
            }
            temp=temp.next;
        }
        while(curr1!=null){
            temp.next=curr1;
            curr1=curr1.next;
            temp=temp.next;
        }
        while(curr2!=null){
            temp.next=curr2;
            curr2=curr2.next;
            temp=temp.next;
        }
        
        ans=ans.next;
        help();
        return ans;
        
    }
    private void help(){
        Node prev=null;
        Node fast=ans;
        Node next=ans;
        while(fast!=null){
            fast=next.next;
            next.next=prev;
            prev=next;
            next=fast;
        }
        ans=prev;
    }
}
