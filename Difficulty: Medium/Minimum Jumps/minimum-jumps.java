//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
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

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    static int minJumps(int[] arr) {
        // code here
        if(arr[0]==0)return -1;
        int max=0, jump=0, step=0;
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max, arr[i]+i);
            if(jump==i){
                if(arr[i]==0 && jump==max)return -1;
                jump=max;
                step++;
            }
            
        }
        return step;
    }
}