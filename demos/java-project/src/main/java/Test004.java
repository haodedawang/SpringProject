//stringTable["a","b","ab"] 堆中的运行时常量池也叫串池 哈希表数据结构
public class Test004 {
    //类加载后，常量池中的信息会被加载到运行时常量池中，这时a,b,ab都是常量池中的符号
    //还没有变成java 字符串对象
    public static void main(String[] args) {
        String s1 = "a";  //去stringTable中找“a”，找不到就吧“a”放入stringTable
        String s2 = "b";  //去stringTable中找“b”，找不到就吧“b”放入stringTable
        String s3 = "ab"; //去stringTable中找“ab”，找不到就吧“ab”放入stringTable
        String s4 = s1 + s2;
        //new StringBuilder().append("a").append("b").toString();
        // public String toString() {
        // // Create a copy, don't share the array
        //    return new String(value, 0, count);
        // }
        //所以s4相当于一个new string("ab") 放入堆中 不在stringTable中
        String s5 = "a" + "b"; //编译器优化相当于 “ab”
    }
}
