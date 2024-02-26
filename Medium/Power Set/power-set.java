//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    List<String> ans=new ArrayList<String>();
    public List<String> AllPossibleStrings(String s)
    {
        char[] arr=s.toCharArray();
        helper(arr, 0, s.length(), new StringBuilder() );
        Collections.sort(ans);
        ans.remove(0);
        return ans;
    }
    private void helper(char[] arr, int idx, int n, StringBuilder sb){
        ans.add(sb.toString());
        for(int i=idx;i<n;i++){
            sb.append(arr[i]);
            helper(arr, i+1,n,  sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}