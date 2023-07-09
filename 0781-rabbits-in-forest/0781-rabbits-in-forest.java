class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:answers){
            map.put(num+1,map.getOrDefault(num+1,0)+1);
        }
        System.out.println(map);
        int ans=0;
        for(int key:map.keySet()){
            if(map.get(key)%key==0){
               ans+=(map.get(key)/key)*key;
            }else{
                ans+=((map.get(key)/key)+1)*key;
            }
            
        }
        return ans;
    }
}