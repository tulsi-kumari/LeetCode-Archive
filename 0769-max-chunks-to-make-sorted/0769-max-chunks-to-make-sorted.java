class Solution {
    public int maxChunksToSorted(int[] arr) {
       HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int maxChunks=0;
        int i=0;
        int n=arr.length;
        while(i<n){
            int prev=map.get(i);
            int j=i+1;
            System.out.println(i+" "+ j + " "+ prev );
            while(j<n && prev>=j){
                if(map.get(j)>prev){
                    prev=map.get(j);
                }
                j++;
                
            }
            //System.out.println(i+" "+ j + " "+ prev );
            maxChunks++;
            i=j;
        }
        return maxChunks;
    }
}