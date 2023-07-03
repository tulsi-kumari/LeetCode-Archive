class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int i=0;
        char[] arr=s.toCharArray();
        int n=arr.length;
        int prev=0;
        int start=0;
        int k=0;
        while(i<n){
            int j=n-1;
            while(arr[j]!=arr[i] && j>prev){
                j--;
            }
            //System.out.println(i +" "+ j +" "+prev);
            if(j>i){
              k=j; 
                i++;
                prev=j;
            }else if(j==i){
                ans.add(j-start+1);
                start=j+1;
                i=j+1;
            }   
            //System.out.println(i +" "+ j +" "+prev +" " + ans);
        }
        return ans;
    }
}