//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends




/*You are required to complete this method*/


class Solution
{
    int[][] dp;
    int mod=(int)1e9+7;
    int  subsequenceCount(String s, String t)
    {
        dp=new int[s.length()][t.length()];
        for(int[] temp : dp)Arrays.fill(temp, -1);
        return help(s, t, 0, 0);
	// Your code here	
    }
    int help(String s, String t, int i, int j){
        if(j>=t.length())return 1;
        if(i>=s.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int with=0, without=0;;
        if(s.charAt(i)==t.charAt(j)){
            with=help(s, t, i+1, j+1);
        }
        without=help(s, t, i+1, j);
        return dp[i][j]=(with%mod+without%mod)%mod;
    }
}