package CreationalDesignPattern.Singleton.version9;

public class TargetForT1 implements Runnable{
    public DBConn ref;
    @Override
    public void run() {
        DBConn db2 =  DBConn.getInstance();
        this.ref = db2;
        System.out.println(db2);
    }
}
