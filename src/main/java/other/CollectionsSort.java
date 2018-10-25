package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiaoqiang
 * @date 2018-10-25 08
 */
public class CollectionsSort {

    /**
     * 测试Collections.sort的用法
     * @param args
     */
    public static void main(String[] args) {
        List<List> lists = new ArrayList<>();

        ArrayList list = new ArrayList();
        list.add(10l);
        list.add(3l);
        lists.add(list);
        ArrayList list1 = new ArrayList();
        list1.add(1l);
        list1.add(1l);
        lists.add(list1);

        ArrayList list2 = new ArrayList();
        list2.add(12l);
        list2.add(0l);
        lists.add(list2);

        Collections.sort(lists, new Comparator<List>() {
            @Override
            public int compare(List o1, List o2) {
                Long key1 = (Long) o1.get(0);
                Long key2 = (Long) o2.get(0);
                if (key1 < key2){
                    return -1;
                }else if (key1 > key2){
                    return 1;
                }
                return 0;
            }
        });

        System.out.println("lists = " + lists);
    }
}
