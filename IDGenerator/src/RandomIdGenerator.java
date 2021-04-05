import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RandomIdGenerator implements IdGenerator{

    @Override
    public String generate() {
        String substrOfHostName =getLastFieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphametric();
        String id = String.format("%s-%d-%s",substrOfHostName,currentTimeMillis,randomString);
        return id;
    }

    private String generateRandomAlphametric() {
        char[] randomChars = new char[8];
        int count = 0;
        Random random = new Random();
        while(count< 8){
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >='0' && randomAscii <='9';
            boolean isUpperCase = randomAscii>='A' && randomAscii<='Z';
            boolean isLowerCase = randomAscii >='a';
            if (isDigit || isUpperCase || isLowerCase){
                randomChars[count] = (char)(randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }

    private String getLastFieldOfHostName() {
        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            substrOfHostName = tokens[tokens.length-1];
            return substrOfHostName;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return substrOfHostName;
    }
}
