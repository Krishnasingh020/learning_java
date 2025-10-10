class Leetcode3494 {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] time = new long[n];

        for (int x : mana) {
            time[0] = time[0] + 1L * skill[0] * x;
            for (int i = 1; i < n; i++) {
                time[i] = Math.max(time[i], time[i - 1]) + 1L * skill[i] * x;
            }
            for (int i = n - 2; i >= 0; i--) {
                time[i] = time[i + 1] - 1L * skill[i + 1] * x;
            }
        }
        return time[n - 1];
    }
    public static void main(String[] args) {
        Leetcode3494 sol = new Leetcode3494();
        int[] skill = {1,5,2,4};
        int[] mana = {5,1,4,2};
        System.out.println(sol.minTime(skill, mana)); // Output: 43
    }
}
