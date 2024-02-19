//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        HashMap<Character, Integer>hm=new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : hm.values())pq.add(ele);
        while(!pq.isEmpty() && k>0){
            int temp=pq.poll();
            if(temp!=0)pq.add(temp-1);
            k-=1;
        }
        int ans=0;
        while(!pq.isEmpty()){
            int temp=pq.poll();
            ans+=temp*temp;
        }
        return ans;
    }
}