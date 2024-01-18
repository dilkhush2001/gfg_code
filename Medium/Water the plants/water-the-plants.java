//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java
class Pair{
    int ele, idx;
    Pair(int ele, int idx){
        this.ele=ele;
        this.idx=idx;
    }
}

class Solution
{
    boolean[] vis;
    int min_sprinklers(int gallery[], int n)
    {
        // ArrayList<Pair> list=new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     if(gallery[i]==-1)continue;
        //     int left=i-gallery[i]<0 ? 0: i-gallery[i];
        //     int right=i+gallery[i]>n ? n : i-gallery[i];
        //     list.add(new Pair(left, right));
        // }
        // Collections.sort(list, new Comparator<Pair>() {
        //     @Override
        //     public int compare(Pair p1, Pair p2) {
        //         int compareEle = Integer.compare(p2.ele, p1.ele);
        //         if (compareEle == 0) {
        //             return Integer.compare(p2.idx, p1.idx);
        //         }
        //         return compareEle;
        //     }
        // });
       // System.out.print(list.get(0).idx);
        int[] arr=new int[n];
        Arrays.fill(arr, -1);
        for(int i=0;i<n;i++){
            int left=Math.max(0, i-gallery[i]);
            int right=Math.min(n-1, i+gallery[i]);
            
            for(int j=left;j<=right;j++){
                arr[j]=Math.max(arr[j], right);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==-1)return -1;
            if(i<=arr[i])count++;
            i=arr[i];
        }
        return count;
       
       
        
    }
}
