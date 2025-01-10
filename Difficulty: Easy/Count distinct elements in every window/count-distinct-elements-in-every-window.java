//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Map<Integer, Integer> hm=new HashMap<>();
        int i=0, j=0;
        while(i<arr.length){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
            if(i-j+1>=k){
                ans.add(hm.size());
                hm.put(arr[j], hm.getOrDefault(arr[j], 0)-1);
                if(hm.get(arr[j])==0)hm.remove(arr[j]);
                j++;
            }
            i++;
        }
        return ans;
    }
    
}
