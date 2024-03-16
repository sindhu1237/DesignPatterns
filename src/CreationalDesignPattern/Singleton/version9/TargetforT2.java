package CreationalDesignPattern.Singleton.version9;

public class TargetforT2 implements Runnable{
    public DBConn ref;
    @Override
    public void run() {
        DBConn db3 =  DBConn.getInstance();
        this.ref = db3;
        System.out.println(db3);
    }
}
