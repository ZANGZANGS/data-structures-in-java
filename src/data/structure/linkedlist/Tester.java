package data.structure.linkedlist;



public class Tester {
    public static  void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        int n = 10;
        for (int i= 0 ; i<n ; i++){
            list.addFirst(i);
        }

        for (int i = n-1 ; i>0 ; i--){
            int x = list.removeFirst();
        }

        for (int i= 0 ; i<n ; i++){
            int x = list.removeLast();
        }
    }
}
