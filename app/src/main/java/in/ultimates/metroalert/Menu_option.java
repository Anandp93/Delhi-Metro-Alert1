package in.ultimates.metroalert;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Menu_option extends Activity {
	Button btn1,btn2,btn3,btn4,btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_option);
		btn1=(Button)findViewById(R.id.button1);
		btn2=(Button)findViewById(R.id.button2);
		btn3=(Button)findViewById(R.id.button3);
		btn4=(Button)findViewById(R.id.button4);
		btn5=(Button)findViewById(R.id.button7);
		
		btn1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v1) {
		Intent i=new Intent(v1.getContext(),Map_initial.class);
	
		startActivity(i);
		
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v2) {
Intent i=new Intent(v2.getContext(),Fareroute.class);
			
				
				startActivity(i);
			
							
				
			}
		});
		btn3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v3) {
	
				Intent i=new Intent(v3.getContext(),Map_image.class);
			
				
				startActivity(i);
							
			}
		});
		btn4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v4) {
			
				startActivity(new Intent(v4.getContext(),Gps1.class));
			}
		});
		btn5.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v5) {
				
				startActivity(new Intent(v5.getContext(),About_us.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
		return true;
	}

}
