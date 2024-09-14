//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> po=new ArrayList<>(); 
        ArrayList<Integer> ne=new ArrayList<>(); 
        
        for(int ele : arr){
            if(ele<0)ne.add(ele);
            else po.add(ele);
        }
        int i=0, idx=0;
        int j=0;
            while(i<po.size() && j < ne.size() &&(idx+1)<arr.size()){
                arr.set(idx, po.get(i++));
                arr.set(idx+1, ne.get(j++));
                idx+=2;
            }
           
        while(i<po.size() && idx<arr.size()){
            arr.set(idx++, po.get(i++));
        }
        
        while(j<ne.size() && idx<arr.size()){
            arr.set(idx++, ne.get(j++));
        }
    }
}