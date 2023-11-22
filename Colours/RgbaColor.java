public class RgbaColor extends RgbColor{
    private final int alpha;
    public RgbaColor(int bitDepth, int red, int green, int blue, int alpha){
        super(bitDepth, red, green, blue);
        if(alpha < 0 || alpha > Math.pow(2, bitDepth)){
            ExceptionUtil.unsupportedOperation("Invalid value for alpha");
            this.alpha = 0;
        } else{
            this.alpha = alpha;
        }
    }
    public int getAlpha(){
        return alpha;
    }
    @Override
    public RgbColor8Bit toRgbColor8Bit(){
        if(alpha < Math.pow(2, bitDepth) - 1){
            ExceptionUtil.unsupportedOperation("Can't turn colour to 8bit");
        } else{
            return super.toRgbColor8Bit();
        }
        return null;
    }
}
