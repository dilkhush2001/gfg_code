//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/

class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(in[i], i);
        }
        
        return helper(in, 0, n-1, post, 0, n-1, hm);
    }
    private Node helper(int in[], int inBeg, int inEnd, int post[], int postBeg, int postEnd,HashMap<Integer, Integer> hm ){
        if(inBeg>inEnd || postBeg>postEnd){
            return null;
        }
         
        Node root=new Node(post[postEnd]);
        int k=hm.get(post[postEnd]);
        
        root.left=helper(in , inBeg, k-1,post , postBeg ,postBeg + k - (inBeg + 1) , hm );
        root.right=helper(in , k+1, inEnd, post, postBeg+k-inBeg, postEnd-1, hm);
        
        return root;
     }
}