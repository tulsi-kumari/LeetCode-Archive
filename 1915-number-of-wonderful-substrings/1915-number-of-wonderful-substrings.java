class Solution {
    public long wonderfulSubstrings(String word) {
        int N = word.length();
        // Key = bitmask, Value = frequency of bitmask key
         Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int mask = 0;
        long res = 0L;
        for(int i=0;i<N;i++)
        {
            char ch=word.charAt(i);
            int pos=ch-'a';
            // Flip the parity of the c-th bit in the running prefix mask
            mask^=(1<<pos);
            res+=freq.getOrDefault(mask,0);
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            // Loop through every possible letter that can appear an odd number of times in a substring
            for(int odd_c=0;odd_c<10;odd_c++)
            {
                res+=freq.getOrDefault(mask^(1<<odd_c),0);
            }
        }
        return res;
    }
}