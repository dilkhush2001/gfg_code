//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            boolean ans = obj.canAttend(arr);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean canAttend(int[][] arr) {
        // Your code here
        int max=0;
        Set<Integer> set=new HashSet<>();
        for(int[] tt : arr){
            max=Math.max(max, tt[1]);
            set.add(tt[1]);
        }
        int[] a=new int[max+2];
        
        for(int[] tt : arr){
            a[tt[0]]+=1;
            a[tt[1]]=-1;
        }
        for(int i=1;i<a.length;i++){
            a[i]=a[i]+a[i-1];
            if(a[i]>1 && !set.contains(i))return false;
        }
        return true;
    }
}