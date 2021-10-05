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

    public double loadFactor(){
        return (double)numElements/tableSize;
    }

    public void resize(int newSize){

        LinkedList<HashElement<K,V>>[] new_array =(LinkedList<HashElement<K,V>>[]) new LinkedList[newSize];

        for (int i = 0; i < newSize; i++) {
            new_array[i] = new LinkedList<HashElement<K,V>>();

        }

        for (LinkedList<HashElement<K,V>> linkedList: hashArray) {

            for (HashElement<K,V> he :linkedList) {
                K key = he.key;
                V value = he.value;
                HashElement<K,V> new_he = new HashElement<>(key, value);
                int hashVal = (key.hashCode() & 0x7fffffff %newSize);

                new_array[hashVal].add(new_he);

            }
        }

        hashArray = new_array;
        tableSize = newSize;


    }

    public boolean add(K key, V value){

        if( loadFactor() >maxLoadFactor){
          resize(tableSize*2);
        }

        HashElement<K,V> he = new HashElement<>(key, value);

        int hashval = key.hashCode();
        hashval = hashval & 0x7fffffff;
        hashval = hashval % tableSize;

        hashArray[hashval].add(he);
        numElements++;
        return true;
    }

    public boolean remove(HashElement he){
        int hashval = he.key.hashCode();
        hashval = hashval & 0x7fffffff;
        hashval = hashval % tableSize;

        hashArray[hashval].remove(he);
        numElements--;
        return true;
    }

    public V getValue(K key){
        int hashval = key.hashCode()&0x7fffffff % tableSize;
        for (LinkedList<HashElement<K, V>> linkedList: hashArray) {

            for (HashElement<K,V> he: linkedList) {
                if( ((Comparable<K>)key).compareTo(he.key) == 0 ){
                    return he.value;
                }
            }
        }

        return null;
    }



}
