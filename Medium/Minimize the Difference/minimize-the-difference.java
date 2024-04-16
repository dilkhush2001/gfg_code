//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



// /import java.util.Arrays;

class Solution {
    public int minimizeDifference(int n, int k, int[] arr) {
        // Store min and max
        int[] minLeft = new int[n];
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        int[] maxRight = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                minLeft[i] = arr[i];
                maxLeft[i] = arr[i];
            } else {
                minLeft[i] = Math.min(minLeft[i - 1], arr[i]);
                maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                minRight[i] = arr[i];
                maxRight[i] = arr[i];
            } else {
                minRight[i] = Math.min(minRight[i + 1], arr[i]);
                maxRight[i] = Math.max(maxRight[i + 1], arr[i]);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int mini = Integer.MAX_VALUE;
            int maxi = Integer.MIN_VALUE;
            int leftInd = i - 1;
            int rightInd = i + k;
            if (leftInd >= 0) { // min and max may present at the left of the window
                mini = Math.min(mini, minLeft[leftInd]);
                maxi = Math.max(maxi, maxLeft[leftInd]);
            }
            
            if (rightInd < n) { // min and max may present at the right side of the window
                mini = Math.min(mini, minRight[rightInd]);
                maxi = Math.max(maxi, maxRight[rightInd]);
            }
            ans = Math.min(ans, maxi - mini);
        }
        
        return ans;
    }
}
