//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        int r=matrix.length, c=matrix[0].length;
         ArrayList<Integer> ar=new ArrayList<Integer>();
        int top=0,  bottom=r-1, left=0, right=c-1;
        while(top<=bottom && left <= right){
            for(int i=left;i<=right;i++){
                ar.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ar.add(matrix[i][right]);
            }
            right--;
            if(top<= bottom){
                for(int i=right;i>=left;i--){
                    ar.add(matrix[bottom][i]);
                }
                
            }
            bottom--;
            if(left<=right){
                for(int i=bottom ;i>=top;i--){
                    ar.add(matrix[i][left]);
                }
            }
            left++;
            
        }
        return ar;
        
    }
}
