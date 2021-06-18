package in.ultimates.metroalert;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.location.Location;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.util.FloatMath;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Mao_final extends FragmentActivity {
	GoogleMap maps;

	MarkerOptions marker;
	double lat1,lon1;
	double lat2;
	double lon2;
	boolean continous = false;
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_final);

		lat1 = getIntent().getExtras().getDouble("lat1");
	 	lon1 = getIntent().getExtras().getDouble("lon1");
	 	
		lat2 = getIntent().getExtras().getDouble("lat2");
		lon2 = getIntent().getExtras().getDouble("lon2");
		
		maps=((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1)).getMap();
		//
		
		//
		
		maps.setMyLocationEnabled(true);
		
		
		marker=new MarkerOptions();
		marker.position(new LatLng(lat1,lon1));
		maps.addMarker(marker);
		
		
		MarkerOptions marker1=new MarkerOptions();
		marker1.position(new LatLng(lat2,lon2));
		maps.addMarker(marker1);
		
		
		
		maps.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat2,lon2),15));
		
	
		maps.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
			
			public void onMyLocationChange(Location location) {
				double current_lat = location.getLatitude();
				double current_lon = location.getLongitude();
				double distance=	gps2m((float)current_lat, (float)current_lon, (float)lat2, (float)lon2);
					
				
				
				
			}
		});
		
		
		
		}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity4, menu);
		return true;
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
	

