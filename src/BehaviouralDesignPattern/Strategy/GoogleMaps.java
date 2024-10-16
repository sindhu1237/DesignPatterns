package BehaviouralDesignPattern.Strategy;

public class GoogleMaps {
    public void findPath(String from, String to, String mode){
        PathCalculatorStrategy pcs=PathCalculatorFactory.getPathCalculatorForMode(mode);
        System.out.println(pcs.getClass());
        pcs.findPath(from,to);
    }
}
