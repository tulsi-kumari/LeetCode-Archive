class Solution {
    public boolean canCross(int[] stones) {
        HashSet<Integer> set=new HashSet<>();
        HashMap<String , Boolean> map=new HashMap<>();
        if(stones[1]!=1){
            return false;
        }
        for(int i:stones){
            set.add(i);
        }
        int goal=stones[stones.length-1];
        return func(1,1,set,goal,map);
    }
    public boolean func(int idx,int step,HashSet<Integer> set,int goal,HashMap<String , Boolean> map){
        if(idx==goal){
            return true;
        }
        if(idx>goal){
            return false;
        }
        String key=""+idx+"#"+step;
        if(map.containsKey(key)){
            return map.get(key);
        }
        // System.out.println(idx);
        // System.out.println(step-1 +' '+step+" "+step+1);
        if(step==1){
            boolean f=false,s=false;
            if(set.contains(idx+step)){
                f=func(idx+step,step,set,goal,map);
            }
            if(set.contains(idx+step+1)){
                s=func(idx+step+1,step+1,set,goal,map);
            }
            if(f||s){
                map.put(key,true);
                return true;
            }
        }else{
            boolean f=false,s=false,t=false;
            if(set.contains(idx+step-1)){
                 f=func(idx+step-1,step-1,set,goal,map);
            }
            if(set.contains(idx+step)){
                 s=func(idx+step,step,set,goal,map);
            }
            if(set.contains(idx+step+1)){
                 t=func(idx+step+1,step+1,set,goal,map);
            }
            if(f||s||t){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }
}