//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        StringBuilder sb = new StringBuilder(); 
        int i = A.length() - 1, j = B.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 ) {
            int sum = carry;
            int n1=0, n2=0;
            if (i >= 0) {
                 n1 = A.charAt(i--) - '0'; 
            } 
            if (j >= 0) {
                 n2= B.charAt(j--) - '0'; 
            }
            int value=n1+n2+sum;
            
            sb.append(value % 2); 
            carry = value / 2;
        }
        if(carry!=0){
            sb.append(carry);
        }
        sb=sb.reverse();
        while(sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}