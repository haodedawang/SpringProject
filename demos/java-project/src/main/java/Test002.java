import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

public class Test002 {
    volatile int status = 0;
    Queue parkQueue;

    public void lock() {
        while (compareAndSet(0, 1)) {
            //将当前线程加入到等待队列
            parkQueue.add(Thread.currentThread());
            //调用UNSAFE方法使当前线程睡眠，阻塞
            LockSupport.park();
        }
    }

    public void unlock() {
        status = 1;
        //得到要唤醒的头部线程
        Thread thread = (Thread) parkQueue.poll();
        //唤醒等待线程
        LockSupport.unpark(thread);
    }

    boolean compareAndSet(int x, int y) {
        //不安全的伪代码
        if (x == 0) {
            status = y;
            return true;
        }
        return false;
    }
}
