class Solution {
    private int max = 0;
    private Map<String, Integer> memo;
    public int tallestBillboard(int[] rods) {
        memo = new HashMap<>();
        helper(rods, rods.length - 1, 0, 0, Arrays.stream(rods).sum());
        return max;
    }
    private int helper(int[] A, int ind, int left, int right, int rem) {
        String key = ind + "," + left + "," + right + "," + rem;
        if (memo.containsKey(key))  return memo.get(key);
        if (ind < 0) {
            if (left == right && left > max)  max = left;
            memo.put(key, left);
            return left;
        }
        int res = 0;
        if (left + right + rem <= 2 * max || Math.abs(left - right) > rem) {
            memo.put(key, res);//pruning
            return res;
        }
        res = Math.max(res, helper(A, ind - 1, left + A[ind], right, rem - A[ind]));//left bucket
        res = Math.max(res, helper(A, ind - 1, left, right + A[ind], rem - A[ind]));//right bucket
        res = Math.max(res, helper(A, ind - 1, left, right, rem - A[ind]));//Non-selected
        memo.put(key, res);
        return res;
    }
}