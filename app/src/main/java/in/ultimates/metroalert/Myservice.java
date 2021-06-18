package in.ultimates.metroalert;

import java.util.Calendar;

import com.google.android.gms.maps.GoogleMap;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.FloatMath;
import android.util.Log;
import android.widget.Toast;





public class Myservice extends Service{
LocationManager locmanager;

double lat2,lon2 ;
	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}

	@Override
	public void onCreate() {
		Log.i("MO", "Service Created");
		
		super.onCreate();
		
	}

	@Override
	public void onDestroy() {
		Log.i("MO", "Service Destroy");
		locmanager.removeUpdates(listener);
		super.onDestroy();
	}

	
	LocationListener listener = new LocationListener() {
		
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		public void onLocationChanged(Location location) {
			double distance=	gps2m((float)location.getLatitude(), (float)location.getLongitude(), (float)lat2, (float)lon2);
			Toast.makeText(Myservice.this, "Distance: "+String.valueOf(Math.round(distance)/1000+" KM"), Toast.LENGTH_SHORT).show();
			//notification
	if(distance<1000.0)
		{
		Intent i1=new Intent(Myservice.this,Myservice.class);
		stopService(i1);
		
			Calendar cal=Calendar.getInstance();
			Intent i=new Intent(Myservice.this,AlarmActivity.class);
			PendingIntent pend=PendingIntent.getActivity(Myservice.this,0,i,PendingIntent.FLAG_CANCEL_CURRENT);
			AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
			am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pend);
		}
		}
	};
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	
		Log.i("MO", "Service Started");
		lat2 = intent.getExtras().getDouble("lat2");
		lon2 = intent.getExtras().getDouble("lon2");
		locmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0, listener);
		return super.onStartCommand(intent, flags, startId);
	}

	private double gps2m(float lat_a, float lng_a, float lat_b, float lng_b) {
	    float pk = (float) (180/3.14169);

	    float a1 = lat_a / pk;
	    float a2 = lng_a / pk;
	    float b1 = lat_b / pk;
	    float b2 = lng_b / pk;

	    float t1 = FloatMath.cos(a1)*FloatMath.cos(a2)*FloatMath.cos(b1)*FloatMath.cos(b2);
	    float t2 = FloatMath.cos(a1)*FloatMath.sin(a2)*FloatMath.cos(b1)*FloatMath.sin(b2);
	    float t3 = FloatMath.sin(a1)*FloatMath.sin(b1);
	    double tt = Math.acos(t1 + t2 + t3);
	   
	    return 6366000*tt;
	}
	

}
