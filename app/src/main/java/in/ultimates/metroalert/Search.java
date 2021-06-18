package in.ultimates.metroalert;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

public class Search extends ListActivity {
	Button btn;
	private ArrayList<UpdateItem> m_orders = null;
	private OrderAdapter m_adapter;
	private Runnable viewOrders;
	ProgressDialog progress;
	private String location,key;
	private String APIKEY = "AIzaSyB-pdV6q1DsRWGYPrrCoHcXlfRYu4hBiMs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		location = getIntent().getExtras().getString("location");
		key = getIntent().getExtras().getString("key");
			
		
		m_orders = new ArrayList<UpdateItem>();
		
        this.m_adapter = new OrderAdapter(this, R.layout.row, m_orders,key);
        
        setListAdapter(this.m_adapter);
        progress = new ProgressDialog(this);
        progress.setMessage("Please wait.....");
        progress.show();
        
        viewOrders = new Runnable(){
            public void run() {
            	
            	getOrders();
            	
    			progress.dismiss();
            }
        };
        
       
     	
        Thread thread =  new Thread(null, viewOrders, "MagentoBackground");
        thread.start();
        
		
	}
	
	 private void getOrders(){
         try{
        	 
             
        	 ReadXMLFile read = new ReadXMLFile();
          	m_orders = read.ReadXML("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location="+location+"&radius=1500&name="+key+"&sensor=false&key="+APIKEY, "");
            
             
             
          
             Log.i("ARRAY", ""+ m_orders.size());
           } catch (Exception e) {
             Log.e("BACKGROUND_PROC", e.getMessage());
           }
           runOnUiThread(returnRes);
       }

	 private Runnable returnRes = new Runnable() {

	        public void run() {
	            if(m_orders != null && m_orders.size() > 0){
	                m_adapter.notifyDataSetChanged();
	                for(int i=0;i<m_orders.size();i++)
	                m_adapter.add(m_orders.get(i));
	            }
	            
	            m_adapter.notifyDataSetChanged();
	        }
	    };
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_search, menu);
		return true;
	}

}
