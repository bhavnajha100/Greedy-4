//TC : Avrg : mlogk , worst = mlogn
//SC : O(length of source string)
class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        int m = target.length();
        int n = source.length();
        // Store all the characters of source string along with the list of indices of their occurances
        for (int i = 0; i < n; i++) {
            char schar = source.charAt(i);
            if (!map.containsKey(schar)) {
                map.put(schar, new ArrayList<>());
            }
            map.get(schar).add(i);
        }

        int i = 0; // pointer on source
        int j = 0; // pointer on target
        int count = 1;
        while (j < m) {
            char tchar = target.charAt(j);
            if (!map.containsKey(tchar)) // if source does not have character which is present in target
                return -1;
            List<Integer> list = map.get(tchar);
            int k = binarySearchOnIndexList(list, i); // binary search on the list of indices of char in source
            if (k == list.size()) { // if index is out of bounds in source string, increase count and reset the i to first occurance of the character
                count++;
                i = list.get(0);
            } else {
                i = list.get(k);
            }
            i++;
            j++;
        }
        return count;
    }

    private int binarySearchOnIndexList(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}