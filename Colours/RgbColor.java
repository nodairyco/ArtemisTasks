public class RgbColor {
    private final int red;
    private final int green;
    private final int blue;
    protected final int bitDepth;
    public RgbColor(){
        this.bitDepth = 0;
        this.blue = 0;
        this.red = 0;
        this.green = 0;
    }
    public RgbColor(int bitDepth,int red, int green, int blue){
        if(bitDepth < 0 || bitDepth > 31){
            ExceptionUtil.unsupportedOperation("Invalid value for colour depth.");
            this.bitDepth = 0;
        } else{
            this.bitDepth = bitDepth;
        }
        if(red > Math.pow(2, bitDepth) - 1 || red < 0){
            ExceptionUtil.unsupportedOperation("Invalid value for red.");
            this.red = 0;
        } else{
            this.red = red;
        }
        if(green > Math.pow(2, bitDepth) - 1 || green < 0){
            ExceptionUtil.unsupportedOperation("Invalid value for green.");
            this.green = 0;
        } else{
            this.green = green;
        }
        if(blue > Math.pow(2, bitDepth) - 1 || blue < 0){
            ExceptionUtil.unsupportedOperation("Invalid value for blue.");
            this.blue = 0;
        } else{
            this.blue = blue;
        }
    }
    public RgbColor8Bit toRgbColor8Bit(){
        if (bitDepth == 8)
            return new RgbColor8Bit(red, green, blue);
        int red8Bit = convertValueTo8Bit(red);
        int green8Bit = convertValueTo8Bit(green);
        int blue8Bit = convertValueTo8Bit(blue);
        return new RgbColor8Bit(red8Bit, green8Bit, blue8Bit);
    }
    private int convertValueTo8Bit(int val) {
        if (bitDepth > 8) {
            int newVal =  val /(int) Math.pow(2, bitDepth - 9);
            return Math.min(newVal /  2 + newVal % 2, (int) Math.pow(2, (8) - 1));
        }
        if (bitDepth < 8) {
            int newVal = val;
            int left = 8 - bitDepth;
            while (left != 0) {
                int shift = Math.min(bitDepth, left);
                newVal = newVal *(int) Math.pow(2, shift) + val /(int) Math.pow(2, bitDepth - shift);
                left -= shift;
            }
            return newVal;
        }
        return val;
    }
    public int getRed(){
        return red;
    }
    public int getGreen(){
        return green;
    }
    public int getBlue(){
        return blue;
    }
    public int getBitDepth(){
        return bitDepth;
    }
}
