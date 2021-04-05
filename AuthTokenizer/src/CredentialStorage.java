import java.time.LocalDateTime;

public class CredentialStorage {
    public static String getPasswordByAppId(String appId){
        return appId + "_" + LocalDateTime.now();
    }
}
