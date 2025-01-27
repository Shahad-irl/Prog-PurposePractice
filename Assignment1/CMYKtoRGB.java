public class CMYKtoRGB {
    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white = 1 - black;

        double redCalc = 255 * white * (1 - cyan);
        double greenCalc = 255 * white * (1 - magenta);
        double blueCalc = 255 * white * (1 - yellow);

        int red = (int) Math.round(redCalc);
        int green = (int) Math.round(greenCalc);
        int blue = (int) Math.round(blueCalc);

        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);
    }
}
