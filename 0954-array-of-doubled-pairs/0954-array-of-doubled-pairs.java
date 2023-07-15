class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer,Integer> fmap=new HashMap<>();
        for(int num:arr){
            fmap.put(num,fmap.getOrDefault(num,0)+1);
        }
        int k=0;
        while(k<arr.length && arr[k]<0){
            k++;
        }
        
        int j=k;
        k--;
        while(k>=0&&k<j){
           if(fmap.containsKey(arr[k])){
               if(fmap.get(arr[k])==1){
                   fmap.remove(arr[k]);
               }else{
                   fmap.put(arr[k],fmap.get(arr[k])-1);
               }
               if(fmap.containsKey(2*arr[k])){
                   if(fmap.get(2*arr[k])==1){
                      fmap.remove(2*arr[k]);
                  }else{
                      fmap.put(2*arr[k],fmap.get(2*arr[k])-1);
                  }
               }else{
                   return false;
               }
               
           }
            k--;
        }
       for(int i=j;i<arr.length;i++){
           //System.out.println(fmap+" "+arr[i]+" "+2*arr[i]);
           if(fmap.containsKey(arr[i])){
               if(fmap.get(arr[i])==1){
                   fmap.remove(arr[i]);
               }else{
                   fmap.put(arr[i],fmap.get(arr[i])-1);
               }
               if(fmap.containsKey(2*arr[i])){
                   if(fmap.get(2*arr[i])==1){
                      fmap.remove(2*arr[i]);
                  }else{
                      fmap.put(2*arr[i],fmap.get(2*arr[i])-1);
                  }
               }else{
                   return false;
               }
               
           }
       }
        return true;
    }
}