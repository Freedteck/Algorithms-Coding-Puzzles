import java.util.*;

public class Main {
    public static String decode(String encoded, HashMap<String, String> codebook) throws Exception {
        StringBuilder decoded = new StringBuilder();
        int i = 0;
        while (i < encoded.length()) {
            boolean matchFound = false;
            for (String symbol : codebook.keySet()) {
                String code = codebook.get(symbol);
                if (encoded.startsWith(code, i)) {
                    decoded.append(symbol);
                    i += code.length();
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                throw new Exception("Invalid encoding: " + encoded.substring(i));
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        HashMap<String, String> codebook = new HashMap<String, String>();
        codebook.put("a", "00");
        codebook.put("b", "01");
        codebook.put("c", "10");
        codebook.put("d", "1100");
        codebook.put("e", "1101");
        codebook.put("f", "1110");
        codebook.put("g", "111100");
        codebook.put("h", "111101");
        codebook.put("i", "111110");
        codebook.put("j", "1111110000");
        codebook.put("k", "1111110001");
        codebook.put("l", "1111110010");
        codebook.put("m", "1111110011");
        codebook.put("n", "1111110100");
        codebook.put("o", "1111110101");
        codebook.put("p", "1111110110");
        codebook.put("q", "1111110111");
        codebook.put("r", "1111111000");
        codebook.put("s", "1111111001");
        codebook.put("t", "1111111010");
        codebook.put("u", "1111111011");
        codebook.put("v", "1111111100");
        codebook.put("w", "1111111101");
        codebook.put("x", "1111111110");
        codebook.put("y", "1111111111");
        codebook.put("z", "11111111110000");
        codebook.put(" ", "11111111110001");

        try {
            String encoded = "11111011111111110001111111001011111101011111111100110111111111110001001111110100111100110111111100101111010010111111000111111111110001101111110101110011011111111111000110111101001111110010111111001011011111110100111100110111111111110001011101100011111110111111111001110111111111110001111110111111101011111111110001111110111111100111111111110001111011111110111111110100111111111100010011111101001100111111111100011101111111111010111110111111101011111011111101001111001111111111000100111111010011001111111111000111111011111111110001110011111011111110011111110010111110111111000111011111111111000111111110101111011101111111111100011111111101111111010111111110001100111111111100011111111111000111111111110001111111101011110100111111101011111111110001001111110110111111011011010011111110001111111001111111111100011111101111110100111111111100011111111010111101110111111111110001111111011011110111111110000011111110011101";
            String decoded = decode(encoded, codebook);
			String outputString = decoded.replaceAll(" {2}", " yab"); // replace consecutive spaces
			System.out.println(outputString);
			//  System.out.println(decoded);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

