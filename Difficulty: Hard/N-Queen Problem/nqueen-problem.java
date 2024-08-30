//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<Integer> board = new ArrayList<>();
        solveNQueen(board, n);
        return ans;
    }

    private void solveNQueen(ArrayList<Integer> board, int n) {
        if (board.size() == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 1; row <= n; row++) {
            if (isSafe(board, row)) {
                board.add(row);
                solveNQueen(board, n);
                board.remove(board.size() - 1); 
            }
        }
    }

    private boolean isSafe(ArrayList<Integer> board, int row) {
        int col = board.size();
        for (int i = 0; i < col; i++) {
            int placedRow = board.get(i);
            // Check if the queen is in the same row or diagonal
            if (placedRow == row || Math.abs(placedRow - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
}
