//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        int idx=0;
        boolean bool=false;
        while(idx<s.length() &&s.charAt(idx)==' ')idx++;
        if(idx<s.length() && s.charAt(idx)=='-'){
            bool=true;
            idx++;
        }
        
        if(idx<s.length() && s.charAt(idx)=='+'){
            idx++;
        }
        s=s.substring(idx);
        long ans=0;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        for(char ch : s.toCharArray()){
            if(!Character.isDigit(ch))break;
            ans=ans*10+(ch-'0');
            if(ans>=max){
                if(bool)return min;
                return max;
            }
            if(ans<(-max))return -max;
        }
        if(bool)ans=-ans;
        return (int)ans;
        
    }
}