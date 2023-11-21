package fop.w5cars;

public class Car {
	// TODO
    private String brand;
    private LicensePlate licensePlate;
    private int chassisNumber;
    private static int counter = 1;

    public Car(String brand, LicensePlate licensePlate) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.chassisNumber = counter++;
    }
    public String toString() {
        return "Car " + this.chassisNumber + ": (" + "Brand: " + this.brand + ", LicensePlate" + this.licensePlate + ")";
    }

    //Setters
    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }
    public void setLicensePlate(LicensePlate newLicensePlate) {
        this.licensePlate = newLicensePlate;
    }

    //Getters
    public String getBrand() {
        return brand;
    }
    public int getChassisNumber() {
        return chassisNumber;
    }
    public LicensePlate getLicensePlateNumber() {
        return licensePlate;
    }
    public String getLicensePlateRegionalCode() {
        return licensePlate.getRegionalCode();
    }
    public String getLicensePlateLetters() {
        return licensePlate.getLetters();
    }
}
