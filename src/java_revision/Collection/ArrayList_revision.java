package java_revision.Collection;

import java.util.ArrayList;

public class ArrayList_revision {
    public static void main (String[] args) {
//        Multi-Dimentional ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        mainList.add(list);

        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(3);
//        list2.add(4);
//        mainList.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=1; i<=5; i++){
            list.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        mainList.add(list);
        mainList.add(list2);
        mainList.add(list3);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
        System.out.println(mainList);



    }
}

