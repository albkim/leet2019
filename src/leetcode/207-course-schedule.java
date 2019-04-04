/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Note:
1.The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
2.You may assume that there are no duplicate edges in the input prerequisites.

 */

package leetcode;

import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if ((prerequisites == null) || (prerequisites.length == 0) || (prerequisites[0].length == 0)) {
            return true;
        }

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
            } else {
                courses.add(course);
            }
        }

        return courses.size() == 0;
    }
}
