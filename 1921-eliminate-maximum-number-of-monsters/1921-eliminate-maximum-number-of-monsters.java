class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] monsters = new int[n];

        for (int i = 0; i < n; i++) {
            int arrival = (int) Math.ceil((double) dist[i] / speed[i]);

            if (arrival < n) {
                monsters[arrival]++;
            }
        }

        int eliminated = 0;
        for (int i = 0; i < n; i++) {
            if (eliminated + monsters[i] > i) {
                return i;
            }

            eliminated += monsters[i];
        }

        return n;
    }
}