//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int pro=1;
        int z=0;
        for(int i : arr){
            if(i==0){
                z++;
                continue;
            }
            pro*=i;
            
        }
        int[] ans=new int[arr.length];
        if(z>1)return ans;
        if(z==1){
            for(int i =0;i<arr.length;i++){
                if(arr[i]==0)ans[i]=pro;
            }
            return ans;
        }
        for(int i =0;i<arr.length;i++){
            ans[i]=(pro/arr[i]);
        }
        return ans;
    }
}