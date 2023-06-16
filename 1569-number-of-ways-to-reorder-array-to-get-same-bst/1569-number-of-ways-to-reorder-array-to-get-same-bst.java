class Solution {
    private static final long MOD = 1_000_000_007L;
    private static final FastCombinatorics comb = new FastCombinatorics(1001,MOD);
    public int numOfWays(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for(int i=1;i<nums.length;i++) root = add(root,nums[i]);
        return (int)(solve(root)[0]-1);
    }
    private TreeNode add(TreeNode root, int value){
        if(root == null) return new TreeNode(value);
        if(root.value > value) root.left = add(root.left,value);
        else root.right = add(root.right,value);
        return root;
    }
    private long[] solve(TreeNode root){    //ways, size
        if(root == null) return new long[]{1,0};
        long[] left = solve(root.left);
        long[] right = solve(root.right);
        long ways = left[0]*right[0]%MOD*comb.C((int)(left[1]+right[1]),(int)left[1])%MOD;
        return new long[]{ways,left[1]+right[1]+1};
    }
}
class TreeNode{
    int value;
    TreeNode left,right;
    
    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
class FastCombinatorics {
    private long MOD;
    long[] fac;
    long[] inv;
    public FastCombinatorics(int n,long MOD){
        this.fac = new long[n+1];
        this.inv = new long[n+1];
        fac[0] = 1L;
        this.MOD = MOD;
        for(int i=1;i<=n;i++) {
            fac[i] = fac[i-1]*i%MOD;

        }
        inv[n] = powMod(fac[n],MOD-2);
        for(int i=n-1;i>=0;i--){
            inv[i] = inv[i+1]*(i+1)%MOD;
        }
    }

    private long powMod(long x, long n){
        if(n == 0) return 1L;
        long t = powMod(x,n/2);
        if(n%2 == 0) return t*t%MOD;
        return t*t%MOD*x%MOD;
    }

    public long C(int n,int r){
        if(r == 0 || n==0) return 1L;
        return (fac[n]*inv[r]%MOD*inv[n-r])%MOD;
    }
}