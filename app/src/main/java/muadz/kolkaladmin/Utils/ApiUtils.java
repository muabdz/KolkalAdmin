package muadz.kolkaladmin.Utils;

/**
 * Created by Mu'adz on 8/7/2018.
 */

public class ApiUtils {
    static SessionManager sessionManager;
    static String hostPort;
    static String hostIp;
    //private static String BASE_URL = "http://"+ hostIp + ":" + hostPort + "/";
    //public static final String BASE_URL = "http://45.77.246.7:8080/";

    public ApiUtils(){
//        sessionManager = new SessionManager(QRCode.getAppContext());
//        this.hostPort = sessionManager.getHostPort();
//        this.hostIp = sessionManager.getHostIp();
    }

    public static AuthService getAuthAPIService() {
        String BASE_URL = "http://"+ hostIp + ":" + hostPort + "/";
        return RetrofitClient.getClient(BASE_URL).create(AuthService.class);
    }
}
