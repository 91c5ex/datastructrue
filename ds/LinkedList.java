package ds;

public class LinkedList<T> implements java.io.Serializable{
    private transient Node<T> first;
    private transient int size;
    private transient Node<T> last;

    private static class Node<T> {
        T data;
        Node<T> next;

//        Node(T data) {
//            this.data = data;
//        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }


    public void add(T data) {
//        First Apporach
//            if(first == null){
//                first = new Node<>(data);
//                size++;
//            }else{
//                Node<T> tempNode = first;
//                while (tempNode != null){
//                    if(tempNode.next == null){
//                        tempNode.next = new Node<>(data);
//                        size++;
//                        break;
//                    }
//                    tempNode = tempNode.next;
//
//                }
//            }

//        if(first == null){
//            first = new Node<T>(data);
//            last = first;
//            size++;
//        }else {
//            size++;
//            last.next = new Node<T>(data);
//            last = last.next;
//        }

//        final Node<T> n = new Node<>(data);
//        if (first == null) {
//            first = n;
//            last = first;
//        } else {
//            last.next = n;
//            last = last.next;
//        }
//        size++;

        final Node<T> l = last;
        final Node<T> n = new Node<>(data,null);
        last = n;
        if (l == null) {
            first = n;
        } else {
            l.next = n;
//            last = l.next;
        }
        size++;
    }

    public void addFist(T data){
        final Node<T> f = first;
        final Node<T> n = new Node<>(data,null);
//        if(f == null) {
//            first= n;
//        }else{
//            n.next = first;
//            first = n;
//        }
            n.next = first;
            first = n;
            if(last == null){
                last = first.next;
            }

            size++;
    }

    public int size() {
        return size;
    }

    public void print() {
        if (first != null) {
            Node<T> tempNode = first;
            while (tempNode != null) {
                System.out.println(tempNode.data);
                tempNode = tempNode.next;
            }
        }
    }

    public void add(T data , int position){
        if(position > size || size < 1){
            add(data);
        }else{
            Node<T> n = new Node<>(data,null);
            Node<T> t = first;


//            while(t.next != last || (loc != position)){
//                loc++;
//                t = t.next;
//            }
//
//            t.next = n;
            int i;

//            for(i=0; (i < size) && (i <= position) ; i++){
            for(i=1; i < position-1; i++){
                t = t.next;

            }
            System.out.println("Position "+i);
//            Node<T> succ = t.next;
//            n.next = succ;
//            t.next = n;

//           n.next = t;
////            t.next = n;
//           first=n;

//           Node<T> temp = t.next;
//           n.next = temp;
//           t.next = n;



            n.next = t.next;
            t.next = n;




        }
    }



}
