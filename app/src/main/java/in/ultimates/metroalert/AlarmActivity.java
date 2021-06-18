package in.ultimates.metroalert;


import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class AlarmActivity extends Activity {
	boolean continous = false;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		btn = (Button)findViewById(R.id.button1);
		
		btn.setText("You can relax!");
		btn.setText("Alert!");
		
	btn.setEnabled(false);
		continous=true;
		new back().execute();
		
		Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
		final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), alert);
		r.play();
		
		
		AlertDialog.Builder build = new AlertDialog.Builder(AlarmActivity.this);
		build.setTitle("Alert!");
		build.setMessage("You are going to reach your destination!");
		build.setCancelable(false);
		build.setPositiveButton("Ok!", new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int which) {
				continous = false;
				r.stop();
				finish();
			}
		});
		
		build.show();
		
		

		
		btn.setOnClickListener(new View .OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				btn.setText("Alert!");
				
				
				
				continous=true;
				new back().execute();
				
				Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
				final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), alert);
				r.play();
				
				
				AlertDialog.Builder build = new AlertDialog.Builder(AlarmActivity.this);
				
				build.setMessage("You are going to reach your destination!");
				build.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						continous = false;
						r.stop();
						
					}
				});
				
				build.show();
			}
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_alarm, menu);
		return true;
	}
	class back extends AsyncTask<Void, Void, Void>{

		@Override
		protected void onProgressUpdate(Void... values) {
			
			final Vibrator v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			v1.vibrate(300);
			
			super.onProgressUpdate(values);
		}

		@Override
		protected Void doInBackground(Void... params) {
			while(continous){
				publishProgress();
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
	}
}
