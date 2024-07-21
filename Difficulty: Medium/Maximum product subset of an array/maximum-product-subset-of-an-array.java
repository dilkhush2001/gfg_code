//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        if(arr.size()==1)return arr.get(0);
        int neg=0, pos=0, zero=0;
        for(int ele : arr){
            if(ele<0)neg++;
            else if(ele==0)zero++;
            else pos++;
        }
        if(zero==arr.size())return 0;
        int mod=(int)1e9+7;
        long ans=1;
        int max=-11;
        if(neg%2==0 && zero==0){
            for(int ele : arr){
                ans =( ans%mod*ele)%mod;
            }
            return ans;
        }
        else if(neg%2==0 && zero>0){
            for(int ele : arr){
                if(ele==0)continue;
                ans =( ans%mod*ele)%mod;
            }
            return ans;
        }
        else{
            for(int ele : arr){
                if(ele==0)continue;
                if(ele<0)max=Math.max(max,ele);
                ans =( ans%mod*ele)%mod;
            }
        }
        
        
        if(arr.size()==2 && (arr.get(0)==0&& arr.get(1)==-1 || arr.get(1)==0 && arr.get(0)==-1))return 0;
        if(max==-11)max=1;
        ans =ans/max;
        
        return ans;
    }
}