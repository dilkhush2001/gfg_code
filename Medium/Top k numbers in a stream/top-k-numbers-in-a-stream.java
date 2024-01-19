//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


class Pair{
    int ele, freq=0;
    Pair(int ele, int freq){
        this.ele=ele;
        this.freq=freq;
    }
}

class Solution {
    // int K;
    // ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    public  ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int k) {
       ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i:arr)
        {
            ArrayList<Integer> a=new ArrayList<>();
            map.put(i,map.getOrDefault(i,0)+1);
            PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->{
                if(map.get(x) == map.get(y))
                    return x - y;
                return map.get(y) - map.get(x);
            });
            
            for(int key:map.keySet())
                pq.add(key);
            
            int c=0;
            while(!pq.isEmpty())
            {
                if(c<k)
                {
                    a.add(pq.peek());
                    c++;
                }
                pq.poll();
            }
            list.add(a);
        }
        return list;
    }
    // void help(PriorityQueue<Pair> pq, int k){
    //     ArrayList<Pair> q = new ArrayList<>();
    //     LinkedHashSet<Integer> list=new LinkedHashSet<>();
    //     while(!pq.isEmpty()){
    //         Pair pair=pq.poll();
    //         list.add(pair.ele);
    //         q.add(pair);
    //     }
    //     for(Pair ele : q)pq.add(ele);
    //     if(list.size()<=k)ans.add(new ArrayList<>(list));
    //     else{
    //         ArrayList<Integer> l=new ArrayList<>();
    //         for(int ele :list ){
    //             l.add(ele);
    //             k--;
    //             if(k==0)break;
    //         }
    //         ans.add(l);
            
    //     }
        
    // }
}