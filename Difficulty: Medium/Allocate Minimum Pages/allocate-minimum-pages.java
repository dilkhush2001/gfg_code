//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java
class Solution {
    public int findPages(int[] arr, int k) {
        // If number of students is more than the number of books, return -1
        if (k > arr.length) return -1;

        int max = 0;
        long tot = 0;
        for (int ele : arr) {
            tot += ele;
            max = Math.max(max, ele);
        }

        long left = max, right = tot;
        long result = tot;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canAllocate(arr, k, mid)) {
                result = mid; // Update result to the current mid
                right = mid - 1; // Try for a smaller maximum
            } else {
                left = mid + 1; // Increase the limit
            }
        }

        return (int) result;
    }

    private boolean canAllocate(int[] arr, int k, long maxPages) {
        int students = 1; // Start with one student
        long pagesAllocated = 0;

        for (int ele : arr) {
            if (pagesAllocated + ele > maxPages) {
                students++; // Allocate to a new student
                pagesAllocated = ele;

                if (students > k) return false; // More students needed than available
            } else {
                pagesAllocated += ele;
            }
        }

        return true;
    }
}
