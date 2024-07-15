//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        int max=0;
        for(int i=0;i<d;i++){
            max=max*10+9;
        }
        int min=(int)Math.pow(10,d-1);
        
        for(int i=min;i<=max;i++){
            if(sum(i)==s){
                
                return Integer.toString(i);
                
            }
        }
        return "-1";
    }
    private int sum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
            
        }
        return sum;
        
    }
}
