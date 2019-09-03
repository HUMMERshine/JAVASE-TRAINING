package priv.lst.java8;

import com.google.common.collect.Lists;
import one.util.streamex.StreamEx;
import org.junit.Test;
import priv.lst.domain.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lishutao on 2018/6/22.
 *
 * @author lishutao
 * @date 2018/6/22
 */
public class FunctionDemo {

    /**
     * https://www.cnblogs.com/invoker-/p/7709052.html
     *
     * @param a
     * @return
     */

    /**
     * 下面这个方法接受一个int类型参数a,返回a+1,符合我上面说的接受一个参数,返回一个值
     * 所以呢这个方法就符合Function接口的定义,那要怎么用呢,继续看例子
     */
    public static final String addOne(int a) {
        return String.valueOf(a + 1);
    }

    /* 下面调用这个oper方法,将addOne方法作为参数传递 */
    public static void main(String[] args) {
        int x = 1;
        String y = operateFun(x, k -> addOne(x));//这里可以换成方法引用的写法 int y = oper(x,Operation::addOne)
        System.out.printf("x= %d, y = %s", x, y); // 打印结果 x=1, y=2

        /* 当然你也可以使用lambda表达式来表示这段行为,只要保证一个参数,一个返回值就能匹配 */
        y = operateFun(x, k -> String.valueOf(x + 1)); // y = 4
        y = operateFun(x, k -> String.valueOf(x * 1)); // y = 3

        System.out.println("\n**********");
        /**
         * consumer
         */

        operateConsumer("hello", k -> System.out.println("hello"));
        operateConsumer("hello", k -> {
            k = k + " world";
            System.out.println(k);
        });
    }

    /**
     * 该方法第二个参数接受一个function类型的行为,然后调用apply，对a执行这段行为
     */
    public static String operateFun(int a, Function<Integer, String> action) {
        return action.apply(a);
    }

    /**
     * consumer 方法只接受参数，没有返回值
     * @param a
     * @param action
     */
    public static void operateConsumer(String a, Consumer<String> action) {
        action.accept(a);
        return;
    }
}
