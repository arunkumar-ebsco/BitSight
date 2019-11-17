package com.sample.sqs;

import java.util.List;

// Interview Question: Given 5 tasks and interdependencies, Find the order of execution. Example: Task 3 is dependent on Task 1 and 5. Tas 2 is dependent on 5 and 3. Task 4 is dependent on 3. Task 5 is dependent on 1


public class Int {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] dependencyArray = { { 3, 1 }, { 3, 5 }, {2,5}, {2,3}, {4,3}, {5,1} };
        List<Integer> result= s.findOrder(5,dependencyArray);
        System.out.println(result);

    }
}
