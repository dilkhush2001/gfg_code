//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char help(char h,int r,int n){
        String s=""+h;
        while(r-->0){
            StringBuilder sb=new StringBuilder();
            for(char ch : s.toCharArray()){
                if(ch=='1'){
                    sb.append("10");
                }
                else{
                   sb.append("01");
                }
            }
            s=sb.toString();
        }
        return s.charAt(n-1);
    }
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        StringBuilder sb=new StringBuilder();
        int i=0;
        n++;
        for(i=0;i<s.length();i++){
            // System.out.println(n);
            if(n<=(1<<r))return help(s.charAt(i),r,n);
            n-=(1<<r);
        }
        return '0';
        // if(n==0)return s.charAt(i);
        
        // s=""+s.charAt(i);
        // // System.out.print(s);
        // while(r-->0){
        //     for(char ch : s.toCharArray()){
        //         if(ch=='1'){
        //             sb.append("10");
        //         }
        //         else{
        //             sb.append("01");
        //         }
        //     }
        //     s=sb.toString();
        //     // System.out.print(s);
        //     // System.out.print(sb.toString());
            
        // }
        // // System.out.println(s);
        // return s.charAt(n);
        // return '1';
    }
}