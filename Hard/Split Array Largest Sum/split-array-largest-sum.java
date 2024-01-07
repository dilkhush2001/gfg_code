//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    int n, k;
     int splitArray(int[] arr , int N, int K){
        this.n=N;
        this.k=K;
        int min=0,s=0;
        for(int ele : arr){
            s+=ele;
            min=Math.max(ele, min);
        }
        if(k==n)return min;
        if(k==1)return s;
        int ans=min;
        while(min<=s){
            int mid=min+(s-min)/2;
            if(help(arr, mid)){
                ans=mid;
                s=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return ans;
    }
    private boolean help(int[] arr, int target){
        int s=0;
        int count=1;
        for(int i=0;i<n;i++){
            if(s+arr[i]<=target){
                s+=arr[i];
            }
            else{
                count++;
                s=arr[i];
            }
            
        }
        
        return count<=k;
    }
};