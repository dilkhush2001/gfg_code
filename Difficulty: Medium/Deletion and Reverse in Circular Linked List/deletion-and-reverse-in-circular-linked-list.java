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

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head) {
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        Node next = null;
        Node first = head;
        
        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != first);
        
        head.next = prev;
        head = prev;
        
        return head;
    }
       Node deleteNode(Node head, int key) {
        if (head == null) {
            return null; // Empty list
        }
        
        Node curr = head;
        Node prev = null;
        
        // If the head is the node to be deleted
        if (head.data == key) {
            if (head.next == head) {
                // Single node case
                return null;
            } else {
                // Find the last node to update its next pointer
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }
                // Remove head and fix the circular link
                head = head.next;
                last.next = head;
                return head;
            }
        }
        
        // Traverse to find the node to delete
        do {
            prev = curr;
            curr = curr.next;
        } while (curr != head && curr.data != key);
        
        // If node with the key is found
        if (curr.data == key) {
            prev.next = curr.next;
        }
        
        return head;
    }
}