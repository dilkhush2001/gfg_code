//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    
boolean search(int sum, int start,  
                      int end, int arr[]) 
{ 
    while (start <= end)  
    { 
        int mid = (start + end) / 2; 
        if (arr[mid] == sum)  
        { 
            return true; 
        } 
        else if (arr[mid] > sum) 
        { 
            end = mid - 1; 
        } 
        else
        { 
            start = mid + 1; 
        } 
    } 
    return false; 
} 

    public boolean findTriplet(int[] arr) {
        
            int n = arr.length;
       Arrays.sort(arr); 
  
    // Initialising nested loops 
    for(int i = 0; i < n; i++)  
    { 
        for(int j = i + 1; j < n; j++)  
        { 
              
            // Finding the sum of the numbers 
            if (search((arr[i] + arr[j]), j, n - 1, arr))  
            { 
                  
                // Printing out the first triplet 
                return true;
            } 
        } 
    } 
    
    return false;
        
    }
}






//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            boolean res = obj.findTriplet(arr);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends