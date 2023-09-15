//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=Arrays.stream(arr).sum();
        if(sum%2!=0)
        {
            return 0;
        }
         Boolean[][] dp = new Boolean[N+1][sum/2+1];
        return subsetSum(sum/2,arr,N,0,dp)==true?1:0;
    }
    static boolean subsetSum(int sum,int[] arr,int N,int i,Boolean[][] dp)
    {
        if(sum==0)
        {
            return true;
        }
        if(i>=N)
        {
            return false;
        }
        if(dp[i][sum]!=null)
        {
            return dp[i][sum];
        }
        if(arr[i]<=sum)
        {
            return dp[i][sum]= subsetSum(sum-arr[i],arr,N,i+1,dp)||subsetSum(sum,arr,N,i+1,dp);
        }
         return dp[i][sum]= subsetSum(sum,arr,N,i+1,dp);
    }
}