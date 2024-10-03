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
        int n1=0, n2=0, c1=0, c2=0;
        for(int ele : arr){
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
            else{
                c1--;
                c2--;
            }
        }
        
        c1=0; c2=0;
        for(int ele : arr){
            if(ele==n1)c1++;
            else if(ele==n2)c2++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(c1>arr.size()/3)ans.add(n1);
        if(c2>arr.size()/3)ans.add(n2);
        
        if(ans.size()==0)ans.add(-1);
        Collections.sort(ans);
        return ans;
           
    }
}

