//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int max=arr[0];
        for(int ele : arr)max=Math.max(max, ele);
        
        for(int i=1;i<=max;i++){
            if(!binarySerch(i, arr)){
                k--;
            }
            if(k==0)return i;
        }
        return max+k;
    }
    boolean binarySerch(int tar, int[] arr){
        int left=0;
        int right=arr.length-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            
            if(arr[mid]==tar)return true;
            if(arr[mid]<tar)left=mid+1;
            else right=mid-1;
        }
        return false;
    }
}