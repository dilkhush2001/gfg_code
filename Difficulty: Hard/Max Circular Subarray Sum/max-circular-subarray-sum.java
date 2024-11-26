//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution{

   
    static int circularSubarraySum(int a[]) {
        int n=a.length;
        if(a==null)
            return 0;
        if(n==1)
            return a[0];
        int sum=0;
        for(int num:a)
            sum+=num;
            
            
        int max=a[0],currentMax=a[0], min=a[0],currentMin=a[0];
        for(int i=1;i<n;i++){
            currentMax=Math.max(a[i],currentMax+a[i]);
            max=Math.max(max, currentMax);
            
            currentMin=Math.min(a[i],currentMin+a[i]);
            min=Math.min(min, currentMin);
        }
        if(min==sum)
            return max;
        
        return Math.max(max, sum-min);
    }
    
}

