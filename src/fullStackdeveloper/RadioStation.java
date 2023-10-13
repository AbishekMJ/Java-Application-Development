package fullStackdeveloper;
// program demonstration on Campus Radio Frequency - User defined exception
import java.util.Scanner;
public class RadioStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Scan the radio station");
        float inputFrequency = scanner.nextFloat();
        
        try {
            boolean isValid = Validator.validateStation(inputFrequency);
            if (isValid) {
                System.out.println(inputFrequency + " is the right frequency");
            }
        } catch (StationNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
class StationNotAvailableException extends Exception {
    public StationNotAvailableException(float frequency) {
        super("The frequency " + frequency + " is out of range");
    }
}
class Validator {
    public static boolean validateStation(float freq) throws StationNotAvailableException {
        float[] availableFrequencies = {91.2f, 93.5f, 98.9f, 109.4f};
        
        for (float availableFreq : availableFrequencies) {
            if (availableFreq == freq) {
                return true;
            }
        }
        
        throw new StationNotAvailableException(freq);
    }
}