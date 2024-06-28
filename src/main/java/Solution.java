import java.util.*;

public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }

        int[][] ma = new int[n][2];
        for (int i = 0; i < n; i++) {
            ma[i][0] = i;
            ma[i][1] = graph.get(i).size();
        }
        Arrays.sort(ma, Comparator.comparingInt((int[] m) -> m[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(ma[i][0], i + 1);
        }
        long res = 0L;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                res += map.get(i) + map.get(graph.get(i).get(j));
            }
        }

        return res / 2;
    }
}
