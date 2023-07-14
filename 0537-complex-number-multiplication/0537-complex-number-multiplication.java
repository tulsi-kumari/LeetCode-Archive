class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int real1=getReal(num1);
        int real2=getReal(num2);
        int im1=getIm(num1);
        int im2=getIm(num2);
        int real=real1*real2 - (im1*im2);
        int im=im1*real2 + im2*real1;
        return ""+real+"+"+im+"i";
    }
    public int getReal(String num){
        if(num.charAt(0)=='-'){
            return -Integer.parseInt(num.substring(1,num.indexOf("+")));
        }
        return Integer.parseInt(num.substring(0,num.indexOf("+")));
    }
    public int getIm(String num){
        int stim=num.indexOf("+")+1;
        if(num.charAt(stim)=='-'){
             return -Integer.parseInt(num.substring(stim+1,num.indexOf("i")));
        }
        return Integer.parseInt(num.substring(stim,num.indexOf("i")));
    }
}