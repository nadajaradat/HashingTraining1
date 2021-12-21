package com.company;

import static java.lang.Integer.max;
import java.util.*;

public class Training2 {

    public static void main(String[] args) {
//        int[] arr = twoSum(new int[]{3, 2, 4}, 6);
//        System.out.println(arr[0] + " " + arr[1]);

//        int[] arr = occur(new int[]{2, 3, 4, 3, 1, 3, 2, 4});
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
        System.out.println(maxDistance(new int[]{8, 1, 3, 2, 4, 1, 3, 6, 7, 3, 1}));
    }

    //https://leetcode.com/problems/two-sum/
    static public int[] twoSum(int[] nums, int target) {
        int i = -1, j = -1;
        for (int k = 0; k < nums.length - 1; k++) {
            for (int m = k + 1; m < nums.length; m++) {
                if (nums[m] == target - nums[k] && m != k) {
                    i = k;
                    j = m;
                    break;
                }
            }
        }
        return new int[]{i, j};

    }

    //https://www.tutorialcup.com/interview/hashing/minimum-delete-operations-to-make-all-elements-of-array-same.htm
    static int delete(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (Integer value : hm.values()) {
            if ((int) value > max) {
                max = value;
            }
        }
        return (arr.length - max);
    }

    //https://www.tutorialcup.com/interview/hashing/group-multiple-occurrence-of-array-elements-ordered-by-first-occurrence.htm
    static int[] occur(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[arr.length];
        int k = 0;
        for (int num : arr) {
            if (hm.containsKey(num)) {
                for (int i = 0; i < hm.get(num); i++) {
                    res[k++] = num;
                }
                hm.remove(num);
            }
        }
        return res;
    }

    //https://www.tutorialcup.com/interview/hashing/maximum-distance-between-two-occurrences-of-same-element-in-array.htm
    static int maxDistance(int[] arr) {
        //بتنحل بدون ارريه ليست بس هاد اللي خطرلي باستخدام الهاش ماب
        ArrayList<Integer> a = new ArrayList<>();
        for (int num : arr) {
            a.add(num);
        }
        int res = 0;
        for (int num : arr) {
            res = max(res, a.lastIndexOf(num) - a.indexOf(num));

        }
        return res;

    }
}
