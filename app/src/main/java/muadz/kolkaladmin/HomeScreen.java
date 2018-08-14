package muadz.kolkaladmin;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Map;

import muadz.kolkaladmin.Utils.ApiUtils;
import muadz.kolkaladmin.Utils.AuthService;
import muadz.kolkaladmin.Utils.SessionManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class HomeScreen extends AppCompatActivity implements OnClickListener{

    Button btRefresh;
    SessionManager sessionManager;
//    private ListView listView;
//    private String names[] = {
//            "HTML",
//            "CSS",
//            "Java Script",
//            "Wordpress"
//    };
//
//    private String desc[] = {
//            "The Powerful Hypter Text Markup Language 5",
//            "Cascading Style Sheets",
//            "Code with Java Script",
//            "Manage your content with Wordpress"
//    };


//    private String imageid[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        sessionManager = new SessionManager(this);
        btRefresh  = (Button) findViewById(R.id.btRefresh);
        btRefresh.setOnClickListener(this);


//        ListPsn listPsn = new ListPsn(this, names, desc, imageid);
//
//        listView = (ListView) findViewById(R.id.lvCart);
//        listView.setAdapter(listPsn);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),"You Clicked "+names[i],Toast.LENGTH_SHORT).show();
//            }
//        });



    }

    public void getPesanan(){
        Map<String, Object> jsonParams = new ArrayMap<>();
        AuthService mAuthAPIService = new ApiUtils().getAuthAPIService();

        String stringStatus = "belum";
        Call<ResponseBody> response = mAuthAPIService.pesananGet(stringStatus);

        response.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {
                if (rawResponse.isSuccessful()) {
                    try {

                        JSONObject jsonObject = new JSONObject(rawResponse.body().string());
//                        status = jsonObject.getBoolean("status");
//                        message = jsonObject.getString("message");
//                        if (!status){
//                            Toast.makeText(LoginKodePetugas.this, message,
//                                    Toast.LENGTH_LONG).show();
//                            progressDialog.dismiss();
//                        } else {
//                            username = jsonObject.getString("username");


                            new CountDownTimer(5000, 5000) {

                                public void onTick(long millisUntilFinished) {
                                    // You don't need anything here
                                }

                                public void onFinish() {

                                    Intent movea = new Intent(HomeScreen.this, HomeScreen.class);
                                    startActivity(movea);
                                    finish();
                                }
                            }.start();
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(HomeScreen.this, "Gagal Menyambung ke Server",
                            Toast.LENGTH_LONG).show();
//                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
