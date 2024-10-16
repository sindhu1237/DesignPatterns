package BehaviouralDesignPattern.Strategy;

public class WalkPathCalculator implements PathCalculatorStrategy{
    @Override
    public void findPath(String from, String to) {
        System.out.println("Walk Path");
    }
}
