//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        int[] arr=new int[26];
        int tot=0;
        for(char ch : str.toCharArray()){
            int idx=ch-'a';
            if(idx>=0 && idx<26){
                tot++;
                arr[idx]++;
            }
        }
        int c=0;
        for(int ele : arr){
            if(ele!=0)c++;
        }
        if(tot>=26&&(26-c)<=k){
            return true;
        }else{
            return false;
        }
        
        
    }
}