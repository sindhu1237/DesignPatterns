package CreationalDesignPattern.Singleton.version9;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        TargetForT1 o1 = new TargetForT1();
        Thread t1 = new Thread(o1);
        TargetForT1 o2 = new TargetForT1();
        Thread t2 = new Thread(o2);
        DBConn db1 = DBConn.getInstance();
        t1.start();
        t2.start();
        System.out.println(db1);
        t1.join();
        t2.join();
    }
}
