//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        Deque<Integer> min=new LinkedList<>();
        Deque<Integer> max=new LinkedList<>();
        int s=0, end=0, ress=0, resend=0;
        
        for(int i=0;i<arr.length;i++){
            while(!min.isEmpty() && arr[min.peekLast()]>arr[i])min.pollLast();
            while(!max.isEmpty() && arr[max.peekLast()]<arr[i])max.pollLast();
            min.addLast(i);
            max.addLast(i);
            
            while(arr[max.peekFirst()]-arr[min.peekFirst()]>x){
                if(s==min.peekFirst())min.pollFirst();
                if(s==max.peekFirst())max.pollFirst();
                s++;
            }
            
            if(i-s>resend-ress){
                ress=s;
                resend=i;
            }
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        
        for(int i=ress;i<=resend;i++)ans.add(arr[i]);
        return ans;
        
        
    }
}



//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends