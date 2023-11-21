package fop.w5cars;

public class LicensePlate {
	// TODO
    private String regionalCode;
    private String letters;
    private int digits;

    public LicensePlate(String regionalCode, String letters, int digits){
        this.regionalCode = regionalCode;
        this.letters = letters;
        this.digits = digits;
    }
    public boolean isEqual(LicensePlate other) {
        return this.regionalCode.equals(other.getRegionalCode()) && this.letters.equals(other.getLetters()) && this.digits == other.getDigits();
    }

    //Getters
    public int getDigits() {
        return digits;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public String getLetters() {
        return letters;
    }

    //Setters
    public void setLetters(String newLetters) {
        this.letters = newLetters;
    }

    public void setRegionalCode(String newRegionalCode) {
        this.regionalCode = newRegionalCode;
    }

    public void setDigits(int newDigits) {
        this.digits = newDigits;
    }
}
