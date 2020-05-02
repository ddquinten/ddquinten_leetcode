Qu// Leetcode 30-day day 24
// Description from leetcode
/* Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example
LRUCache cache = new LRUCache( 2 "capacity"  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4*/

// just solution class
class LRUCache {

    public LRUCache(int capacity) { // initialization
        CacheCap = capacity;
        hashtable = new HashMap<>();
        LRU = new LinkedList<>();
    }
    
    public int get(int key) { 
        if (!hashtable.containsKey(key)) // if key isn't in hash return -1
            return -1;
        else
        {
            if (LRU.peek() == key) // this updates the LRU queue
            // if key is the LRU, remove it and and it to end of queue
            {
                LRU.remove();
                LRU.add(key);
            }
            return hashtable.get(key); 
        }
    }
    
    public void put(int key, int value) {
        if (hashtable.containsKey(key)) // if key is already in hash, update value
            hashtable.replace(key, value);
        else if (hashtable.size() == CacheCap) // else evict LRU in queue
            hashtable.remove(LRU.remove());
        
        hashtable.put(key, value);
        LRU.add(key); // add to end of queue, makes it MRU
    }
    
    private int CacheCap; // stores max allowed in cache
    
    private HashMap<Integer, Integer> hashtable; // cache
    
    private Queue<Integer> LRU; // least recently used queue
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Sample inputs
/*
["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

*/


/* Fastest Leetcode submission -> not mine
class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node least;
        Node recent;
        public Node(int k, int v){
            key = k;
            value = v;
        }
    }
    int curCapacity, capacity;
    Node recent, least;
    Node[] cache;
    public LRUCache(int capacity) {
        curCapacity = 0;
        recent = null;
        least = null;
        cache = new Node[capacity];
        this.capacity = capacity; 
    }
    
    public int get(int key) {//System.out.println("check GET at " + key);
        int idx = key % capacity;
        Node findNode = cache[idx];
        while(findNode != null){
            if(findNode.key == key){
                moveToRecent(findNode);
                //printNode();
                return findNode.value;
            }
            findNode = findNode.next;
        }
        //printNode();
        return -1;
    }
    
    public void put(int key, int value) {//System.out.println("check PUT at " + key);
        int idx = key % capacity;
        Node findNode = cache[idx];
        Node prevNode = findNode;
        
        while(findNode != null){
            prevNode = findNode;
            if(findNode.key == key){
                findNode.value  = value;
                break;
            }
            findNode = findNode.next;
        }
        
        if(findNode == null){
            ++curCapacity;
            findNode = new Node(key, value);
            if(cache[idx] == null){
                cache[idx] = findNode;
            }else{
                prevNode.next = findNode;
                findNode.prev = prevNode;
            }
        }
        //System.out.println("Node found");
        moveToRecent(findNode);
        if(curCapacity > capacity){
            evicLeast(least);
        }
        //printNode();
    }
    
    private void moveToRecent(Node node){
        if(node == recent) return;
        if(recent == null){
            least = node;
            recent = node;
            return;
        }
        if(node == least){
            least = least.recent;
        }
        if(node.least != null){
            node.least.recent = node.recent;
        }
        if(node.recent != null){
            node.recent.least = node.least;
        }

        recent.recent = node;
        node.least = recent;
        
        recent = node;
    }
    private void evicLeast(Node node){
        //System.out.println("evic node " + node.value);
        // remove node;
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            int idx = node.key % capacity;
            cache[idx] = node.next;
        }
        
        if(node.next != null){
            node.next.prev = node.prev;
        }
        
        least = least.recent;
        --curCapacity;
    }
    private void printNode(){
        Node start = recent;
        while(start != null){
            System.out.print(start.value);
            start = start.least;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */