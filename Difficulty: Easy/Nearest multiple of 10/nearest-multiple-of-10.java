//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        char ch=str.charAt(str.length()-1);
        if(ch-'0'<=5)return str.substring(0, str.length()-1)+"0";
        StringBuilder sb=new StringBuilder();
        sb.append(0);
        int carry=1, idx=str.length()-2;
        
         while (idx >= 0) {
            int digit = (str.charAt(idx) - '0') + carry;
            sb.append(digit % 10);
            carry = digit / 10;
            idx--;
        }
        if(carry>0)sb.append(carry);
        
        return sb.reverse().toString();
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Endshttps://media.geeksforgeeks.org/img-practice/chatIcon-1653561581.svg
