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
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        for(int i=2;i<=N;i++){
            int carry=0;
            for(int j=0;j<list.size();j++){
                int pro=list.get(j)*i+carry;
                list.set(j, pro%10);
                carry=pro/10;
            }
            while(carry!=0){
                list.add(carry%10);
                carry /=10;
            }
        }
        Collections.reverse(list);
        return list;
        
    }
}