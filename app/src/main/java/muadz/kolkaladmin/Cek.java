package muadz.kolkaladmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Cek extends AppCompatActivity {

    private ListView listView;
    private String names[] = {
            "HTML",
            "CSS",
            "Java Script",
            "Wordpress"
    };

    private String desc[] = {
            "The Powerful Hypter Text Markup Language 5",
            "Cascading Style Sheets",
            "Code with Java Script",
            "Manage your content with Wordpress"
    };


    private String imageid[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek);
        ListPsn listPsn = new ListPsn(this, names, desc, imageid);

        listView = (ListView) findViewById(R.id.lvCart);
        listView.setAdapter(listPsn);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"You Clicked "+names[i],Toast.LENGTH_SHORT).show();
            }
        });


    }
}
