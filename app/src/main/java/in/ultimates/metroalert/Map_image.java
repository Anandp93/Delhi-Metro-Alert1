package in.ultimates.metroalert;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class Map_image extends Activity {
ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_image);
		
		img=(ImageView)findViewById(R.id.imageView1);
		img.setImageResource(R.drawable.maop);
		
	img.setOnTouchListener(new Touch());  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity6, menu);
		return true;
	}

}
