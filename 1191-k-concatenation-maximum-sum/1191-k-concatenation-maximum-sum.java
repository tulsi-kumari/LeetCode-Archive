class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
    List<Integer> l=new ArrayList<>();
    long mod=(long)(1e9)+7;
   long sum=0;
    for(int x:arr){
        sum+=(long)x;
        l.add(x);
    }
    //condition for k==1
     if(k==1){
        long z=kadanes(l);
        return (int)(z%mod);
    }
    //if sum is neg applying two times kadanes
    else if(sum<0){
        for(int x:arr)l.add(x);
        long z=kadanes(l);
        return (int)(z%mod);
    }
    //if sum is pos applying two times kadanes and adding the k-2 times whole sum
    else{
        for(int x:arr)l.add(x);
        long z=kadanes(l);
        long p1=z+(k-2)*sum;
        return (int)(p1%mod);
    }
        
}
//kadanes algo
public long kadanes(List<Integer> l){
    long prev=0;long max=0;
    for(int i=0;i<l.size();i++){
        prev=Math.max(prev+(long)l.get(i),(long)l.get(i));
        max=Math.max(max,prev);
    }
    return max;
}
}