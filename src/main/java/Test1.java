import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Base {
    static int num = 1;

    static {
        System.out.println("Base " + num);
    }
}
public class Test1 {

    public volatile int inc = 0;

    public synchronized  void increase() {
        inc++;
    }

    public static void main(String[] args) {

        Integer a = 200;
        int b = 200;
        Integer c = new Integer(200);
        Integer d = new Integer(200);
        Integer e = 200;
        System.out.println("ab:"+(a==b));
        System.out.println("ae:"+(a==e));
        System.out.println("ac:"+(a==c));
        System.out.println("bc:"+(c==b));
        System.out.println("cd;"+(c==d));


        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("2");
        set.add("1");
        set.add(new String("1"));
        System.out.println(set.size());
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            it.remove();
        }
        System.out.println(set.size());


       /* final Test test = new Test();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
        while(Thread.activeCount()>2)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);*/
    }


    public static void  test(int num ){


        int[][] arr = new int[num][num];
        int x = 0;
        for(int i = 0;i < num/2; i++){
            for (int j = i;j< num -1 - i;j++){
                if(x == 10){
                    x = 0;
                }
                arr[i][j] = x;
                x++;
            }
            for(int k = i;k<num -1-i;k++){
                if(x == 10){
                    x = 0;
                }
                arr[k][num -i -1] = x;
                x++;
            }
            for (int j = num-i-1;j>i;j--){
                if(x == 10){
                    x = 0;
                }
                arr[num-i-1][j] = x;
                x++;
            }
            for(int k = num -i-1;k>i;k--){
                if(x == 10){
                    x = 0;
                }
                arr[k][i] = x;
                x++;
            }
        }
        for (int i = 0;i< num;i++){
            for (int j = 0;j<num;j++){
                System.out.print(arr[i][j]+"   ");
            }
            System.out.println();
        }
    }

}