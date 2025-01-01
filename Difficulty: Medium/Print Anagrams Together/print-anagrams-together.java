//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends


class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] string_list) {
        HashMap<String, ArrayList<String>> hm=new HashMap<>();
        for(String word: string_list){
            char[] arr=word.toCharArray();
            Arrays.sort(arr);
            String sorted=new String(arr);
            if(hm.containsKey(sorted)){
                hm.get(sorted).add(word);
            }
            else{
                ArrayList<String> list=new ArrayList<>();
                list.add(word);
                hm.put(sorted, list);
            }
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<ArrayList<String>>();
        for(String key: hm.keySet()){
            ArrayList<String> wordList = hm.get(key);
            //Collections.sort(wordList);
            ans.add(wordList);
        }
        return ans;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends