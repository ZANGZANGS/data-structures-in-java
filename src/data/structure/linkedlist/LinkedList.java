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
        E tmp= head.data;

        //empty
        if(null == head){
            return null;
        }

        //single element
        if(head == tail){
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

    public E removeLast(){
        Node<E> previous = null;
        Node<E> current = head;

        //empty
        if(null == tail){
            return null;
        }

        //single element
        if(head == tail){
            return removeFirst();
        }

        while (current != tail){
            previous = current;
            current = current.next;
        }

        previous.next = null; //GC ?
        tail = previous;
        currentSize--;

        return current.data;
    }

    public E remove(E obj){
        Node<E> previous = null;
        Node<E> current = head;

        //empty
        if(null == tail){
            return null;
        }

        //single element
        if(head == tail){
            removeFirst();
        }

        while (current != null){

            if(((Comparable<E>)current.data).compareTo(obj)==0){
                //beginning
                if(current == head){
                    return removeFirst();
                }
                //end
                /*if(current == tail){
                    return removeLast();
                }*/
                //middle
                previous.next = current.next;
                currentSize--;
                return  current.data;
            }

            previous = current;
            current = current.next;
        }

        return  null;
    }

}
