package data.structure.linkedlist;

public class LinkedList<E>  {

    class Node<E> {
        private E data;
        Node<E> next;

        public Node(E obj){
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private int currentSize;

    public LinkedList(){
        head = null;
        currentSize = 0;

    }

}
