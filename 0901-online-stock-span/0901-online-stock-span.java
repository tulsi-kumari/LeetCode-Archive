class StockSpanner {
    public class Pair{
        int price;
        int idx;
        Pair(int price,int idx){
            this.price=price;
            this.idx=idx;
        }
    }
    Stack<Pair> st;
    int idx=-1;
    public StockSpanner() {
        st=new Stack<>();
        idx=0;
    }
    
    public int next(int price) {
        if(this.st.isEmpty()){
            this.st.push(new Pair(price,this.idx));
            this.idx++;
            return 1;
        }else{
            while(!this.st.isEmpty() && this.st.peek().price<=price){
                this.st.pop();
            }
            if(this.st.isEmpty()){
                this.st.push(new Pair(price,this.idx));
                int i=idx;
                this.idx++;
                return i+1 ;
            }else{
                int top=st.peek().idx;
                 this.st.push(new Pair(price,this.idx));
                 int i=idx;
                
                 this.idx++;
                 return i-top ;
            }
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */