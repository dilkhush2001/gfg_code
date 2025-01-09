//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            ans.add(-1);
            return ans;
        }

        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0; // Initialize the prefix for index 0
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int j = 0; // Pointer for the start of the window
        for (int i = 1; i <= arr.length; i++) {
            while (j < i && prefix[i] - prefix[j] > target) {
                j++;
            }
            if (prefix[i] - prefix[j] == target) {
                ans.add(j + 1); // Convert to 1-based index
                ans.add(i);
                return ans;
            }
        }

        ans.add(-1); // If no subarray is found
        return ans;
    }
}
