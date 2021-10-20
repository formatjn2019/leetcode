package leetcode._146_LRU缓存机制;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer,Integer> {
    private final int MAX_SIZE;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        MAX_SIZE = capacity;
    }

    public int get(int key) {
        return getOrDefault(key,-1);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > MAX_SIZE;
    }
}