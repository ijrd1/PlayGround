package graffiti2019;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * coding style jdk 8
 */
public class Play {

  private static <T> List<List<T>> product2(List<T> xs, List<T> ys) {
    return xs.stream().flatMap(x -> ys.stream().map(y -> Arrays.asList(x, y)))
        .collect(Collectors.toList());
  }

  private static <T> List<List<T>> product(List<List<T>> lists) {
    if (lists.isEmpty()) return Collections.emptyList();
    else if (lists.size() == 1) return Collections.unmodifiableList(lists);
    else if (lists.size() == 2) return product2(lists.get(0), lists.get(1));
    else return lists.subList(1, lists.size()).stream().flatMap(ys -> product2(lists.get(0), ys).stream())
          .collect(Collectors.toList());  // TODO make a fold function
  }

  /**
   * coding style jdk 11 for test
   */
  public static void main(String[] args) {
    product2(
        List.of('a', 'A'),
        List.of('b', 'B')
    ).forEach(list -> System.out.printf("%s ", list));

    System.out.print(System.getProperty("line.separator"));

    // a
    product2(
        List.of(List.of('a', 'b'), List.of('a', 'B'), List.of('A', 'b'), List.of('A', 'B')),
        List.of('c', 'C')
    ).forEach(list -> System.out.printf("%s ", list));

    System.out.print(System.getProperty("line.separator"));

    // b
    product(
        List.of(List.of('a', 'A'), List.of('b', 'B'), List.of('c', 'C'))
    ).forEach(list -> System.out.printf("%s ", list));

  }
}
