//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer> ans=new ArrayList<Integer>();
        int n1=0,  n2=0, c1=0, c2=0;
        for(int ele : nums){
            if(ele==n1)c1++;
            else if(ele==n2)c2++;
            else if(c1==0){
                n1=ele;
                c1=1;
            }
            else if(c2==0){
                n2=ele;
                c2=1;
            }
            else {
                c1--;
                c2--;
            }
        }
        c1=0; c2=0;
        for(int ele : nums){
            if(ele==n1)c1++;
            else if(ele==n2)c2++;
        }
        if(c1>nums.length/3)ans.add(n1);
        if(c2>nums.length/3)ans.add(n2);
        
        Collections.sort(ans);
        return ans;
    }
}
