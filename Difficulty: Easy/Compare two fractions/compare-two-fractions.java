//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        double n1=0;
        int i=0;
        while(str.charAt(i)!='/'){
            n1=n1*10 + (str.charAt(i++)-'0');
        }
        i++;
        double n2=0;
        while(str.charAt(i)!=','){
            n2=n2*10+(str.charAt(i++)-'0');
        }
        
        double n3=0;
        i=i+2;
        while(str.charAt(i)!='/'){
            n3=n3*10 + (str.charAt(i++)-'0');
        }
        i++;
        double n4=0;
        while(i<str.length()){
            n4=n4*10 + (str.charAt(i++)-'0');
        }
        if(n1==n3 && n2==n4 || (n1==0 && n3==0) || n1/n2==n3/n4)return "equal";
        return n1/n2 > n3/n4 ? (""+(int)n1+'/'+(int)n2) : (""+(int)n3+'/'+(int)n4);
        
        
    }
}
