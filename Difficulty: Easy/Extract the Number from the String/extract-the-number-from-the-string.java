//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long temp=-1;
    boolean f=false;
    long ExtractNumber(String sen) {
        long max=-1;
        int i=0;
        while(i<sen.length()){
            if(Character.isDigit(sen.charAt(i))){
                f=false;
                temp=-1;
                int idx=check(sen, i);
                if(!f){
                    max=Math.max(max, temp);
                }
                i=idx;
            }
            else{
                i++;
            }
        }
        return max;
        
        
        
    }
    int check(String s, int idx){
        temp=-1;
        int i=idx;
        for(i=idx ;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i)))break;
            if((s.charAt(i)-'0')==9){
                f=true;
            }
            temp+=s.charAt(i);
        }
        temp=Long.parseLong(s.substring(idx, i));
        return i;
    }
}