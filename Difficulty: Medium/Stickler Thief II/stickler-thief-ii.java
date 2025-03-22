//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
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

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int[][] dp;
    public int maxValue(int arr[]) {
        // code here
        dp=new int[arr.length][2];
        for(int[] t : dp)Arrays.fill(t, -1);
        return Math.max(find(arr, 0, 0), find(arr, 1, 1));
        
    }
    private int find(int[] arr, int idx, int s){
        if(idx==arr.length-1 && s==0)return 0;
        if(idx>=arr.length)return 0;
        if(dp[idx][s]!=-1)return dp[idx][s];
        int take=arr[idx]+find(arr, idx+2, s);
        int ntake=find(arr, idx+1,s);
        return dp[idx][s]=Math.max(take, ntake);
    }
}