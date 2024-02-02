//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
        boolean f=false;
	    if(s.charAt(0)=='-'){
	        s=s.substring(1);
	        f=true;
	    }
	    for(char ch : s.toCharArray()){
	        if(!Character.isDigit(ch))return -1;
	    }
	    int n=Integer.parseInt(s);
	    return f? -n : n;
    }
}
