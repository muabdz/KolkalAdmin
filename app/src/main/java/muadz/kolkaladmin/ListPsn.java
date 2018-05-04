package muadz.kolkaladmin;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListPsn extends ArrayAdapter<String> {
    private String[] rasas;
    private String[] kets;
    private Activity context;
    private String[] jum;

    public ListPsn(Activity context, String[] rasas, String[] kets, String[] jum) {
        super(context, R.layout.detailpsn, rasas);
        this.context = context;
        this.rasas = rasas;
        this.kets = kets;
        this.jum = jum;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.detailpsn, null, true);
        TextView tvNama = (TextView) listViewItem.findViewById(R.id.tvNama);
        TextView tvKet = (TextView) listViewItem.findViewById(R.id.tvKet);
        TextView tvJum = (TextView) listViewItem.findViewById(R.id.tvJum);
        //if (PreferenceManager.getDefaultSharedPreferences(context).getInt(rasas[position],0)!=0){
        tvNama.setText(rasas[position]);
        tvKet.setText(kets[position]);
        tvJum.setText(jum[position]);
        /*}else{
            listViewItem.setVisibility(View.GONE);
        }*/
        return  listViewItem;
    }
}
