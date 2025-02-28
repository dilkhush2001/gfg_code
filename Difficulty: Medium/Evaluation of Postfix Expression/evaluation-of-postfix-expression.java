//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        int d=0;
        Stack<Integer> st=new Stack<>();
        boolean flag;
        for(String str: arr){
            flag=false;
            if(str.length()>=2 && str.charAt(0)=='-'){
                flag=true;
                str=str.substring(1);
            }
            
            
            
            if(str.length()==1 && !Character.isDigit(str.charAt(0))){
                int n1=st.pop();
                int n2=st.pop();
                int fin=0;
                if(str.equals("*"))fin=n1*n2;
                else if(str.equals("-"))fin=n2-n1;
                else if(str.equals("+")) fin=n1+n2;
                else fin=n2/n1;
                
                st.push(fin);
                
            }
            else {
                d=Integer.valueOf(str);
                if(flag)d=-d;
                st.push(d);
                
            }
        }
        return st.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends