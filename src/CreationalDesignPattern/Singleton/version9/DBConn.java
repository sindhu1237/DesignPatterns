package CreationalDesignPattern.Singleton.version9;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBConn {
    private static DBConn instance;
    private static Lock lock = new ReentrantLock();
    public static DBConn getInstance() {
        if(instance == null){
            lock.lock();
            if(instance == null) {
                instance = new DBConn();
            }
            lock.unlock();
        }
        return instance;
    }
}
