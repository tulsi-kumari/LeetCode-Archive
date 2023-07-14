class Solution {
    public String multiply(String num1, String num2) {
        int n=num1.length();
        int m=num2.length();
        
        char[] ans=new char[n+m];
        Arrays.fill(ans,'0');
        char[] arr1;
        char[] arr2;
        if(n<m){
            arr1=num2.toCharArray();
            n=arr1.length;
            arr2=num1.toCharArray();
            m=arr2.length;
        }else{
            arr1=num1.toCharArray();
            n=arr1.length;
            arr2=num2.toCharArray();
            m=arr2.length;
        }
        int j=m-1;
        int space=0;
        int l=ans.length-1;
        int carry=0;
        int k=l;
        while(j>=0){
            k=l-space;
            space++;
            
            int i=n-1;
            int s=arr2[j]-'0';
            while(i>=0){
                int f=arr1[i]-'0';
                
                int prod=f*s +carry;
                
                int in=prod%10;
                carry=prod/10;
                int curr=ans[k]-'0';
                
                curr+=in;
                int tempCarry=curr/10;
                curr=curr%10;
                ans[k]=(char)(curr+'0');
                if(tempCarry>0){
                    int t=k-1;
                    while(tempCarry>0 && t>=0){
                        curr=(ans[t]-'0')+tempCarry;
                        ans[t]=(char)((curr%10)+'0');
                        tempCarry=curr/10;
                        t--;
                    }
                }
                k--;
                i--;
            }
            while(carry>0 && k>=0){
                        int curr=(ans[k]-'0')+carry;
                        ans[k]=(char)((curr%10)+'0');
                        carry=curr/10;
                        k--;
        }
            j--;
        }
         
        String ret="";
        int it=0;
        while(it<ans.length && ans[it]=='0'){
            it++;
        }
        if(it==ans.length){
            return "0";
        }
        
        while(it<ans.length){
            ret+=ans[it];
            it++;
        }
        return ret;
        
        
    }
}