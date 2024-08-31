//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int i=0, j=0, s1=0, s2=0, max=0;
        while(i<arr1.size() && j< arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                s1+=arr1.get(i++);
            }
            else if(arr1.get(i)> arr2.get(j)){
                s2+=arr2.get(j++);
            }
            else{
                max+=Math.max(s1, s2)+arr1.get(i);
                s1=0;
                s2=0;
                i++;
                j++;
            }
        }
        
        while(i<arr1.size()){
            s1+=arr1.get(i++);
        }
        while(j<arr2.size()){
            s2+=arr2.get(j++);
        }
        return max+Math.max(s1, s2);
        
    }
}