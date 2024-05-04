class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int cnt=0;
        while(i<=j)
        {
            int last=people[j];
            int start=people[i];
            if(last+start<=limit)
            {
                i++;
                j--;
                cnt++;
            }else
            {
                j--;
                cnt++;
            }
        }
        return cnt;
    }
}