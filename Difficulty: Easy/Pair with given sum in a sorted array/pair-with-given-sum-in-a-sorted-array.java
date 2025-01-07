//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    int countPairs(int arr[], int target) {
        int i = 0, j = arr.length - 1, ans = 0;
        
        while (i < j) {
            int sum = arr[i] + arr[j];
            
            if (sum == target) {
                // Count duplicates for arr[i] and arr[j]
                if (arr[i] == arr[j]) {
                    // If arr[i] == arr[j], we can pick any two elements from the range [i, j]
                    int count = j - i + 1;
                    ans += (count * (count - 1)) / 2; // Combination of 2 elements from count
                    break;
                } else {
                    int c1 = 1, c2 = 1;
                    
                    while (i < j && arr[i] == arr[i + 1]) {
                        c1++;
                        i++;
                    }
                    
                    while (i < j && arr[j] == arr[j - 1]) {
                        c2++;
                        j--;
                    }
                    
                    // Add all pairs formed by c1 and c2
                    ans += c1 * c2;
                    
                    // Move pointers
                    i++;
                    j--;
                }
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return ans;
    }
}



//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends