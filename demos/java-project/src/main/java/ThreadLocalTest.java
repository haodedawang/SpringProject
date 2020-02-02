import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Equals;

public class ThreadLocalTest {
    static int a = 1000;
    static int b = 1000;
    static Integer c = 1000;
    static Integer g = 1000;
    static Integer d = new Integer(1000);
    static Integer f = new Integer(1000);

    public static void main(String[] args) {
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(b == d);
        System.out.println(c == g);

        System.out.println(c == d);
        System.out.println(d == f);

        System.out.println(c.equals(a));
        System.out.println(c.equals(d));
        System.out.println(d.equals(a));
        System.out.println(d.equals(f));


    }

}
