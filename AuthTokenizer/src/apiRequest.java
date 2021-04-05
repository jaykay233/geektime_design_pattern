public class apiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public apiRequest(String baseUrl, String token, String appId, long timestamp){
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }


    public static apiRequest buildFromUrl(String url) {
        return new apiRequest(url,"xxx","xxx", 0);
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public String getToken(){
        return this.token;
    }

    public String getAppId(){
        return this.appId;
    }

    public long getTimestamp(){
        return this.timestamp;
    }

    public String getOriginalUrl() {
        return this.baseUrl;
    }
}
