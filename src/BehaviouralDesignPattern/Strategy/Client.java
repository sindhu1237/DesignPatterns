package BehaviouralDesignPattern.Strategy;

public class Client {
    public static void main(String[] args) {
        GoogleMaps gm=new GoogleMaps();
        gm.findPath("Andhra", "Hyderabad", "Bike");
    }
}
