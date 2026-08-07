public class Cars {
    static class Car{
        String model_name;
        int price;
        Car(){
            model_name = "Tesla";
            price = 6000000;
            System.out.println("Customer Registered \n Car Model : "+model_name+"\n Car Price : "+price+"\n");
        }
        Car(String model_name){
            this.model_name = model_name;
            price = 9600000;
            System.out.println("Customer Registered \n Car Model : "+model_name+"\n Car Price : "+price+"\n");
        }
        Car(String model_name,int price){
            this.model_name = model_name;
            this.price = price;
            System.out.println("Customer Registered \n Car Model : "+model_name+"\n Car Price : "+price+"\n");
        }
    }
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Lamborghini");
        Car car3 = new Car("BMW",7800000);
    }
}
