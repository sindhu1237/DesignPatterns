package SOLIDPrinciple.BirdDesign;

public class Client {
    public static void main(String[] args) {
        Sparrow s = new Sparrow(new SlowFlyator());
        s.fly();
//        Sparraow s1 = new Sparrow(new SlowFlyator()); // Constructor injection
//        Sparraow s2 = new Sparrow(new FastFlyator()); // Constructor injection
        s.setFlyator(new SlowFlyator()); // Method injection
        s.fly();

        s.setFlyator(new FastFlyator()); // Method injection
        s.fly();
    }
}
