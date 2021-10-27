package data.structure.tree;

public class Tree<E> {

    //1 Node Class
    private Node<E> root;
    private int currentSize = 0;

    class Node<E>{
        E data;
        Node<E> left, right;

        public Node(E obj){
            this.data = obj;
            left = null;
            right = null;
        }


    }

}
