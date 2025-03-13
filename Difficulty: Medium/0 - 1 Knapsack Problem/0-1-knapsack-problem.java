//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int knapsack(int w, int val[], int wt[]) {
        // code here
        int[][] dp=new int[w+1][val.length+1];
        for(int i=1;i<=val.length;i++){
            for(int j=1;j<=w;j++){
                if(j>=wt[i-1]){
                    dp[j][i]=Math.max(dp[j-wt[i-1]][i-1]+val[i-1], dp[j][i-1]);
                }
                else dp[j][i]=dp[j][i-1];
            }
        }
        return dp[w][wt.length];
    }
}
