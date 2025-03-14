//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends

class Solution {
    int search(int[] arr, int key) {
        int l = 0, h = arr.length - 1;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            
            // Check if the mid element is the key
            if (arr[mid] == key) {
                return mid;
            }
            
            // Determine which half is sorted
            if (arr[l] <= arr[mid]) { // Left half is sorted
                if (key >= arr[l] && key < arr[mid]) {
                    h = mid - 1; // Key lies in the sorted left half
                } else {
                    l = mid + 1; // Key lies in the right half
                }
            } else { // Right half is sorted
                if (key > arr[mid] && key <= arr[h]) {
                    l = mid + 1; // Key lies in the sorted right half
                } else {
                    h = mid - 1; // Key lies in the left half
                }
            }
        }
        
        return -1; // Key not found
    }
}