import java.util.LinkedList;

// Class to represent an entry in the hash table
class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// Class to represent a hash table
class HashTable<K, V> {
    // Array of linked lists to handle collisions
    private LinkedList<HashNode<K, V>>[] table;
    private int size;

    public HashTable(int capacity) {
        // Initialize the table with the given capacity
        table = new LinkedList[capacity];
        size = 0;
        // Initialize each index of the table with an empty LinkedList
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to map a key to an index in the table
    private int getHash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % table.length);
    }

    // Insert a (key, value) pair into the hash table
    public void insert(K key, V value) {
        int index = getHash(key);
        // Check if the key already exists and update its value
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        // If the key doesn't exist, add a new node to the linked list
        table[index].add(new HashNode<>(key, value));
        size++;
    }

    // Retrieve the value associated with a key
    public V get(K key) {
        int index = getHash(key);
        // Search for the key in the linked list at the corresponding index
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        // If the key is not found, return null
        return null;
    }

    // Remove a (key, value) pair from the hash table
    public V remove(K key) {
        int index = getHash(key);
        for (HashNode<K, V> node : table[index]) {
            if (node.key.equals(key)) {
                V value = node.value;
                table[index].remove(node);
                size--;
                return value;
            }
        }
        return null; // Key not found
    }

    // Return the current number of key-value pairs in the hash table
    public int size() {
        return size;
    }

    // Check if the hash table is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

public class Lab17_2 {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        // Inserting key-value pairs
        hashTable.insert("Alice", 25);
        hashTable.insert("Bob", 30);
        hashTable.insert("Charlie", 35);

        // Retrieving values
        System.out.println("Alice's age: " + hashTable.get("Alice"));
        System.out.println("Bob's age: " + hashTable.get("Bob"));

        // Removing a key-value pair
        hashTable.remove("Alice");

        // Checking size
        System.out.println("Size of hash table: " + hashTable.size());
    }
}