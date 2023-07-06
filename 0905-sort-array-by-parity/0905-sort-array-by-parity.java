class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int j=0;
        int i=0;
        while(j<arr.length){
            if(arr[j]%2==0){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return arr;
    }
}