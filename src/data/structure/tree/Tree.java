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


    //add function
    private void add(E obj, Node<E> node){

        if(((Comparable<E>)obj).compareTo(node.data)>0){
            //go to right
            if(null == node.right) {
                node.right = new Node<E>(obj);
                return;
            }

            add(obj, node.right);
            return;
        }else{
            //go to left
            if(null == node.left) {
                node.left = new Node<E>(obj);
                return;
            }
            add(obj, node.right);
            return;
        }

    }

    public void add(E obj){
        if(null == root){
            root = new Node<E>(obj);
        }else{
            add(obj, root);
            currentSize++;
        }
    }


    //contains function
    public boolean contains(E obj){
        return contains(obj, root);
    }

    private boolean contains(E obj, Node<E> node){
        if(node == null){
            return false;
        }

        if(((Comparable<E>)obj).compareTo(node.data) == 0){
            return true;
        }

        if(((Comparable<E>)obj).compareTo(node.data) > 0){
            return contains(obj, node.right);
        }

        return contains(obj, node.left);
    }
}
