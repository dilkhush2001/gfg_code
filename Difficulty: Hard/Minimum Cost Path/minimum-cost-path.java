//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int x, y, wt;
    Pair(int x, int y, int w){
        this.x=x;
        this.y=y;
        this.wt=w;
    }
}

class Solution
{
    public int minimumCostPath(int[][] grid){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> a.wt-b.wt);
        pq.add(new Pair(0, 0, grid[0][0]));
        final int[] dx={1, -1, 0 , 0};
        final int[] dy={0, 0, 1, -1};
        int n=grid.length;
        int[][] dist=new int[n][n];
        for(int[] t : dist)Arrays.fill(t, (int)1e9);
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            for(int i=0;i<4;i++){
                int nx=pair.x+dx[i];
                int ny=pair.y+dy[i];
                
                if(nx>=0 && ny>=0 && nx<n && ny<n && (dist[nx][ny]>grid[nx][ny]+pair.wt)){
                    dist[nx][ny]=pair.wt+grid[nx][ny];
                    pq.add(new Pair(nx, ny, dist[nx][ny]));
                }
                
            }
        }
        return dist[n-1][n-1];
    
    }
}