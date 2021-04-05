

public class DefaultApiAuthencatorImpl implements ApiAuthencator{
    private CredentialStorage credentialStorage;
    public DefaultApiAuthencatorImpl() {
    }

    public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage){
        this.credentialStorage = credentialStorage;
    }
    @Override
    public void auth(String url) {
        apiRequest request = apiRequest.buildFromUrl(url);
        auth(request);
    }

    @Override
    public void auth(apiRequest request) {
        String appId = request.getAppId();
        String token = request.getToken();
        long timestamp = request.getTimestamp();
        String originalUrl = request.getOriginalUrl();
        AuthToken clientAuthToken = new AuthToken(token,timestamp);
        if(clientAuthToken.isExpired()){
            throw new RuntimeException("Token is Expired.");
        }

        String password = CredentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.generate(originalUrl,appId,password,timestamp);
        if(!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("Token verification failed.");
        }
    }
}
