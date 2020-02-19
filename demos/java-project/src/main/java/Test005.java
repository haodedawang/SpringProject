//["a","b","ab"]
public class Test005 {
    public static void main(String[] args) {
        //ab放入串池
        String x="ab";
        //a方川串池，b放入串池 new string("ab")放在堆上
        String s = new String("a") + new String("b");
        //将ab尝试放在串池 如果有则不会放入，如果没有则放入 并且无论哪种情况都返回串池中的ab
        String s2 = s.intern(); //串池中已经有了 s没有放进去 但是返回的s2是串池中的ab
        //s没有放进去 依然在堆中
        System.out.println(s==x);//f
        //s2返回的是串池中的ab
        System.out.println(s2==x);//t
        System.out.println(System.currentTimeMillis());
    }
}
