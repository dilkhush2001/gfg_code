//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Pair{
    int ele1, ele2;
    Pair(int ele1, int ele2){
        this.ele1=ele1;
        this.ele2=ele2;
    }
}
class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        Pair[] list=new Pair[n];
        for(int i=0;i<n;i++){
            list[i]=new Pair(arr[i], brr[i]);
        }
        Arrays.sort(list, (a, b)->Math.abs(b.ele1-b.ele2)-Math.abs(a.ele1-a.ele2));
        long maxTip=0,countA=0, countB=0 ;
        int i=0;
         for (Pair p : list) {
            if ((p.ele1 >= p.ele2 && countA < x) || countB >= y) {
                maxTip += p.ele1;
                countA++;
            } else {
                maxTip += p.ele2;
                countB++;
            }
        }

        return maxTip;
    }
}
