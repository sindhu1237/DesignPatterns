package BehaviouralDesignPattern.Strategy;

public class CarPathCalculator implements PathCalculatorStrategy{
    @Override
    public void findPath(String from, String to) {
        System.out.println("Car Path");
    }
}
