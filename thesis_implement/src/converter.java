import java.util.ArrayList;
import java.util.List;

public class converter {

        public static List<Integer> sentenceToAscii(String sentence) {
            List<Integer> asciiValues = new ArrayList<>();
            for (char character : sentence.toCharArray()) {
                asciiValues.add((int) character);
            }
            return asciiValues;
        }

        public static String asciiToSentence(List<Integer> asciiValues) {
            StringBuilder sentence = new StringBuilder();
            for (int value : asciiValues) {
                sentence.append((char) value);
            }
            return sentence.toString();
        }

        public static void main(String[] args) {
            String inputSentence = "Hello, world!";

            List<Integer> asciiValues = sentenceToAscii(inputSentence);
            System.out.println("ASCII values: " + asciiValues);

            String outputSentence = asciiToSentence(asciiValues);
            System.out.println("Converted back to sentence: " + outputSentence);
        }
    }


