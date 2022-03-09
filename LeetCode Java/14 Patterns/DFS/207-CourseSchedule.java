/*
 * 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * Example 1:
    * Input: numCourses = 2, prerequisites = [[1,0]]
    * Output: true
    * Explanation: There are a total of 2 courses to take.
    * To take course 1 you should have finished course 0. So it is possible.
 */
class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<Integer>());
        }
        for (var pre : prerequisites) {
            if (preMap.containsKey(pre[1])) {
                var tempList = preMap.get(pre[1]);
                tempList.add(pre[0]);
                preMap.put(pre[1], tempList);
            } else {
                preMap.put(pre[1], new ArrayList<Integer>());
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int course) {
        if (visited.contains(course)) { return false; }
        var preReqs = preMap.get(course);
        if (preReqs.size() == 0) { return true;  }
        visited.add(course);
        for (var pre : preReqs) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited.remove(course);
        preMap.put(course, new ArrayList<Integer>());
        return true;
    }
}
