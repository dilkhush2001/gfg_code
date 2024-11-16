//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int i=0, idx=0;
        while(i<arr.length){
            boolean f=false;
            while(i<arr.length-1 && arr[i]==0 && arr[i+1]==0){
                i+=1;
                f=true;
            }
            if(f || arr[i]==0)i++;
            if(i<arr.length)
            arr[idx++]=arr[i++];
        }
        while(idx<arr.length)arr[idx++]=0;
        
    }
}