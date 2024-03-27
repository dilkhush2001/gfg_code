//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    int n, m, c=0;
    int min=(int)1e9;
    public  int findShortestPath(int[][] mat) {
        int n=mat.length, m=mat[0].length;
        this.n=n;
        this.m=m;
        boolean[][] vis=new boolean[n][m];
        boolean[][] vis1=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    if(j+1<m){
                        vis[i][j]=true;
                    }
                    if(j>0){
                        vis[i][j-1]=true;
                    }
                    if(i+1<n){
                        vis[i+1][j]=true;
                    }
                    if(i>0){
                        vis[i-1][j]=true;
                    }
                }
            }
        }
        
        
        for(int i=0;i<n;i++){
            c=0;
            find(mat, vis, i, 0, vis1);
            
        }
        return min==(int)1e9 ? -1 : min;
        
    }
    private void  find(int[][] mat, boolean[][] vis, int i, int j,boolean[][] vis1){
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || vis1[i][j] || mat[i][j]==0){
            return ;
            
        }
        vis1[i][j]=true;
        c+=1;
        if(j==m-1){
            min=Math.min(min, c);
        }
        
        find(mat, vis, i, j+1, vis1);
        find(mat, vis, i-1, j, vis1);
        find(mat, vis, i+1, j, vis1);
        vis1[i][j]=false;
        
        
    }
}
