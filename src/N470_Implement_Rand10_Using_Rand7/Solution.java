package N470_Implement_Rand10_Using_Rand7;

public class Solution {
    private int rand7(){return 0;}
    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() -1) + (rand7()-1);
        }

        return result % 10 + 1;
    }
}
