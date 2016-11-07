/**
 * Created by sbin on 2016/11/8.
 */
public class Main {

    public static void main(String[] args) {
        new Thread(()-> System.out.println("aaa")).start();
        System.out.println("hello DB");
    }
}
