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
     int splitArray(int[] arr , int N, int K) {
        this.n=N;
        this.k=K;
        int min=0;
        int max=0;
        for(int ele : arr){
            max+=ele;
            min=Math.max(min, ele);
        }
        if(k==1)return max;
        if(k==n)return min;
        int ans=min;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(help(arr, mid, n)){
                max=mid-1;
                ans=mid;
            }
            else{
                min=mid+1;
            }
        }
        return ans;
        
    }
    private boolean help(int[] arr, int target, int n){
        int c=1;
        int ans=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if((sum+arr[i])<=target){
                sum+=arr[i];
            }
            else{
                c+=1;
                sum=arr[i];
            }
        }
        return c<=k;
    }
};