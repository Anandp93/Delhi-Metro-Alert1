package in.ultimates.metroalert;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class About_us extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_about_us, menu);
		return true;
	}

}
