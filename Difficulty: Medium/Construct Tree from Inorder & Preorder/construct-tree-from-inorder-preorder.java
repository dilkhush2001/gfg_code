//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        int n=inorder.length;
        return buildTree(preorder, 0, n-1, inorder, 0, n-1);
    }
     static Node buildTree(int [] preOrder, int psi, int pei, int [] inOrder, int isi, int iei){
        if(isi > iei){
            return null;
        }
        int idx = isi;
        
        while(inOrder[idx] != preOrder[psi]) idx++;
        int count = idx - isi;
        Node node = new Node(preOrder[psi]);
        
        node.left = buildTree(preOrder, psi+1, psi+count, inOrder, isi, idx-1);
        node.right = buildTree(preOrder, psi+count+1, pei, inOrder, idx+1, iei);
        
        return node;
    }
}
