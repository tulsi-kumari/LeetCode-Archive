class Solution {
    public int minFlips(int a, int b, int c) {
        int flips=0;
        
        while(a!=0||b!=0||c!=0){
            int bit_a=a&1;
            int bit_b=b&1;
            int bit_c=c&1;
            
            if(bit_c==0){
                
                if(bit_a==1&&bit_b==1){
                    flips+=2;
                }else if(bit_a==1||bit_b==1){
                    flips++;
                }
                
            }else if(bit_c==1){
                if(bit_a==0 && bit_b==0){
                    flips++;
                }
            }
            
            
            a=a>>1;
            b=b>>1;
            c=c>>1;
            System.out.println(a + " " + b + " " +c);
        }
        
        return flips;
    }
    
}