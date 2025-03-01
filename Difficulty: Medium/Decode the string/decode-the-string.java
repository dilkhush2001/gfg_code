//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        Stack<String> st=new Stack<>();
        Stack<Integer> num=new Stack<>();
        int n=0;
        StringBuilder sb=new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                n=n*10+(ch-'0');
            }
            else if(ch=='['){
                num.push(n);
                st.push(sb.toString());
                sb=new StringBuilder();
                n=0;
            }
            else if(ch==']') {
                int it=num.pop();
                String ss=st.pop()+sb.toString().repeat(it);
               sb=new StringBuilder(ss);
               
                
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}