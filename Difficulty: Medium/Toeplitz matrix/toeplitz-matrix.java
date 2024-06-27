//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToeplitz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    /*You are required to complete this method*/
    int n, m;
    boolean isToeplitz(int mat[][]) {
        if (mat == null || mat.length == 0) {
            return true;
        }
        this.n=mat.length;
        this.m=mat[0].length;
        for(int i=0;i<m;i++){
            if(!check(mat, 0, i))return false;
        }
        
        for(int j=1;j<n;j++){
            if(!check(mat, j, 0))return false;
        }
        
        return true;
    }
    private boolean check(int[][] mat, int x, int y){
        int data=mat[x][y];
    
        while(x<n && y<m){
            if(mat[x][y]!=data)return false;
            x++;
            y++;
        }
        return true;
    }
}