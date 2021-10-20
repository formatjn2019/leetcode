package leetcode._146_LRU缓存机制;

import java.util.*;

class LRUCache_timeout {
    private Map<Integer, Integer> cache = null;
    private ArrayDeque<Integer> stack = null;
    private final int MAX_SIZE;

    public LRUCache_timeout(int capacity) {
        cache = new HashMap<>(capacity);
        stack = new ArrayDeque<>(capacity);
        MAX_SIZE = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        refresh(key);
        return cache.get(key);
    }

    public void refresh(int key) {
        stack.remove(key);
        stack.push(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            refresh(key);
        }
        //不包含，判定容量，删除最少使用的元素
        else {
            if (stack.size() < MAX_SIZE) {
                refresh(key);
            } else {
                cache.remove(stack.removeLast());
                refresh(key);
            }
        }
        cache.put(key, value);
    }
}