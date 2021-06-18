package in.ultimates.metroalert;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class OrderAdapter extends ArrayAdapter<UpdateItem> {
	ArrayList<UpdateItem> items;
	Context context;
	String key;
	
	public OrderAdapter(Context context, int textViewResourceId,ArrayList<UpdateItem> items,String key) {
		super(context, textViewResourceId,items);
         this.items = items;
         this.context = context;
         this.key = key;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row, null);
        }
        UpdateItem o = items.get(position);
        if (o != null) {
                TextView tt = (TextView) v.findViewById(R.id.subject);
                TextView bt = (TextView) v.findViewById(R.id.subsubject);
                
                
                ImageView ii = (ImageView) v.findViewById(R.id.imageView1);
                
                
                TextView location =(TextView)v.findViewById(R.id.location);
                if (tt != null) {
                      tt.setText(o.getName());                            }
                if(bt != null){
                      bt.setText(o.getVicinity());
                }
                if(ii != null){
                
                	if(key.equals("atm")){
                    ii.setImageResource(R.drawable.atm);
                	}else if(key.equals("hotel")){
                		ii.setImageResource(R.drawable.hotel);
                	}else if(key.equals("hospital")){
                		ii.setImageResource(R.drawable.hospital);
                	}else if(key.equals("bank")){
                		ii.setImageResource(R.drawable.bank);
                	}else if(key.equals("restaurant")){
                		ii.setImageResource(R.drawable.restaurant);
                	}
                	
                	else{
                		ii.setImageResource(android.R.drawable.star_big_on);
                	}
              }
                if(location!=null){
                	location.setText(o.getlat()+","+o.getlng());
                }
                
        }
		return v;
	}
	
	

}
