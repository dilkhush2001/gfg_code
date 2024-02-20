//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends

class Solution
{
    public static int wordBreak(int n, String s, ArrayList<String> dic )
    {
        if(s.isEmpty())return 1;
        int len=s.length();
        for(int i=1;i<=len;i++){
            String pre=s.substring(0,i);
            if(dic.contains(pre) && wordBreak(n, s.substring(i), dic)==1)return 1;
        }
        return 0;
    }
    
}