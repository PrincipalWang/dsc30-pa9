/*
 * Name: Chen Wang
 * PID: A17090044
 */

import java.util.*;

/**
 * Tasks implmentation
 *
 * @author Chen Wang
 * @since 3/20/2024
 */

public class Tasks {

    /**
     * Question 1
     * @param entries array to check
     * @return true if duplicate
     */
    public static boolean raffleChecker(int[] entries) {
        int max = entries[0];
        for(int i = 0; i < entries.length ; i++){
            if(entries[i] > max){
                max = entries[i];
            }
        }
        boolean[] entry = new boolean[max];
        for(int i : entries){
            if(entry[i]){
                return true;
            }
            entry[i] = true;
        }
        return false;
    }

    // List Node class provided for reference
    public static class Node {
        Node next;
        String name;
        public Node(String name) {
            this.name = name;
        }
    }

    /**
     * Question 2
     * @param head head Node
     * @return middle node value
     */
    public static String middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.name;
    }

    /**
     * Question 3
     * @param newMessage string want to construct
     * @param oldMessage string use to construct
     * @return can construct or not
     */
    public static boolean canConstruct(String newMessage, String oldMessage) {
        int[] oldLetters = new int[26];
        for(char i : oldMessage.toCharArray()){
            oldLetters[i - 'A']++;
        }
        for(char i : newMessage.toCharArray()){
            oldLetters[i - 'A']--;
            if(oldLetters[i - 'A'] < 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Question 4
     * @param buyers name of customers
     * @param k first kth
     * @return first kth buyers
     */
    public static String[] frequentCustomers(String[] buyers, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String i : buyers){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        String[] res = new String[k];
        for(int i = 0 ; i < k ; i++){
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
