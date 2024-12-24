//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends






class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // Edge case: empty matrix
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }

        int n = mat.length;
        int m = mat[0].length;

        // Step 1: Find the potential row using binary search
        int row = findRow(mat, x, n, m);
        if (row == -1) return false; // No valid row found

        // Step 2: Perform binary search in the identified row
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mat[row][mid] == x) {
                return true;
            } else if (mat[row][mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    private int findRow(int[][] mat, int x, int n, int m) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mat[mid][0] <= x && x <= mat[mid][m - 1]) {
                return mid; // Found the correct row
            } else if (mat[mid][0] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // No valid row found
    }
}
