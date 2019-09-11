package other;

import com.sun.org.apache.xpath.internal.SourceTree;
import other.pojo.Person;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaoqiang
 * @date 2018-10-30 10
 */
public class Test {
    public static void main(String[] args) {
        int young = 10;
        int old = 30;
        List<Person> personList = Arrays.asList(
                new Person("xiaoqiang", 19),
                new Person("doudou", 18),
                new Person("xiaoqiang", 30),
                new Person("doudou", 28),
                new Person("doudou", 26),
                new Person("xiaoqiang", 35));
        Map<String, Map<Integer, List<Person>>> collect = personList.stream().collect(Collectors.groupingBy(Person::getName,
                Collectors.groupingBy(p -> p.getAge() < 25 ? young : old)));
        System.out.println("collect = " + collect);
    }

    public static void test7() {
        List<String> strings = Arrays.asList("adja", "-dhfuhedfdaohfohdiahfoiagagfagdfdfsdgagag", "-dhfiwueoh", "-mfc", "dofijdkaofijdo");
        String string1 = strings.stream().collect(Collectors.joining(", "));
        System.out.println("string = " + string1);
        Integer len = strings.stream().collect(Collectors.reducing(0, String::length, (i, j) -> i + j));
        System.out.println("len = " + len);
        Optional<String> collect = strings.stream().collect(Collectors.reducing((s1, s2) -> s1.length() > s2.length() ? s1 : s2));
        System.out.println(collect.get() + collect.get().length());
        Map<String, List<String>> collect1 = strings.stream().collect(Collectors.groupingBy(string -> {
            if (string.length() < 10) {
                return "low";
            } else if (string.length() < 30) {
                return "mid";
            } else {
                return "high";
            }
        }));
        System.out.println("collect1 = " + collect1);
    }

    public static void test6() {
        Stream.iterate(new long[]{0, 1}, n -> new long[]{n[0] + n[1], n[0] + n[1] * 2})
                .limit(30)
                .forEach(arr -> {
                    System.out.println(arr[0]);
                    System.out.println(arr[1]);
                });
    }

    public static void test5() {
        String fileName = "F:\\mylog.log";
        File file = new File(fileName);
        try {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            lines
                    .limit(15)
                    .forEach(line -> System.out.println("line = " + line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test4() {
        int[] nums = new int[]{12, 3, 4};
        int sum = Arrays.stream(nums).sum();
        System.out.println("sum = " + sum);
    }

    public static void test3() {
        IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                )
                .forEach(arr -> System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2]));
    }

    public static void test2() {
        List<String> words = Arrays.asList("word", "hello");
        List<String> collect = words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    public static void test1() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<List<Integer>> collect = list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> Arrays.asList(i, j))
                )
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

}
