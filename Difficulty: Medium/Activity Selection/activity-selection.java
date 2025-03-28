//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Pair{
    int a,  b;
    Pair(int a, int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        Pair[] arr=new Pair[start.length];
        for(int i=0;i<start.length;i++){
            arr[i]=new Pair(start[i], finish[i]);
        }
        Arrays.sort(arr, (x, y) -> Integer.compare(x.b, y.b));
        
        int ac=1;
        int last=arr[0].b;
        for(int i=1;i<start.length;i++){
            if(arr[i].a>last){
                ac++;
                last=arr[i].b;
            }
        }
        return ac;
    }
}
