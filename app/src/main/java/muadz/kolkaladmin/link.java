package muadz.kolkaladmin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class link extends StringRequest {

    private static final String linkRinku = "https://kolkalgriya.000webhostapp.com/link.php";
    private Map<String, String> params;

    public link (String id_trans, String tgl_trans, String id_pro, int jumlah, int total, String id_user, String nama, String nohp, String alamat, String email, String status, Response.Listener<String> respon){
        super(Method.POST, linkRinku, respon, null);
        params = new HashMap<>();
        params.put("id_trans", id_trans);
        params.put("tgl_trans", tgl_trans);
        params.put("id_pro", id_pro);
        params.put("jumlah", jumlah+"");
        params.put("total", total+"");
        params.put("id_user", id_user);
        params.put("nama", nama);
        params.put("nohp", nohp);
        params.put("alamat", alamat);
        params.put("email", email);
        params.put("status", status);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}