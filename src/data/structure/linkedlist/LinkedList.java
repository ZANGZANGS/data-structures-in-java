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
    private Node<E> tail;
    private int currentSize;

    public LinkedList(){
        head = null;
        tail = null;
        currentSize = 0;

    }

    public void addFirst(E obj){
        Node<E> node = new Node<>(obj);

        if(null == head){
            head = node;
            tail = node;
            currentSize++;
            return;
        }

        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E obj){
        Node<E> node = new Node<>(obj);

        if(null == head){
            head = node;
            tail = node;
            currentSize++;
            return;
        }

        /*Node<E> tmp = head;
        while(null != tmp.next){
            tmp = tmp.next;
        }
        tmp.next = node;*/
        tail.next = node;
        tail = node;
        currentSize++;
    }

    public E removeFirst(){

        //empty
        if(null == head){
            return null;
        }

        E tmp= head.data;

        //single element
        if(head == tail ){
        //if(currentSize == 1 )
        //if(null == head.next )
            head = null;
            tail = null;
        }else{
            head = head.next;
        }

        currentSize--;
        return  tmp;

    }
}
