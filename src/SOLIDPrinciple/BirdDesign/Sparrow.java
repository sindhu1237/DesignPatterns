package SOLIDPrinciple.BirdDesign;

public class Sparrow {
    private Flyator ref; // just a socket
//   Constructor injection
    public Sparrow(Flyator ref) {
        this.ref = ref;
    }

    public void setFlyator(Flyator r) {
        ref = r;
    }
    void fly() {
        if(ref == null) {
            System.out.println("No algorithm for flight provided");
            return ;
        }
        ref.flightAlgorithm();
    }
}
