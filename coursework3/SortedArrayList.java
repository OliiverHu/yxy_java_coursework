package coursework3;

import java.util.ArrayList;
import java.util.Map;

class SortedArrayList<T extends Comparable<T>> extends ArrayList<T> {
    void insert(T element) {
        if(isEmpty()) {
            super.add(0, element);
            return;
        }
        for (int i = 0; i < super.size(); i++) {
            if (element.compareTo(super.get(i)) <= 0) {
                super.add(i, element);
                return;
            }
        }
        super.add(super.size(), element);
    }
//    void show(Map<String, String> map) {
//        for (int i = 0; i < super.size(); i++) {
//            System.out.println(super.get(i));
//            System.out.println(map.get(super.get(i)));
//        }
//    }
//    void show() {
//        for (int i = 0; i < super.size(); i++) {
//            System.out.println(super.get(i));
//        }
//    }
}
