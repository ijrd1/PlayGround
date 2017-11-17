package quiz;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * リフレクションは、文字列で指定されたクラスのメソッドの実行などを可能にし、
 *　プログラムの自由度を向上させる便利な技法。
 *  その分、副作用などに気をつければならない。
 *  (クラス名変更による class not found など)
 */
public class ReflectionChallenge2 {

  public static void main(String... args) {
    System.out.println(Jedi.class.getAnnotation(Table.class).name());
    System.out.println(Jedi.class.getAnnotation(Column.class).name());
  }

  @Table(name = "jedi")
  private static class Jedi {
    @Column(name = "attack_type")
    String attackType;

    public String getAttackType() {
      return attackType;
    }
  }

  @Retention(RetentionPolicy.RUNTIME)
  @interface Table {
    String name();
  }

  @interface Column {
    String name();
  }
}
