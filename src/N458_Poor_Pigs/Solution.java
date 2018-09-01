package N458_Poor_Pigs;



public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.print(solution.poorPigs(1000, 15, 60));
    }
}
