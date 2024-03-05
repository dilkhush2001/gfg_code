//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        int[] maxA=new int[n];
        int[] minA=new int[n];
        
        
        int min=(int)1e9;
        int max=-(int)1e9;
        
        for(int i=0;i<n;i++){
            min=Math.min(a[i], min);
            minA[i]=min;
        }
        
        for(int i=n-1;i>=0;i--){
            max=Math.max(a[i], max);
            maxA[i]=max;
        }
        
        int i=0, j=0;
        int ans=-1;
        while(j<n && i<n){
            if(maxA[j]>=minA[i]){
                ans=Math.max(ans, j-i);
                j++;
            }
            else i++;
        }
        return ans;
        
    }
}
