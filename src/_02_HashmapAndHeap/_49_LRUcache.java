package _02_HashmapAndHeap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _49_LRUcache {
    public static class LRU {
        class Node{
            int key,value;
            Node prev,next;
        }
        HashMap<Integer, Node> cache;
        int cap;
        Node head, tail;
        // Constructor
        LRU(int capacity) {
            cache = new HashMap<>();
            cap = capacity;

            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;
        }
        // add node at front
        private void addNode(Node node) {//add first
            Node nbr = head.next;

            node.next = nbr;
            node.prev = head;

            nbr.prev = node;
            head.next = node;
        }
        // remove node
        private void removeNode(Node node) {
            Node prevNbr = node.prev;
            Node nextNbr = node.next;

            prevNbr.next = nextNbr;
            nextNbr.prev = prevNbr;

            node.next = null;
            node.prev = null;
        }
        private void moveToFront(Node node){
            removeNode(node);
            addNode(node);
        }

        // GET (as it is)
        public int get(int key) {
            Node node = cache.get(key);

            if (node == null) {
                return -1;
            }else {
                int vl=node.value;
                moveToFront(node);
                return vl;
            }
        }
        // PUT (as it is)
        public void put(int key, int value) {

            Node node = cache.get(key);

            if (node == null) {   // key not exist
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;

                if (cache.size() == cap) {
                    Node lruNode = tail.prev;
                    cache.remove(lruNode.key);
                    removeNode(lruNode);
                }
                cache.put(key, newNode);
                addNode(newNode);

            } else {              // key exist
                node.value = value;
               moveToFront(node);//make recently used
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

        while (true) {
            str = br.readLine();
            String inp[] = str.split(" ");
            if (inp.length == 1) {
                break;
            } else if (inp.length == 2) {
                System.out.println(obj.get(Integer.parseInt(inp[1])));
            } else if (inp.length == 3) {
                obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
            }
        }
    }

}
