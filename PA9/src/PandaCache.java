/*
 * Name: Chen Wang
 * PID: A17090044
 */

import java.util.*;

/**
 * PandaCache implementation
 *
 * @author Chen Wang
 * @since 3/20/2024
 */

public class PandaCache {
    /**
     * Node class
     */
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        /**
         * Constructor
         * @param key key of Node
         * @param value value of Node
         */
        public Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Add a Node
     * @param node Node to be added
     */
    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * Remove a Node
     * @param node Node to be removed
     */
    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * Move a Node to head
     * @param node Node to be moved
     */
    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    /**
     * Remove Node on tail
     * @return Node removed
     */
    private Node removeTail(){
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    private HashMap<Integer,Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    /**
     * Constructor
     * @param capacity capacity
     */
    public PandaCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get value on pandaID
     *
     * @param pandaID ID of panda
     * @return value of pandaID
     */
    public int get(int pandaID) {
        Node panda = cache.get(pandaID);
        if(panda == null){
            return -1;
        }
        moveToHead(panda);
        return panda.value;
    }

    /**
     * Set pandaID to zoneNumber
     *
     * @param pandaID ID of panda
     * @param zoneNumber zoneNumber of panda
     */
    public void set(int pandaID, int zoneNumber) {
        Node node = cache.get(pandaID);
        if(node == null){
            Node newNode = new Node(pandaID, zoneNumber);
            cache.put(pandaID, newNode);
            addNode(newNode);
            size++;
            if(size > capacity){
                Node least = removeTail();
                cache.remove(least.key);
                size--;
            }
        }
        else{
            node.value = zoneNumber;
            moveToHead(node);
        }
    }
}