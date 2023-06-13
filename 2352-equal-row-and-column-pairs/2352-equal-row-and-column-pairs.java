class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,ArrayList<Integer>> mp=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            String key="";
            for(int j=0;j<grid[0].length;j++){
                key+=grid[i][j]+" ";
            }
            if(mp.containsKey(key)){
                mp.get(key).add(i+1);
            }else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(i+1);
                mp.put(key,arr);
            }
        }
        int ans=0;
        for(int j=0;j<grid[0].length;j++){
            String key="";
            for(int i=0;i<grid.length;i++){
                key+=grid[i][j]+" ";
            }
            if(mp.containsKey(key)){
                ans+=mp.get(key).size();
            }
        }
        
        return ans;
    }
}