package fop.w5cars;

public class CarPark {
	// TODO
    private Car[] spaces;
    public CarPark(int parkSize){
        this.spaces = new Car[parkSize];
    }
    public int park(Car c) {
        for (int i = 0; i < this.spaces.length; i ++) {
            if (this.spaces[i] == null) {
                this.spaces[i] = c;
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }
    public int search(LicensePlate lp) {
        for (int i = 0; i < this.spaces.length; i++) {
            if(this.spaces[i].getLicensePlateNumber().isEqual(lp) && this.spaces[i]!=null){
                return i;
            }
        }
        return -1;
    }
    public Car driveOff(LicensePlate lp) {
        if(search(lp) == -1) {
            return null;
        } else {
            Car car = spaces[search(lp)];
            spaces[search(lp)] = null;
            return car;
        }
    }
    public String toString() {
        StringBuilder result = new StringBuilder("Car Park:\n");
        for (int i = 0; i < spaces.length; i++) {
            result.append(i).append(": [");
            if (spaces[i] != null) {
                result.append(spaces[i]);
            }
            result.append("]\n");
        }
        return result.toString();
    }
    //Getters
    public Car[] getSpaces() {
        return this.spaces;
    }
    public int getCarParkSize() {
        return this.spaces.length;
    }

    //Setters
    public void setParkSize(int newParkSize) {
        this.spaces = new Car[newParkSize];
    }
    public void setSpaces(Car[] newCarPark) {
        this.spaces = newCarPark;
    }

}
