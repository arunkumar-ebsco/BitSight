package com.sample.sqs;

import java.util.*;

class Solution {


    public List<Integer> findOrder(int tasks, int[][] dependencyArray) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] dependencies = new int[tasks];

        for (int[] pair : dependencyArray) {
            int pre = pair[1];
            int cur = pair[0];
            List<Integer> nextCourses = graph.getOrDefault(pre, new ArrayList<>());
            nextCourses.add(cur);
            graph.put(pre, nextCourses);
            dependencies[cur-1]++;
        }


        List<Integer> integerArrayList = new ArrayList<>();

        Queue<Integer> todo = new LinkedList<>();
        // pick all tasks which doesn't have dependencies
        for (int i = 0; i < tasks; i++) {
            if (dependencies[i] == 0)
                todo.offer(i+1);
        }

        //Do DFS, let say that task 1 have no dependencies, consider all possible paths from task 1. In this example the tasks 3,5 are dependent on 1, so consider 3 and 5 next and do the recursion.
        while (!todo.isEmpty()) {
            int cur = todo.remove();
            integerArrayList.add(cur);
            for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                int a = getArrayIndexOfNext(next);
                dependencies[a]--;
                if (dependencies[a] == 0)
                    todo.offer(next);
            }
        }

       return integerArrayList;

    }

    // Lets say the task[] = {1,2,3,4,5} The reason for doing this is to get array index of the task since array index starts from 0.
    private int getArrayIndexOfNext(int next) {
        return next -1;

    }
}