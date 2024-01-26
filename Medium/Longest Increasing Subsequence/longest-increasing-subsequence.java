//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends






class Solution 
{
    //Function to find length of longest increasing subsequence.
     int longestSubsequence(int size, int a[])
    {
        List<Integer> list=new ArrayList<>();
        list.add(a[0]);
        for(int i=0;i<size;i++){
            if(a[i]>list.get(list.size()-1)){
                list.add(a[i]);
            }
            else{
                list.set(binarySe(a[i], list), a[i]);
            }
        }
        return list.size();
    }
    private int binarySe(int target, List<Integer> list){
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid)>=target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
} 