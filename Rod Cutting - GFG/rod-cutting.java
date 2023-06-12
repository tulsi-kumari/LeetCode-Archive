//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[] dp=new int[price.length+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            int max=price[i-1];
            
            for(int j=1;j<=i/2;j++){
                
                max=Math.max(max,dp[j]+dp[i-j]);
                //System.out.print(max + " ");
            }
            //System.out.println();
            dp[i]=max;
        }
       // System.out.println(Arrays.toString(dp));
        
        return dp[price.length];
       
    }

}