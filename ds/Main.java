package ds;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for(int i =0 ; i< 2;i++){
            list.addFist(i);
        }

        list.print();
        System.out.println("---------------------------");

        list.add(4,0);
        list.print();
        System.out.println("----------------------------");
        list.add(10,2);
        System.out.println("----------------------------");
        list.print();
        list.addFist(100);
        System.out.println("----------------------------");
        list.print();
        list.add(99,2);
        System.out.println("----------------------------");
        list.print();


//        System.out.println(list.size());
//        System.out.println("TotalTime "+(System.currentTimeMillis()-startTime)/1000);



//        java.util.LinkedList<Integer> jList = new java.util.LinkedList<>();
//        startTime = System.currentTimeMillis();
//        for(int i =0 ; i< 10000000;i++){
//            jList.add(i);
//        }
//        System.out.println(jList.size());
//        System.out.println("TotalTime "+(System.currentTimeMillis()-startTime)/1000);
    }
}
