package karisworks.carrental;
public class Car{
    private final String carID;
    private final String model;
    private final boolean isAvailable;
    
    public Car(String carID,String model){
        this.carID = carID;
        this.model = model;
        this.isAvailable = true;
    }
    public String getCarID(){return carID;}
    public String getModel(){return model;}
    public boolean isAvailable(){return isAvailable;}
    
    @Override
    public String toString(){
        return model + "[" + (isAvailable?"Available":"Rented")+"]";
    }
}