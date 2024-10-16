package BehaviouralDesignPattern.Strategy;

public class BikePathCalculator implements PathCalculatorStrategy{
    @Override
    public void findPath(String from, String to) {
        System.out.println("Bike Path");
    }
}
