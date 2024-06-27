//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToeplitz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    /*You are required to complete this method*/
    public static boolean isToeplitz(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check all diagonals that start from the first row
        for (int col = 0; col < cols; col++) {
            if (!checkDiagonal(matrix, 0, col)) {
                return false;
            }
        }

        // Check all diagonals that start from the first column
        for (int row = 1; row < rows; row++) {
            if (!checkDiagonal(matrix, row, 0)) {
                return false;
            }
        }

        return true;
    }

    // Helper function to check a diagonal starting from (row, col)
    private static boolean checkDiagonal(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        int rows = matrix.length;
        int cols = matrix[0].length;

        while (row < rows && col < cols) {
            if (matrix[row][col] != value) {
                return false;
            }
            row++;
            col++;
        }

        return true;
    }
    
}