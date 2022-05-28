package medium;

import java.util.*;
import java.util.stream.IntStream;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> s = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return s;

        int len = digits.length();
        /*int arr[] = new int[len];
        for(int i = 0 ;i < len ; i++){
            System.out.println(digits.charAt(i));
            //charAt(i) will return a character and string. charAt(i)- '0' will return the actual integer value.
            // For e.g. string="12345",this method will return an integer array [1,2,3,4,5].
            Follow this answer to receive notifications
            arr[i]  = digits.charAt(i)-'0'; //https://stackoverflow.com/questions/12438336/why-we-use-0-beside-charati
        }*/

        int[] chars = Arrays.stream(digits.chars().toArray()).flatMap(value -> IntStream.of(value - '0')).toArray();
        System.out.println(Arrays.toString(chars));
                             //  2       3       4     5      6      7       8       9
        String letters[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> que = new LinkedList<>();
        que.offer(""); //better then queue.add() as it does not throw run time exception

        for(int i = 0 ; i < len; i++){
            String word = letters[chars[i] - 2 ];
            int size = que.size();
            for (int j = 0; j < size; j++) {
                String temp = que.poll();
                for (char ch : word.toCharArray()) {
                    que.offer(temp + ch);
                }
            }
        }
        return new ArrayList<>(que);
    }
}
