import java.util.HashMap;
import java.util.Random;

public class EncodeAndDecodeTinyURL {

    private final String BASEURL = "http://tinyurl.com/";

    private final int KEYLENGTH = 6;

    private final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private HashMap<String, String> longToShort;

    private HashMap<String, String> shortToLong;

    private Random random;

    public EncodeAndDecodeTinyURL() {
        longToShort = new HashMap<>();
        shortToLong = new HashMap<>();
        random = new Random();
    }

    private String generateUniqueKey () {
        String shortKey = "";

        do {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < KEYLENGTH; i++) {
                int randomIndex = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(randomIndex));
            }
            shortKey = sb.toString();
        } while (shortToLong.containsKey(shortKey));

        return shortKey;
    }

    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)) {
            String existingKey = longToShort.get(longUrl);
            return BASEURL + existingKey;
        }

        String shortKey = generateUniqueKey();

        longToShort.put(longUrl, shortKey);
        shortToLong.put(shortKey, longUrl);

        return BASEURL + shortKey;
    }


    public String decode(String shortUrl) {
        String shortKey = shortUrl.substring(BASEURL.length());
        return shortToLong.get(shortKey);
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL codec = new EncodeAndDecodeTinyURL();

        String longUrl = "https://www.example.com/some/very/long/url";
        String shortUrl = codec.encode(longUrl);
        System.out.println("Short URL: " + shortUrl);

        String decodedUrl = codec.decode(shortUrl);
        System.out.println("Decoded URL: " + decodedUrl);
    }
}
