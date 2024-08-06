//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    public boolean isValid(String s) {
       String[] arr=s.split("\\.");
        if(arr.length!=4)
            return false;
        for(int i=0;i<4;i++){
            String str=arr[i];
            if(str.length()==0)
                return false;
            if(str.length()>3)
                return false;
            if(str.charAt(0)=='0' && str.length()!=1)
                return false;
            if(!check(str))
                return false;
        }
        if(s.charAt(s.length()-1)=='.')
            return false;
        return true;
    }
    private static boolean check(String s){
        int sum=Integer.parseInt(s);
        return sum<=255;
    } 
    
}