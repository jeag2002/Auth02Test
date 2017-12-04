package es.caravelloclientoauth2;

//https://github.com/spring-projects/spring-security-oauth/tree/master/spring-security-oauth2/src
//http://websystique.com/spring-security/secure-spring-rest-api-using-oauth2/
//https://github.com/tinmegali/Using-Spring-Oauth2-to-secure-REST

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;


import es.caravelloclientoauth2.model.AccountRequest;
import es.caravelloclientoauth2.model.AuthTokenInfo;
import es.caravelloclientoauth2.model.User;
 

public class SpringRestClient {
  
    public static final String REST_SERVICE_URI = "http://localhost:8081";
     
    public static final String AUTH_SERVER_URI = "http://localhost:8081/oauth/token";
     
    public static final String QPM_PASSWORD_GRANT = "grant_type=password&username=%s&password=%s";
    
    public static final String QPM_REFRESH_TOKEN = "grant_type=refresh_token&jti=%s&refresh_token=%s";
     
    public static final String QPM_ACCESS_TOKEN = "?access_token=";
 
    
    private static  Map<String, String> getBasicAuthorizationHeader(String key, String secret) { 
    	  Map<String, String> headers = new HashMap<String, String>(); 
    	  String auth = key+":"+secret; 
    	  byte[] encodedAuth = Base64.encodeBase64(auth.getBytes()); 
    	  String authHeader = "Basic " + new String(encodedAuth); 
    	  headers.put("Authorization", authHeader); 
    	  headers.put("Accept","*/*");
    	  return headers; 
    } 
	
     //Prepare HTTP Headers.
    
    private static HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
     
    
    /*
     curl trusted-app:secret@localhost:8081/oauth/token -d "grant_type=password&username=user&password=password" | jq-win64
     */
    @SuppressWarnings({ "unchecked"})
    private static AuthTokenInfo sendTokenRequest(String username, String password) throws Exception{
    	AuthTokenInfo tokenInfo = new AuthTokenInfo();
    	
    	System.out.println("\nTesting POST oauth/token SEND TOKEN API-----------");
    	
    	OAuthClient client = new OAuthClient(new URLConnectionClient());
    	
    	 OAuthClientRequest request =
                 OAuthClientRequest.tokenLocation(AUTH_SERVER_URI)
                 .buildQueryMessage();
    	 
    	 String body = String.format(QPM_PASSWORD_GRANT, username, password);
    	 request.setBody(body);
    	 
    	 Map<String, String> headers = getBasicAuthorizationHeader("trusted-app", "secret");
    	 request.setHeaders(headers);
    	 OAuthJSONAccessTokenResponse data = client.accessToken(request, OAuthJSONAccessTokenResponse.class);
    	 
    	 if (data!=null){
    		 tokenInfo.setAccess_token(data.getAccessToken());
             tokenInfo.setToken_type("");
             tokenInfo.setRefresh_token(data.getRefreshToken());
             tokenInfo.setExpires_in(data.getExpiresIn().intValue());
             tokenInfo.setScope(data.getScope());
             tokenInfo.setJti(data.getParam("jti"));
            
             System.out.println("TOKEN CREATED ("+username+"): "+tokenInfo);
    	 }
    	 return tokenInfo;	
    }
    
    /*
     curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=refresh_token&jti=[JTI]&refresh_token=[REFRESH_TOKEN]" 
     */
     
    private static AuthTokenInfo resendTokenRequest(AuthTokenInfo info) throws Exception{
    	AuthTokenInfo tokenInfo = new AuthTokenInfo();
    	
    	System.out.println("\nTesting POST oauth/token RESEND TOKEN API-----------");
    	
    	OAuthClient client = new OAuthClient(new URLConnectionClient());
    	
	   	 OAuthClientRequest request =
	                OAuthClientRequest.tokenLocation(AUTH_SERVER_URI)
	                .buildQueryMessage();
	   	
	   	 String body = String.format(QPM_REFRESH_TOKEN, info.getJti(),info.getRefresh_token());
	   	 request.setBody(body);
	   	 
	   	 Map<String, String> headers = getBasicAuthorizationHeader("trusted-app", "secret");
	   	 request.setHeaders(headers);
	   	 OAuthJSONAccessTokenResponse data = client.accessToken(request, OAuthJSONAccessTokenResponse.class);
	   	 
	   	 if (data!=null){
	   		 tokenInfo.setAccess_token(data.getAccessToken());
	            tokenInfo.setToken_type("");
	            tokenInfo.setRefresh_token(data.getRefreshToken());
	            tokenInfo.setExpires_in(data.getExpiresIn().intValue());
	            tokenInfo.setScope(data.getScope());
	            tokenInfo.setJti(data.getParam("jti"));
	           
	            System.out.println("TOKEN REFRESH (username): " + tokenInfo);
	   	 }
    
    	return tokenInfo;
    }
    
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void hello(AuthTokenInfo tokenInfo){
        Assert.notNull(tokenInfo, "Authenticate first please......");
 
        System.out.println("\nTesting GET api/hello API-----------");
        RestTemplate restTemplate = new RestTemplate(); 
         
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URI+"/api/hello"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
                HttpMethod.GET, request, String.class);
        String responseStr = (String)response.getBody();
        System.out.println("Response: " + responseStr);
    }
    
    
    private static void helloAdmin(AuthTokenInfo tokenInfo){
        Assert.notNull(tokenInfo, "Authenticate first please......");
 
        System.out.println("\nTesting GET api/admin API-----------");
        RestTemplate restTemplate = new RestTemplate(); 
         
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URI+"/api/admin"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
                HttpMethod.GET, request, String.class);
        String responseStr = (String)response.getBody();
        System.out.println("Response: " + responseStr);
    }
    
    private static void createUser(AuthTokenInfo tokenInfo) {
        Assert.notNull(tokenInfo, "Authenticate first please......");
        
        System.out.println("\nTesting POST create User username:prueba; lastname:lastname; password:password; role:user API----------");
        RestTemplate restTemplate = new RestTemplate();
        AccountRequest account = new AccountRequest();
        account.setId(15L);
        account.setUsername("prueba");
        account.setFirstName("firstname");
        account.setLastName("lastname");
        account.setPassword("password");
        account.setEmail("prueba@prueba.com");
        
        account.grantAuthority(es.caravelloclientoauth2.model.Role.ROLE_USER);
        
        HttpEntity<Object> request = new HttpEntity<Object>(account, getHeaders());
        ResponseEntity<AccountRequest> response = restTemplate.postForEntity(REST_SERVICE_URI+"/api/account/register"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
                request, AccountRequest.class);
        System.out.println("Response (201): "+ response.getStatusCode());
    }
    
    
    private static void deleteUser(AuthTokenInfo tokenInfo) {
        Assert.notNull(tokenInfo, "Authenticate first please......");
        
        System.out.println("\nTesting DELETE User username:prueba API----------");
      
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<String> response = restTemplate.exchange(REST_SERVICE_URI+"/api/account/remove"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
                HttpMethod.DELETE, request, String.class);
        
        System.out.println("Response (200): "+ response.getStatusCode());
    }
    
  
    public static void main(String args[]) throws Exception{
        AuthTokenInfo tokenInfo = sendTokenRequest("user", "password");
        tokenInfo = resendTokenRequest(tokenInfo);
        AuthTokenInfo tokenInfoAdmin = sendTokenRequest("admin", "password");
        hello(tokenInfo);
        helloAdmin(tokenInfoAdmin);
        createUser(tokenInfo);
        AuthTokenInfo tokenInfoPrueba = sendTokenRequest("prueba", "password");
        hello(tokenInfoPrueba);
        deleteUser(tokenInfoPrueba);
    }
}