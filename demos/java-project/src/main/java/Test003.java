import sun.swing.plaf.synth.DefaultSynthStyle;

public class Test003 {
    static volatile int num = 0;

    static void incr() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        incr();
                    }
                }
            });
            threads[i].start();
        }
//        for (Thread thread:threads){
//            thread.join();
//        }

        Thread.sleep(1000);
        System.out.println(num);
    }
}
