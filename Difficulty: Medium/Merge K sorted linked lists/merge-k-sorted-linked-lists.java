//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }

            Solution sol = new Solution();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to merge K sorted linked list.
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    Node mergeKLists(List<Node> arr) {
        
        for(int i=0;i<arr.size();i++){
            find(arr.get(i));
        }
        Node root=new Node(-1);
        Node ptr=root;
        while(!pq.isEmpty()){
            ptr.next=new Node(pq.poll());
            ptr=ptr.next;
            
        }
        return root.next;
    }
    void find(Node t){
        while(t!=null){
            pq.add(t.data);
            t=t.next;
        }
        
    }
}