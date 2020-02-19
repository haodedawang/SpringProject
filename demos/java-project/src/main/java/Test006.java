import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;


//设置堆内存为20M -Xmx20m -XX:+PrintGCDetails -verbose:gc
public class Test006 {
    private static final int _4MB = 1024 * 1024 * 4;

    public static void main(String[] args) throws IOException {
        //创建引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //关联了引用队列，当软引用关联的byte[]对象被回收时，软引用自己会加入到queue中
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

        //移除掉占用内存的软引用对象
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("================================");
        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
