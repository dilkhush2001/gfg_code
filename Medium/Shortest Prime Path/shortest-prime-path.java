//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Pair{
    int[] num;
    int st;
    Pair(int[] num , int st){
        this.num=num;
        this.st=st;
    }
}
class Solution{
    private int[] intoArr(int n){
        int[] arr=new int[4];
        int i=3;
        while(n>0){
            arr[i--]=n%10;
            n/=10;
            
        }
        return arr;
    }
    
    private int intoNum(int[] arr){
        int temp=0;
        for(int i=0;i<4;i++){
            temp=temp*10+arr[i];
        }
        return temp;
    }
    
    int solve(int num1,int num2){
        int[] start=intoArr(num1);
        int[] target=intoArr(num2);
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start, 0));
        Set<Integer> set=new HashSet<>();
        set.add(num1);
        while(!q.isEmpty()){
            // System.out.print(q.size()+" ");
            Pair pair=q.remove();
            int arr[]=pair.num;
            int step=pair.st;
            if (intoNum(arr)==num2) {
                return step;
            }
            
            for(int  j=0;j<4;j++){
                int t=arr[j];
                for(int i=0;i<=9;i++){
                    if (j == 0 && i == 0) continue;
                    arr[j]=i;
                    int tt = intoNum(arr);
                    
                    if (isPrime(tt) && !set.contains(tt)) {
                         
                        set.add(tt);
                        if (tt==num2) {
                            return step +1;
                        }
                        q.add(new Pair(intoArr(tt), step + 1));
                    }

                }
                arr[j]=t;
            }
            
        }
        System.out.println(set.size()+" ");
        return -1;
        
    }
    private boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2; i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
    
    
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends