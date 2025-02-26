//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<Integer>();
        int[] order = new int[n + 1];
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& arr[st.peek()]>=arr[i])st.pop();
            left[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])st.pop();
            right[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int windo=right[i]-left[i]-1;
            order[windo]=Math.max(order[windo], arr[i]);
        }
        for (int i = n - 1; i > 0; i--) {
            order[i] = Math.max(order[i], order[i + 1]);
        }
        for (int i = 1; i <= n; i++) {
            ans.add(order[i]);
        }
        return ans;

    }
}