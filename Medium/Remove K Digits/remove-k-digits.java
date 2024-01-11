//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int k) {
        // code here
        Stack<Integer> st=new Stack<>();
        for(char ch : S.toCharArray()){
            
            while(!st.isEmpty() && st.peek()>(ch-'0') && k>0){
                st.pop();
                k--;
            }
            st.push(ch-'0');
            
        }
        while(!st.isEmpty()&& k>0 ){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())sb.append(st.pop());
        
        sb=sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length()==0?"0":sb.toString();
        
    }
}