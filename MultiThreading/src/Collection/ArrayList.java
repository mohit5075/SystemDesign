package Collection;

import java.util.Iterator;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        List<Integer> list = new java.util.ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()){
            int val = integerIterator.next();
            System.out.println(val);
        }
    }
}
