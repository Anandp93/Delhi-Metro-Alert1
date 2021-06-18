package in.ultimates.metroalert;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {
	Button btn;
	boolean st;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			startActivity(new Intent(v.getContext(),Menu_option.class));
				finish();
			
			}
		});
		new back().execute();
	}
  class back extends AsyncTask<Void, Void, Void>
{

	@Override
	protected Void doInBackground(Void...params) {
	try
	{
		Thread.sleep(3000);
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}
	return null;
		
	}

	@Override
	protected void onPostExecute(Void result) {
		if(st)
		{	
		startActivity(new Intent(Home.this,Menu_option.class));
		}
		super.onPostExecute(result);
	}
	
	
}

	protected void onPause() {
		st=false;
		super.onPause();
	}


	@Override
	protected void onResume() {
		st=true;
		super.onResume();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
