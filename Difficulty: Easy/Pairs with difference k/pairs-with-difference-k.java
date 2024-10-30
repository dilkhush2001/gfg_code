//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.countPairsWithDiffK(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        Map<Integer, Integer> hm=new HashMap<>();
        int c=0;
        for(int ele : arr){
            if(hm.containsKey(ele-k)){
                c+=hm.get(ele-k);
            }
            if(hm.containsKey(ele+k)){
                c+=hm.get(ele+k);
            }
            hm.put(ele, hm.getOrDefault(ele, 0)+1);
            
        }
        return c;
    }
}