package muadz.kolkaladmin.Utils;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Mu'adz on 8/7/2018.
 */

public interface AuthService {
    @GET("/pesanan/{status}/")
    Call<ResponseBody> pesananGet(@Path("status") String status);

    @POST("/submitpesanan/{id}/")
    Call<ResponseBody> pesananPost(@Path("id") String id);
}
