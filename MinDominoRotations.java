// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;
        for (int i = 0; i < tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            if (map.get(tops[i]) >= tops.length) {
                target = tops[i];
                break;
            }

            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
            if (map.get(bottoms[i]) >= bottoms.length) {
                target = bottoms[i];
                break;
            }
        }
        if (target == -1)
            return -1;
        int topsRotations = 0;
        int bottomsRotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }

            if (tops[i] != target) {
                topsRotations++;
            }

            if (bottoms[i] != target) {
                bottomsRotations++;
            }

        }

        return Math.min(topsRotations, bottomsRotations);
    }
}
// Approach 2
// Without using Hashmap

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = -1;
        res = findMinRotation(tops, bottoms, tops[0]);
        if (res != -1)
            return res;
        return findMinRotation(tops, bottoms, bottoms[0]);
    }

    private int findMinRotation(int[] tops, int[] bottoms, int target) {
        int topsRotations = 0;
        int bottomsRotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }

            if (tops[i] != target) {
                topsRotations++;
            }

            if (bottoms[i] != target) {
                bottomsRotations++;
            }

        }
        return Math.min(topsRotations, bottomsRotations);
    }
}