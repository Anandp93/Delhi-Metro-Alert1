package in.ultimates.metroalert;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Gps1 extends Activity implements OnItemSelectedListener{
	Spinner spinner1,spinner2;
    
    int sourcevalue=0;
	int searchvalue=0;

	LocationManager locationManager ;
	LocationListener locationListener;
	TextView txt,txt2;
	Location locations;
	CheckBox check;
	Button btn;
	
	EditText edit;
	String[] values1 = {"Select Station", "AIIMS", "Adarsh Nagar", "Akshardham",
			"Anand Vihar ISBT", "Arjan Garh", "Ashok Park Main", "Azadpur",
			"Badarpur", "Barakhamba", "Botanical Garden",
			"Central Secretariat", "Chandi Chowk", "Chawri Bazar",
			"Chhattarpur", "Civil Lines", "Dilshad Garden", "Dwarka Mor",
			"Dwarka", "Dwarka Sector-10", "Dwarka Sector-11",
			"Dwarka Sector-12", "Dwarka Sector-13", "Dwarka Sector-14",
			"Dwarka Sector-21", "Dwarka Sector-8", "Dwarka Sector-9",
			"GTB Nagar", "Ghitorni", "Golf Course", "Govindpuri", "Green Park",
			"Gurudonacharya", "Hauz Khas", "Huda City Center", "IFFCO Chowk",
			"INA", "Inder Lok", "Indraprasta", "JLN Stadium", "Jahangirpuri",
			"Janakpuri East", "Janakpuri West", "Jangpura", "Jasola Apollo",
			"Jhandewalan", "Jhil Mil", "Jorbagh", "Kailash Colony",
			"Kalkaji Mandir", "Kanhaiya Nagar", "Karkar Duma", "Karol Bagh",
			"Kashmere Gate", "Kaushambi", "Kesham Puram", "Khan Market",
			"Kirti Nagar", "Kohat Enclave", "Lajpat Nagar", "Laxmi Nagar",
			"Madi Pur", "Malviya Nagar", "Mandi House", "Mansrover Park",
			"Mayur Vihar-I", "Mayur Vihar-I Ext", "MG Road", "Model Town",
			"Mohan Estate", "Moolchand", "Moti Nagar", "Mundka", "Nangloi", "Nangloi Rly.Station",
			"Nawada", "Nehru Palce", "Netaji Subhash Place", "New Ashok Nagar",
			"New Delhi", "Nirman Vihar", "Noida City Center",
			"Noida Sec 15", "Noida Sec 16", "Noida Sec 18", "Okhla",
			"Paschim Vihar(East)", "Paschim Vihar(West)", "Punjabi Bag",
			"Patel  Chowk", "Patel Nagar", "Peera Garhi", "Pitam Pura",
			"Pragti Maidan", "Pratap Nagar", "Preet Vihar", "Pul  Bangash",
			"Qutab Minar", "Race Course", "Rajdhani Park", "Rajiv  Chowk",
			"Ramesh Nagar", "Rajouri Garden", "Rithala", "Rajendra Place",
			"Rk Ashram Marg", "Rohini East", "Rohini West", "Saket",
			"Seelampur", "Sarita Vihar", "Satguru Ram Singh Marg",
			"Shadi Pur", "Shahdara", "Shastri Nagar", "Shastri Park",
			"Shivaji Park", "Sikandarpur", "Subhash Nagar", "Sultanpur",
			"Surajmal Stadium", "Tagore Garden", "Tilak Nagar", "Tis Hazari",
			"Tuglakabad", "Udyog Bhawan", "Udyog Nagar", "Utam Nagar West",
			"Uttam Nagar East", "Vaishali", "Vidhan Sabha", "Vishwavidyalaya",
			"Welcome", "Yamuna Bank" };

	
	String[] values2={"Select Keyword","ATM" ,"College","Hospital","Hotel","Mall","Restaurant","School"};
	
	double[] lat = {0, 28.567675, 28.716429, 28.61798, 28.646607, 28.481197,
			28.67148, 28.706473, 28.493078, 28.629733, 28.564095, 28.614439,
			28.657905, 28.649319, 28.506712, 28.676714, 28.675754, 28.619638,
			28.615023, 28.581092, 28.586331, 28.592266, 28.597258, 28.602307,
			28.552391, 28.565904, 28.574309, 28.697703, 28.494342, 28.567134,
			28.544682, 28.560062, 28.482102, 28.543268, 28.459278, 28.472124,
			28.575176, 28.673288, 28.62058, 28.590457, 28.72595, 28.633142,
			28.629865, 28.58358, 28.538386, 28.643839, 28.675829, 28.587084,
			28.555143, 28.549526, 28.682569, 28.648453, 28.644065, 28.667564,
			28.644969, 28.689308, 28.602797, 28.655684, 28.69806, 28.570785,
			28.630411, 28.676394, 28.528281, 28.625194, 28.625194, 28.605321,
			28.594395, 28.479518, 28.703236, 28.519835, 28.564396, 28.657811,
			28.682531, 28.682362,28.68206, 28.620241, 28.551561, 28.693562, 28.589081,
			28.642992, 28.636702, 28.575025, 28.585087, 28.577795, 28.570804,
			28.543042, 28.6779, 28.678182, 28.673419, 28.623217, 28.64495,
			28.679764, 28.703236, 28.623405, 28.667094, 28.641749, 28.665889,
			28.512972, 28.597522, 28.681816, 28.633274, 28.652313, 28.649263,
			28.720738, 28.642747, 28.638773, 28.707659, 28.714302, 28.520571,
			28.669447, 28.528696, 28.669447, 28.651579, 28.673194, 28.669955,
			28.673438, 28.675208, 28.481234, 28.639997, 28.498887, 28.684112,
			28.64382, 28.636551, 28.667037, 28.502696, 28.611651, 28.681307,
			28.621521, 28.62478, 28.649846, 28.687915, 28.694823,28.671744, 28.62333 };
	
	
	
	double[] longi = {0, 77.208116, 77.170436, 77.279334, 77.316198, 77.125525,
			77.155201, 77.180479, 77.302551, 77.224789, 77.334223, 77.211528,
			77.230153, 77.225733, 77.174835, 77.224703, 77.321348, 77.033193,
			77.0227, 77.057333, 77.049737, 77.040617, 77.033129, 77.025661,
			77.057676, 77.066989, 77.065187, 77.207022, 77.149193, 77.345955,
			77.264056, 77.20685, 77.102265, 77.206721, 77.072589, 77.072654,
			77.209339, 77.170157, 77.249765, 77.233093, 77.162583, 77.086902,
			77.077353, 77.23835, 77.283046, 77.199447, 77.312443, 77.212601,
			77.242019, 77.258928, 77.164063, 77.305834, 77.188654, 77.228093,
			77.324352, 77.161102, 77.228179, 77.150545, 77.140245, 77.236505,
			77.277832, 77.119603, 77.205863, 77.234423, 77.234423, 77.288904,
			77.294483, 77.080164, 77.19389, 77.294312, 77.234166, 77.14252,
			77.030511, 77.064757, 77.05611,77.044973, 77.251503, 77.151854, 77.301822,
			77.221785, 77.286737, 77.355423, 77.311499, 77.318108, 77.326176,
			77.274871, 77.1122, 77.102244, 77.145824, 77.214468, 77.169213,
			77.092738, 77.132092, 77.24247, 77.198009, 77.295299, 77.206421,
			77.186594, 77.211099, 77.043707, 77.221012, 77.131598, 77.122629,
			77.107179, 77.177968, 77.208138, 77.125955, 77.115505, 77.201314,
			77.26676, 77.288046, 77.26676, 77.158141, 77.289848, 77.18153,
			77.241547, 77.130461, 77.093146, 77.104883, 77.161446, 77.073641,
			77.112179, 77.096429, 77.216463, 77.299182, 77.212365, 77.080615,
			77.056067, 77.065294, 77.339737, 77.22142, 77.214575,77.277575, 77.267962 };
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gps1);
		spinner1=(Spinner)findViewById(R.id.spinner1);
		spinner2=(Spinner)findViewById(R.id.spinner2);
		spinner1.setOnItemSelectedListener(this);
		spinner2.setOnItemSelectedListener(this);
		btn=(Button)findViewById(R.id.button1);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,values1);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,values2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);
		
		spinner2.setAdapter(adapter2);
		txt = (TextView)findViewById(R.id.textView6);
		txt.setVisibility(View.INVISIBLE);
		txt2=(TextView)findViewById(R.id.textView7);
		check = (CheckBox)findViewById(R.id.checkBox1);
		btn = (Button)findViewById(R.id.button1);
		
		
		check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if(arg1){
					
					btn.setEnabled(false);
					
		              txt.setVisibility(View.VISIBLE);
		              
		              txt.setText("Please wait.....");
		              
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
				}else{
					Log.i("MO", "false");
					
					btn.setEnabled(true);
					txt.setVisibility(View.INVISIBLE);
				}
				if(check.isChecked() && spinner2.getSelectedItemPosition()==0)
				{
					Toast.makeText(arg0.getContext(),"Please select the keyword",Toast.LENGTH_LONG).show();
					
				}
				
			}
		});
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		
		
		
		
	       locationListener = new LocationListener() {
	            public void onLocationChanged(Location location) {
	            	
	              locations = location;
	              
	              txt.setText(String.valueOf(location.getLatitude())+","+String.valueOf(location.getLongitude()));
	              txt.setVisibility(View.VISIBLE);
	              btn.setEnabled(true);
	         Toast.makeText(Gps1.this,"New Location detected"	,Toast.LENGTH_SHORT).show();
	            }

	            public void onStatusChanged(String provider, int status, Bundle extras) {
	            	
	            	
	            }

	            public void onProviderEnabled(String provider) {}

	            public void onProviderDisabled(String provider) {
	            	 Toast.makeText(Gps1.this,"GPS/Wireless network is not enabled"	,Toast.LENGTH_LONG).show();
	            	
	            	
	            }
	          };
	
	          btn.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					if(spinner1.getSelectedItemPosition()==0)
					{Toast.makeText(v.getContext(),"Please select the Station",Toast.LENGTH_LONG).show();}
					else if(spinner2.getSelectedItemPosition()==0)
					{
						Toast.makeText(v.getContext(),"Please select the Search Keyword",Toast.LENGTH_LONG).show();
					}
					
					else if(check.isChecked()){
						Intent i = new Intent(v.getContext(), Search.class);
						
						i.putExtra("location", String.valueOf(locations.getLatitude())+","+String.valueOf(locations.getLongitude()));
						String item=spinner2.getSelectedItem().toString();
						i.putExtra("key", item);
						startActivity(i);
					}
					else{
						Intent i = new Intent(v.getContext(), Search.class);
						String s=String.valueOf(lat[sourcevalue]).toString()+","+String.valueOf(+longi[sourcevalue]).toString()+"";
						Toast.makeText(Gps1.this,s,Toast.LENGTH_SHORT).show();

						i.putExtra("location",s);
						String item=spinner2.getSelectedItem().toString();
						i.putExtra("key", item);
						startActivity(i);
					}
					
				}
			});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity7, menu);
		return true;
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		sourcevalue=spinner1.getSelectedItemPosition();
		searchvalue=spinner2.getSelectedItemPosition();
		if(spinner1.getSelectedItemPosition()!=0)
		{
			check.setVisibility(View.INVISIBLE);
		}
		else
		{
			check.setVisibility(View.VISIBLE);
		}
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
