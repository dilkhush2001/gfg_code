//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java
class Pair{
    int ele , freq;
    Pair(int ele , int freq){
        this.ele=ele;
        this.freq=freq;
    }
}
class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer, Integer> hm=new HashMap<>();
        for(int ele : arr){
            hm.put(ele, hm.getOrDefault(ele, 0)+1);
        }
        
        Pair[] ar=new Pair[hm.size()];
        int i=0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            ar[i++]=new Pair(entry.getKey(), entry.getValue());
        }
        
        Arrays.sort(ar, (a, b)->(a.freq==b.freq ? a.ele-b.ele : b.freq-a.freq));
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(Pair pair : ar){
            for(i=0; i<pair.freq;i++)ans.add(pair.ele);
        }
        return ans;
        
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends