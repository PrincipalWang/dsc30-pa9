/*
 * Name: Chen Wang
 * PID: A17090044
 */

import java.util.*;

/**
 * DonationStack implementation
 *
 * @author Chen Wang
 * @since 3/20/2024
 */

public class DonationStack {

    private Stack<Integer> sta;
    private Stack<Integer> maxsta;

    /**
     * Constructor
     */
    public DonationStack() {
        sta = new Stack<>();
        maxsta = new Stack<>();
    }

    /**
     * Push new value into stack
     * @param val value to be pushed
     */
    public void push(int val) {
        sta.push(val);
        if(maxsta.isEmpty() || val > maxsta.peek()){
            maxsta.push(val);
        }
    }

    /**
     * Return the top element
     * @return the top element
     */
    public int peek() {
        return sta.peek();
    }

    /**
     * Pop top value out
     * @return value poped
     */
    public int pop() {
        int res = sta.pop();
        if(res == maxsta.peek()){
            maxsta.pop();
        }
        return res;
    }

    /**
     * Return the max value in stack
     * @return the max value in stack
     */
    public int max() {
        return maxsta.peek();
    }
}
