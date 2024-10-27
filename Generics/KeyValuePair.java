package Generics;

public class KeyValuePair<K, V> {
    private K key;
    private V value;

    //multiple type parameters
    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    
}
