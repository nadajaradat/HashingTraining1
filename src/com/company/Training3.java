package com.company;


import static java.lang.Integer.min;
import java.util.*;

public class Training3 {

    public static void main(String args[]) {
//        //Q1
//        List s = commonChars(new String[]{"cool", "lock", "cook"});
//        System.out.println(s);
//        //Q2
//        String[] res = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
//        for (String re : res) {
//            System.out.print(re + " ");
//        }
//        //Q3
//        System.out.println("\n" + numJewelsInStones("aA", "aAAbbbb"));
//
//        //Q4
//        int[] arr = smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
        //Q5
        ArrayList<ArrayList<Integer>> a = (ArrayList) groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        for (ArrayList<Integer> aa : a) {
            for (Integer num : aa) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }

    //Q1 : https://www.tutorialcup.com/leetcode-solutions/find-common-characters-leetcode-solution-2.htm
    public static List<String> commonChars(String[] words) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < words[0].length(); i++) {
            Character ch = words[0].charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            System.out.println(hm);
            HashMap<Character, Integer> h = new HashMap<>();
            String s = words[i];
            for (int j = 0; j < s.length(); j++) {
                Character ch = s.charAt(j);
                if (hm.getOrDefault(ch, 0) != 0) {
                    h.put(ch, h.getOrDefault(ch, 0) + 1);
                }
            }
            for (HashMap.Entry<Character, Integer> e : h.entrySet()) {
                e.setValue(min(e.getValue(), hm.get(e.getKey())));
            }
            hm = h;
        }
        ArrayList<String> arr = new ArrayList<>();
        for (HashMap.Entry<Character, Integer> e : hm.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                arr.add(e.getKey() + "");
            }
        }
        return arr;
    }

    //Q2 : https://www.tutorialcup.com/leetcode-solutions/keyboard-row-leetcode-solution.htm
    public static String[] findWords(String[] words) {
        HashSet<Character> hs1 = new HashSet<>(List.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        HashSet<Character> hs2 = new HashSet<>(List.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        HashSet<Character> hs3 = new HashSet<>(List.of('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        String[] res = new String[words.length];
        int k = 0;
        for (String word : words) {
            boolean f1 = true, f2 = true, f3 = true;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                ch = Character.toLowerCase(ch);
                if (hs1.contains(ch) && f1) {
                    f2 = f3 = false;
                } else if (hs2.contains(ch) && f2) {
                    f1 = f3 = false;
                } else if (hs3.contains(ch) && f3) {
                    f1 = f2 = false;
                } else {
                    f1 = f2 = f3 = false;
                }
            }
            if (f1 || f2 || f3) {
                res[k++] = word;
            }
        }
        res = Arrays.copyOf(res, k);
        return res;
    }

    //Q3 : https://leetcode.com/problems/jewels-and-stones/
    public static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> j = new HashSet<>();

        for (int i = 0; i < jewels.length(); i++) {
            j.add(jewels.charAt(i));
        }

        int cnt = 0;
        for (int i = 0; i < stones.length(); i++) {
            Character ch = stones.charAt(i);
            if (j.contains(ch)) {
                cnt++;
            }
        }
        return cnt;
    }

    //Q4 : https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(i);
        }
        ArrayList<Integer> copy = new ArrayList<>(arr);

        Collections.sort(arr);

        int[] res = new int[arr.size()];
        int k = 0;
        for (Integer val : copy) {
            res[k++] = (arr.indexOf(val));
        }

        return Arrays.copyOf(res, k);
    }

    //Q5 : https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        //خطأ الحل **********************
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            ArrayList<Integer> arr = hm.getOrDefault(groupSizes[i], new ArrayList<>());
            arr.add(i);
            hm.put(groupSizes[i], arr);
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int key : groupSizes) {
            if (hm.containsKey(key)) {
                res.add(hm.get(key));
                hm.remove(key);
            }

        }
        return (ArrayList) res;
    }
}
