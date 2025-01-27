public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Returns a new array that is the reverse of a[]
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[]
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        return result;
    }

    // Returns a new array that is the sum of a[] and b[]
    public static double[] mix(double[] a, double[] b) {
        int length = Math.max(a.length, b.length);
        double[] result = new double[length];
        for (int i = 0; i < length; i++) {
            double aValue = (i < a.length) ? a[i] : 0;
            double bValue = (i < b.length) ? b[i] : 0;
            result[i] = aValue + bValue;
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) (a.length / alpha);
        double[] result = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            int index = (int) (i * alpha);
            result[i] = a[index];
        }
        return result;
    }

    // Creates an audio collage and plays it on standard audio
    public static void main(String[] args) {
        // Read input files
        double[] piano = StdAudio.read("piano.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");

        // Create effects
        double[] amplifiedPiano = amplify(piano, 0.5);
        double[] reversedChimes = reverse(chimes);
        double[] fastHarp = changeSpeed(harp, 1.5);
        double[] loudCow = amplify(cow, 2.0);
        double[] slowBeatbox = changeSpeed(beatbox, 0.8);

        // Mix and merge to create collage
        double[] mix1 = mix(amplifiedPiano, reversedChimes);
        double[] mix2 = mix(fastHarp, loudCow);
        double[] part1 = merge(mix1, mix2);
        double[] finalCollage = merge(part1, slowBeatbox);

        // Play the result
        StdAudio.play(finalCollage);
    }
}