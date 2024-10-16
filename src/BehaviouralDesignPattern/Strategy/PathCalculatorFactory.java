package BehaviouralDesignPattern.Strategy;

public class PathCalculatorFactory {
//   static CarPathCalculator cpc=new CarPathCalculator();
//    static BikePathCalculator bpc=new BikePathCalculator();
//    static WalkPathCalculator wpc=new WalkPathCalculator();
   public static PathCalculatorStrategy getPathCalculatorForMode(String mode){
        if(mode.equals("Car")){
            return new CarPathCalculator();
        }else if(mode.equals("Bike")){
            return new BikePathCalculator();
        }else{
            return new WalkPathCalculator();
        }
    }
}
