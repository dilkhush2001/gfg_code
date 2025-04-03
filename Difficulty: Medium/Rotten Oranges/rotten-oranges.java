//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Pair{
    int x, y, time;
    public Pair(int x, int y, int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}

class Solution
{
    final int[] dx={1, -1, 0, 0};
    final int[] dy={0, 0,  1, -1};
    public int orangesRotting(int[][] grid)
    {
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int fress=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==0){
                    vis[i][j]=0;
                }
                else{
                    vis[i][j]=1;
                    fress++;
                }
            }
        }
        int ans=0;
        int count=0;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            ans=Math.max(ans, curr.time);
            for(int i=0;i<4;i++){
                int newx=curr.x+dx[i];
                int newy=curr.y+dy[i];
                if(newx<m && newy<n &&newx>=0 && newy>=0 && grid[newx][newy]==1 && vis[newx][newy]!=2){
                    vis[newx][newy]=2;
                    q.add(new Pair(newx, newy, curr.time+1));
                    count++;
                }
            }
        }
        if(count!=fress)
            return -1;
        return ans;
    }
}