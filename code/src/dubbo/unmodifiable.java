package dubbo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author hdgaadd
 * Created on 2022/02/12
 */
public class unmodifiable { // ['ʌn'mɔdifaiəbl]无法改变的
    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<Integer>(){{ add(1); }};

        Collection<Integer> unmodifiable = Collections.unmodifiableCollection(list);


        // 源改变即改变
        list.add(2);
        System.out.println(list);
        System.out.println(unmodifiable);

        // 不可修改
        unmodifiable.add(3); // Exception in thread "main" java.lang.UnsupportedOperationException
    }
}
