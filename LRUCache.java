import java.util.ArrayList;

public class LRUCache {
    private ArrayList<int[]> cache;
    private int capacity;

    public LRUCache (int capacity) {
        this.cache =  new ArrayList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] tmp = cache.remove(i);
                cache.add(tmp);
                return tmp[1];
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for(int i = 0; i < cache.size(); i++) {
            if(cache.get(i)[0] == key) {
                int[] tmp = cache.remove(i);
                tmp[1] = value;
                cache.add(tmp);
                return;
            }
        }

        if(capacity == cache.size()) {
            cache.remove(0);
        }
        cache.add(new int[]{key, value});
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
