//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    int[] dp;
    public int countWays(String digits) {
        // code here
        dp=new int[digits.length()];
        Arrays.fill(dp, -1);
        return find(0, digits);
        
    }
    private int find(int idx , String digit){
        if(idx==digit.length())return 1;
        if(digit.charAt(idx)=='0')return 0;
        if(dp[idx]!=-1)return dp[idx];
        int count=find(idx+1, digit);
        
        if(idx+1<digit.length()){
            int d=Integer.parseInt(digit.substring(idx, idx+2));
            if(d<=26)
                count+=find(idx+2, digit);
        }
        return dp[idx]=count;
    }
}