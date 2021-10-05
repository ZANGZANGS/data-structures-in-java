package data.structure.hash;

import java.util.LinkedList;

public class Hash<K, V> implements HashInterface{

    class HashElement<K, V> implements Comparable<HashElement<K,V>>{

        K key;
        V value;

        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>)this.key).compareTo(o.key));
        }
    }

    int numElements;
    int tableSize;  //array size
    double maxLoadFactor;
    LinkedList<HashElement<K,V>>[] hashArray;

    public Hash(int tableSize){
        this.tableSize = tableSize;
        hashArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            hashArray[i] = new LinkedList<HashElement<K,V>>();
        }
        maxLoadFactor = 0.75;
        numElements = 0;
    }



}
