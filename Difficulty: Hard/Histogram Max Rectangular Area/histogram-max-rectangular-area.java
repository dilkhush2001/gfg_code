//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int getMaxArea(int hist[]) {
        int n=hist.length;
        int MaxArea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            
            while(!st.isEmpty() && (i==n || hist[i]<=hist[(int)st.peek()])){
                int h=hist[st.pop()];
                int l=st.isEmpty()?i :i-st.peek()-1;
                MaxArea=Math.max(MaxArea, l*h);
            }
            st.push(i);
        }
        return MaxArea;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends