//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Pair {
    int x, y;
    double d;
    
    Pair(int x, int y, double d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Pair[] a = new Pair[points.length];
        int idx = 0;

        for (int[] tt : points) {
            a[idx++] = new Pair(tt[0], tt[1], Math.sqrt(tt[0] * tt[0] + tt[1] * tt[1]));
        }

        Arrays.sort(a, (X, Y) -> Double.compare(X.d, Y.d)); 

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i][0] = a[i].x;
            ans[i][1] = a[i].y;
        }

        return ans;
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends