//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> arr) {
        Set<Integer> ans=new HashSet<Integer>();
        HashMap<Integer, Integer> hm=new HashMap<>();
       int n=arr.size()/3, c=1;
       
        for(int w : arr)hm.put(w, hm.getOrDefault(w, 0)+1);
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue()>n)ans.add(entry.getKey());
        }
        if(ans.size()==0)ans.add(-1);
        return new ArrayList<>(ans);
    }
}
