class Solution {
    public int distributeCookies(int[] cookies, int k) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<k;i++){
            arr.add(new ArrayList<>());
        }
        return func(arr,cookies,0,Integer.MAX_VALUE);
    }
    public int func(ArrayList<ArrayList<Integer>> arr,int[] cookies,int idx,int max){
        if(idx==cookies.length){
            int m=0;
            for(int i=0;i<arr.size();i++){
               
                int sum=0;
                for(int j=0;j<arr.get(i).size();j++){
                    sum+=arr.get(i).get(j);
                }
                
                 m=Math.max(m,sum);
            }
            //System.out.println(m);
            return Math.min(max,m);
            
        }
        int m=Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).size()>0){
                arr.get(i).add(cookies[idx]);
                m=Math.min(m,func(arr,cookies,idx+1,max));
                arr.get(i).remove(arr.get(i).size()-1);
            }else{
                arr.get(i).add(cookies[idx]);
                m=Math.min(m,func(arr,cookies,idx+1,max));
                arr.get(i).remove(arr.get(i).size()-1);
                break;
            }
        }
        
        return m;
    }
}