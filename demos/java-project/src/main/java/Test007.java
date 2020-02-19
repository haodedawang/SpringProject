import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//设置堆内存为20M -Xmx20m -XX:+PrintGCDetails -verbose:gc
public class Test007 {
    private static final int _4MB = 1024 * 1024 * 4;

    public static void main(String[] args) throws IOException {

        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w:list){
                System.out.print(w.get());
            }
            System.out.println();
        }
        System.out.println("循环结束：" + list.size());
    }
}
