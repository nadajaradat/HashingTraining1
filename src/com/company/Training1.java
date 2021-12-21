package com.company;

import java.util.*;

/**
 *
 * @author H-ATATRAH
 */
public class Training1 {

    public static void main(String[] args) {
        //q1:        program to count the number of good pairs in array where good pairs are arr[i]=arr[j], j>i

        /*        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(goodPairs(mp));
         */
        //q2 : كم رقم بالارريه اصغر من كل عنصر
        /*
        ArrayList<Integer> arr = new ArrayList<>(List.of(8, 1, 2, 2, 3));
        ArrayList<Integer> copy = new ArrayList<>(arr);

        Collections.sort(arr);

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer val : copy) {
            res.add(arr.indexOf(val));
        }
        System.out.println(res);
         */
//q3 : كم عدد السترنغز الي بالووردز الي ما فيها غير حروف ال الو
        ArrayList<String> arr = new ArrayList<>(List.of("a", "b", "c", "ab", "ac", "bc", "abc"));
        String a = "abc";
        System.out.println(numOfConsistent(arr, a));

//q4 : اذا الجملة الي عندي ياها فيها كل الحروف الصغيرة
        /*
String sentence = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(pangram(sentence));
         */
//q5 : اذا كانن الكاكترز بتكررن بنفس العدد
/*
        String s = "ababcc";
        System.out.println(good(s));
         */
 /*     ArrayList<Integer> arr = new ArrayList<>(List.of(1, 1, 1, 1));
        System.out.println(sum(arr));*/
    }

    private static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (Integer val : arr) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }
        for (Integer val : arr) {
            if (mp.get(val) == 1) {
                sum += val;
            }
        }
        return sum;
    }

    //q5
    private static boolean good(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        return (new HashSet<>(hm.values()).size() == 1);
//        Integer savedValue = hm.get(s.charAt(0));
//        for (Integer val : hm.values()) {
//            if (!val.equals(savedValue)) {
//                return false;
//            }
//        }
//        return true;
    }
//q4

    private static boolean pangram(String sentence) {
        String allLetters = "qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < allLetters.length(); i++) {
            if (sentence.indexOf(allLetters.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
//q3

    private static int numOfConsistent(ArrayList<String> words, String allowed) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            hs.add(allowed.charAt(i));
        }
        int res = 0;
        for (String val : words) {
            boolean flag = true;
            for (int i = 0; i < val.length(); i++) {
                if (!hs.contains(val.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
//q1

    private static int goodPairs(HashMap<Integer, Integer> mp) {
        int res = 0;
        for (Integer freq : mp.values()) {
            int n = freq - 1;
            res += n * (n + 1) / 2;
        }
        return res;
    }

}
