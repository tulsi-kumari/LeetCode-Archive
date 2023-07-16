class Solution {
    public class Pair implements Comparable<Pair>{
       int position;
        int speed;
        Pair(int pos,int sp){
          this.position=pos;
            this.speed=sp;
        }
        @Override
        public int compareTo(Pair p){
            return p.position-this.position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] arr=new Pair[position.length];
        for(int i=0;i<position.length;i++){
           arr[i]=new Pair(position[i],speed[i]);
        }
        Arrays.sort(arr);
       double[] reach=new double[position.length];
        for(int i=0;i<position.length;i++){
           reach[i]=(double)((double)(target-arr[i].position)/(double)arr[i].speed);
        }
        //System.out.println(Arrays.toString(reach));
        int count=0;
        int j=0;
        while(j<position.length){
            double curr=reach[j];
            j++;
            while(j<position.length && reach[j]<=curr){
              j++;
            }
            count++;
        }
        return count;
    }
}