/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you
 should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses,
return an empty array.

Example 1:
Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .

Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:
1.The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
2.You may assume that there are no duplicate edges in the input prerequisites.

 */

package leetcode;

import java.util.*;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!dependencies.containsKey(prerequisite[0])) {
                dependencies.put(prerequisite[0], new ArrayList<>());
            }
            dependencies.get(prerequisite[0]).add(prerequisite[1]);
        }

        Queue<Integer> courses = new ArrayDeque<>();
        for (int num = 0; num < numCourses; num++) {
            courses.add(num);
        }

        Integer sentinel = -1;
        courses.add(sentinel);

        int lastCount = courses.size() - 1;
        Set<Integer> taken = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        while(!courses.isEmpty()) {
            Integer course = courses.poll();
            boolean canTake = true;
            if (course.equals(sentinel)) {
                if (courses.size() == lastCount) {
                    break;
                } else {
                    lastCount = courses.size();
                    if (courses.size() > 0) {
                        courses.add(sentinel);
                    }
                    continue;
                }
            }
            if (dependencies.containsKey(course)) {
                for (int dependency : dependencies.get(course)) {
                    if (!taken.contains(dependency)) {
                        canTake = false;
                        break;
                    }
                }
                if (canTake) {
                    dependencies.remove(course);
                }
            }
            if (canTake) {
                taken.add(course);
                result.add(course);
            } else {
                courses.add(course);
            }
        }

        if (courses.size() > 0) {
            return new int[0];
        }

        int[] arrayResult = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            arrayResult[index] = result.get(index);
        }
        return arrayResult;
    }
}
