//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<List<Integer>> set=new ArrayList<>();
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        Arrays.sort(arr);
        find(arr, n, k, 0, new ArrayList<Integer>());
        return set;
    }
    private void find(int[] arr, int n , int k , int i, ArrayList<Integer> temp){
        if(k==0){
            if(!set.contains(temp))
            set.add(new ArrayList<>(temp));
            // System.out.println(temp);
            return ;
        }
        if(k<0 || i==n)return ;
        temp.add(arr[i]);
        find(arr, n, k-arr[i], i+1, temp);
        temp.remove(temp.size()-1);
        find(arr, n, k, i+1, temp);

    }
}
