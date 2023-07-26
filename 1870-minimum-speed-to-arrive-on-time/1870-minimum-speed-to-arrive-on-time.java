class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int s=1;
        int e=(int)1e7;
        int ans=-1;
        while(s<=e){
            int mid=s + (e-s)/2;
            if(isPossible(hour,mid,dist)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(double hour,int speed,int[] dist){
        double h=0.0;
        int length=dist.length-1;
        int l=0;
        for(int d:dist){
            
         double temp=(d*1.0)/(speed*1.0);
          if(l==length){
              h+=temp;
          }else{
              h+=Math.ceil(temp);
          }
              l++;
        }
        return h<=hour;
    }
}