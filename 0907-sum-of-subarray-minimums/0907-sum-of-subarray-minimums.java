class Solution {
    public int sumSubarrayMins(int[] arr) {
         int n = arr.length;
        long ans = 0;
        Stack<Integer> st = new Stack<>();
        int mod = 1000000007;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] > arr[i])) {
                int j = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                ans += (long) arr[j] * (i - j) * (j - k);
            }
            st.push(i);
        }

        return (int)(ans%mod);
    }
}