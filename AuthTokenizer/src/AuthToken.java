import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60 * 1000;
    private String token;
    private long createTime;

    public AuthToken(String token, long createTime){

    }

    public AuthToken(String token,long createTime,long expiredTimeInterval){

    }

    public static AuthToken generate(String originalUrl, String appId, String password, long timestamp) {
        return new AuthToken(originalUrl,timestamp);
    }

    public String getToken(){
        return this.token;
    }

    public boolean isExpired(){
        return createTime + DEFAULT_EXPIRED_TIME_INTERVAL < LocalDateTime.now().getSecond();
    }

    public boolean match(AuthToken authToken){
        return true;
    }
}
