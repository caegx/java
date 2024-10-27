package Mines.BankOOP;


public class Customer {
    private String name;
    private String pin;

    public Customer(String name, String pin) {
        this.name = name;
        this.pin = pin;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
 
    @Override
    public String toString() {
        return "Name: " + name + ". pin: " + pin;
    }
    
    public boolean verifyPin(String inputPin) {
        return pin.equals(inputPin);
    }
 
}
