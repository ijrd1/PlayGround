package graffiti2019;

import java.util.*;

class SubSet {
  /** BFS */
  static <T> List<List<T>> generateWithDq(List<T> xs) {
    Deque<List<T>> queue = new LinkedList<>() {{
      add(new ArrayList<>());
    }};

    for (var i = 0; i < xs.size(); i++) {
      var currNode = xs.get(i);

      for (var j = 0; j < (1 << i); j++) { // OUT one and IN two, per 1 loop
        var parent = queue.removeFirst();
        var leftChild = new ArrayList<>(parent) {{
          add(currNode);
        }};
        var rightChild = new ArrayList<>(parent);

        queue.addLast(leftChild);
        queue.addLast(rightChild);
      }
    }
    return new ArrayList<>(queue);
  }

  /** Bit-op */
  static <T> List<List<T>> generateWithBitwise(List<T> xs) {
    var ps = new ArrayList<List<T>>();
    var len = xs.size();
    long breadth = 1 << len;

    for (var i = 0; i < breadth; i++) {
      var chunk = new ArrayList<T>();  // init 2^N times
      for (var j = 0; j < len; j++) {
        if ((i & (1 << j)) > 0) chunk.add(xs.get(j));
      }
      ps.add(chunk);
    }
    return ps;
  }

  /** Recursion (DFS) */
  static <T> List<List<T>> generateWithDfs(List<T> xs) {
    List<List<T>> ps = new ArrayList<>();

    class Dfs {
      private void generate(int pos, List<T> chunk) {
        if (pos == xs.size()) {
          ps.add(chunk);
          return;
        }
        generate(pos + 1, new ArrayList<>(chunk) {{ add(xs.get(pos)); }});
        generate(pos + 1, chunk);
      }
    }

    new Dfs().generate(0, new ArrayList<>());
    return ps;
  }

  static <T> List<List<T>> generateWithDfs_(T[] xs) {
    List<List<T>> res = new ArrayList<>();
    var n = xs.length;
    var last = n - 1;

    if (n > 0) {
      for (List<T> x : generateWithDfs_(Arrays.copyOf(xs, last))) {
        res.add(new ArrayList<>(x) {{ add(xs[last]); }});
        res.add(x);
      }
    } else {
      res.add(List.of());
    }

    return res;
  }

}
