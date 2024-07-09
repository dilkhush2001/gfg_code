//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] A, int x)  
	{ 
        Arrays.sort(A);
        int N=A.length;
        int min=Integer.MAX_VALUE, ans=0;
        for(int i=0;i<N-2;i++){
            int left=i+1;
            int right=N-1;
            while(left<right){
                int sum=A[i]+A[left]+A[right];
                if(sum==x)
                    return sum;
                else if(sum<x){
                    left++;
                }
                else{
                    right--;
                }
                
                if(Math.abs(sum-x)<min){
                    min=Math.abs(sum-x);
                    ans=sum;
                }
                else if(Math.abs(sum-x)==min){
                    ans=Math.max(ans, sum);
                }
            }
        }
        return ans;
	} 
} 
