package N649_Dota2_Senate;

public class Solution {

    private int findNextOpposer(int[] partyList, int p) {
        for (int i = p+1; i < partyList.length; i++) {
            if (partyList[i] + partyList[p] == 3) {
                return i;
            }
        }

        for (int i = 0; i < p; i++) {
            if (partyList[i] + partyList[p] == 3) {
                return i;
            }
        }

        return -1;
    }

    public String predictPartyVictory(String senate) {
        int numRadiant = 0;
        int numDire = 0;


        int[] partyList = new int[senate.length()];
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                numRadiant++;
                partyList[i] = 1;
            }
            if (senate.charAt(i) == 'D') {
                numDire++;
                partyList[i] = 2;
            }
        }

        int p = 0;
        while (numDire > 0 && numRadiant > 0) {
            if (p == partyList.length)  p = 0;
            if (partyList[p] == 0) {
                p++;
                continue;
            }

            int n = findNextOpposer(partyList, p);
            if (n == -1) break;

            if (partyList[n] == 1) numRadiant--;
            if (partyList[n] == 2) numDire--;

            partyList[n] = 0;
            p++;
        }

        if (numDire == 0) return "Radiant";
        return "Dire";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.predictPartyVictory("RDD");
    }
}
