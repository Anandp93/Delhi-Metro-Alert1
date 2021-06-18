package in.ultimates.metroalert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Fareroute extends Activity {
	Spinner spinner1, spinner2;
	Button btn;
	TextView txt;
	String[] values1 = { "Select Source", "ADARSH NAGAR", "AIIMS",
			"AKSHARDHAM", "ANAND VIHAR", "ARJANGARH", "ASHOK PARK MAIN",
			"AZADPUR", "BADARPUR", "BARAKHAMBA", "BOTANICAL GARDEN",
			"CENTRAL SECRETARIAT", "CHANDNI CHOWK", "CHAWRI BAZAR",
			"CHHATTARPUR", "CIVIL LINES", "DILSHAD GARDEN", "DWARKA",
			"DWARKA MOR", "DWARKA SEC 10", "DWARKA SEC 11", "DWARKA SEC 12",
			"DWARKA SEC 13", "DWARKA SEC 14", "DWARKA SEC 21", "DWARKA SEC 8",
			"DWARKA SEC 9", "G.T.B. NAGAR", "GHITORNI", "GOLF COURSE",
			"GOVIND PURI", "GREEN PARK", "GURU DRONACHARYA", "HAUZ KHAS",
			"HUDA CITY CENTRE", "IFFCO CHOWK", "INA", "INDER LOK",
			"INDRAPRASTHA", "JAHANGIRPURI", "JANAK PURI EAST",
			"JANAK PURI WEST", "JANGPURA", "JASOLA APOLLO", "JHANDEWALAN",
			"JHIL MIL", "JLN STADIUM", "JORBAGH", "KAILASH COLONY",
			"KALKAJI MANDIR", "KANHAIYA NAGAR", "KARKAR DUMA", "KAROL BAGH",
			"KASHMERE GATE", "KAUSHAMBI", "KESHAV PURAM", "KHAN MARKET",
			"KIRTI NAGAR", "KOHAT ENCLAVE", "LAJPAT NAGAR", "LAXMI NAGAR",
			"M G ROAD", "MADI PUR", "MALVIYA NAGAR", "MANDI HOUSE",
			"MANSAROVAR PARK", "MAYUR VIHAR-I", "MAYUR VIHAR-I EXT",
			"MODEL TOWN", "MOHAN ESTATE", "MOOLCHAND", "MOTI NAGAR", "MUNDKA",
			"NANGLOI", "NANGLOI RLY. STATION", "NAWADA", "NEHRU PLACE",
			"NETAJI SUBHASH PLACE", "NEW ASHOK NAGAR", "NEW DELHI",
			"NIRMAN VIHAR", "NOIDA CITY CENTRE", "NOIDA SEC 15",
			"NOIDA SEC 16", "NOIDA SEC 18", "OKHLA", " VIHAR (EAST)",
			"PASCHIM VIHAR (WEST)", "PATEL CHOWK", "PATEL NAGAR",
			"PEERA GARHI", "PITAM PURA", "PRAGATI MAIDAN", "PRATAP NAGAR",
			"PREET VIHAR", "PUL BANGASH", "PUNJABI BAGH", "QUTAB MINAR",
			"RACE COURSE", "RAJDHANI PARK", "RAJENDRA PLACE", "RAJIV CHOWK",
			"RAJOURI GARDEN", "RAMESH NAGAR", "RITHALA", "RK ASHRAM MARG",
			"ROHINI EAST", "ROHINI WEST", "SAKET", "SARITA VIHAR", "SEELAMPUR",
			"SHADIPUR", "SHAHDARA", "SHASTRI NAGAR", "SHASTRI PARK",
			"SHIVAJI PARK", "SIKANDARPUR", "SUBHASH NAGAR", "SULTANPUR",
			"SURAJMAL STADIUM", "TAGORE GARDEN", "TILAK NAGAR", "TIS HAZARI",
			"TUGHLAKABAD", "UDYOG BHAWAN", "UDYOG NAGAR", "UTTAM NAGAR EAST",
			"UTTAM NAGAR WEST", "VAISHALI", "VIDHAN SABHA", "VISHWAVIDYALAYA",
			"WELCOME", "YAMUNA BANK" };

	String[] values2 = { "Select Destination", "ADARSH NAGAR", "AIIMS",
			"AKSHARDHAM", "ANAND VIHAR", "ARJANGARH", "ASHOK PARK MAIN",
			"AZADPUR", "BADARPUR", "BARAKHAMBA", "BOTANICAL GARDEN",
			"CENTRAL SECRETARIAT", "CHANDNI CHOWK", "CHAWRI BAZAR",
			"CHHATTARPUR", "CIVIL LINES", "DILSHAD GARDEN", "DWARKA",
			"DWARKA MOR", "DWARKA SEC 10", "DWARKA SEC 11", "DWARKA SEC 12",
			"DWARKA SEC 13", "DWARKA SEC 14", "DWARKA SEC 21", "DWARKA SEC 8",
			"DWARKA SEC 9", "G.T.B. NAGAR", "GHITORNI", "GOLF COURSE",
			"GOVIND PURI", "GREEN PARK", "GURU DRONACHARYA", "HAUZ KHAS",
			"HUDA CITY CENTRE", "IFFCO CHOWK", "INA", "INDER LOK",
			"INDRAPRASTHA", "JAHANGIRPURI", "JANAK PURI EAST",
			"JANAK PURI WEST", "JANGPURA", "JASOLA APOLLO", "JHANDEWALAN",
			"JHIL MIL", "JLN STADIUM", "JORBAGH", "KAILASH COLONY",
			"KALKAJI MANDIR", "KANHAIYA NAGAR", "KARKAR DUMA", "KAROL BAGH",
			"KASHMERE GATE", "KAUSHAMBI", "KESHAV PURAM", "KHAN MARKET",
			"KIRTI NAGAR", "KOHAT ENCLAVE", "LAJPAT NAGAR", "LAXMI NAGAR",
			"M G ROAD", "MADI PUR", "MALVIYA NAGAR", "MANDI HOUSE",
			"MANSAROVAR PARK", "MAYUR VIHAR-I", "MAYUR VIHAR-I EXT",
			"MODEL TOWN", "MOHAN ESTATE", "MOOLCHAND", "MOTI NAGAR", "MUNDKA",
			"NANGLOI", "NANGLOI RLY. STATION", "NAWADA", "NEHRU PLACE",
			"NETAJI SUBHASH PLACE", "NEW ASHOK NAGAR", "NEW DELHI",
			"NIRMAN VIHAR", "NOIDA CITY CENTRE", "NOIDA SEC 15",
			"NOIDA SEC 16", "NOIDA SEC 18", "OKHLA", " VIHAR (EAST)",
			"PASCHIM VIHAR (WEST)", "PATEL CHOWK", "PATEL NAGAR",
			"PEERA GARHI", "PITAM PURA", "PRAGATI MAIDAN", "PRATAP NAGAR",
			"PREET VIHAR", "PUL BANGASH", "PUNJABI BAGH", "QUTAB MINAR",
			"RACE COURSE", "RAJDHANI PARK", "RAJENDRA PLACE", "RAJIV CHOWK",
			"RAJOURI GARDEN", "RAMESH NAGAR", "RITHALA", "RK ASHRAM MARG",
			"ROHINI EAST", "ROHINI WEST", "SAKET", "SARITA VIHAR", "SEELAMPUR",
			"SHADIPUR", "SHAHDARA", "SHASTRI NAGAR", "SHASTRI PARK",
			"SHIVAJI PARK", "SIKANDARPUR", "SUBHASH NAGAR", "SULTANPUR",
			"SURAJMAL STADIUM", "TAGORE GARDEN", "TILAK NAGAR", "TIS HAZARI",
			"TUGHLAKABAD", "UDYOG BHAWAN", "UDYOG NAGAR", "UTTAM NAGAR EAST",
			"UTTAM NAGAR WEST", "VAISHALI", "VIDHAN SABHA", "VISHWAVIDYALAYA",
			"WELCOME", "YAMUNA BANK" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fareroute);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		btn = (Button) findViewById(R.id.button1);
		txt = (TextView) findViewById(R.id.textView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, values1);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, values2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner1.setAdapter(adapter);

		spinner2.setAdapter(adapter2);
		btn.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				if(spinner1.getSelectedItemPosition()==0)
				{Toast.makeText(arg0.getContext(),"Please select the Source Station",Toast.LENGTH_LONG).show();}
				else if(spinner2.getSelectedItemPosition()==0)
				{Toast.makeText(arg0.getContext(),"Please select the Destination Station",Toast.LENGTH_LONG).show();}
				else if(spinner1.getSelectedItemPosition()!=0 && spinner2.getSelectedItemPosition()!=0 &&  spinner1.getSelectedItemPosition()==spinner2.getSelectedItemPosition())
				{txt.setText("Fare:  8 INR");}
				/*String htmlCode = "";

				try {
					URL url = new URL(
							"http://www.delhitravel.org/delhimetro/run.php?q="
									+ spinner1.getSelectedItem().toString()
									+ "&T="
									+ spinner2.getSelectedItem().toString()
									+ "&Submit=SHOW+ROUTE+%26+FARE#.UXy-4aJHJgL"
									+ "");

					BufferedReader in = new BufferedReader(
							new InputStreamReader(url.openStream()));

					String inputLine;

					while ((inputLine = in.readLine()) != null)
						htmlCode += inputLine;

					in.close();
				} catch (Exception e) {
					// Log.d(LOG_TAG, "Error: " + e.getMessage());
				}
				// String html =
				// "<p>An <a href='http://com/'><b>example</b></a> link.</p>";

				// first one is image, skip it

				try {
					Document doc = Jsoup.parse(htmlCode);
					Element link = doc.select("a").first();

					String text = doc.body().text(); // "An example link"
					String linkHref = link.attr("href"); // "http://example.com/"
					String linkText = link.text(); // "example""

					String linkOuterH = link.outerHtml();
					// "<a href="http://example.com"><b>example</b></a>"
					String linkInnerH = link.html(); // "<b>example</b>"
					txt.setText(text);
					txt.setText(text.substring(text.indexOf("Fare:"),
							text.indexOf("Fare:") + 12));

				} catch (Exception e) {
					// TODO: handle exception
				}*/
				else
				{
					txt.setText("please wait...");

				new back().execute();
				}
			}
		});
	}

	
	class back extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... arg0) {
			String htmlCode = "";

			try {
				URL url = new URL(
						"http://www.delhitravel.org/delhimetro/run.php?q="
								+ spinner1.getSelectedItem().toString()
								+ "&T="
								+ spinner2.getSelectedItem().toString()
								+ "&Submit=SHOW+ROUTE+%26+FARE#.UXy-4aJHJgL"
								+ "");
				BufferedReader in = new BufferedReader(
						new InputStreamReader(url.openStream()));

				String inputLine;

				while ((inputLine = in.readLine()) != null)
					htmlCode += inputLine;

				in.close();
			} catch (Exception e) {
				// Log.d(LOG_TAG, "Error: " + e.getMessage());
			}
			// String html =
			// "<p>An <a href='http://com/'><b>example</b></a> link.</p>";

			// first one is image, skip it

			try {
				Document doc = Jsoup.parse(htmlCode);
				Element link = doc.select("a").first();

				 text = doc.body().text(); // "An example link"
				String linkHref = link.attr("href"); // "http://example.com/"
				String linkText = link.text(); // "example""

				String linkOuterH = link.outerHtml();
				// "<a href="http://example.com"><b>example</b></a>"
				String linkInnerH = link.html(); // "<b>example</b>"
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		String text;
		@Override
		protected void onPostExecute(Void result) {
			txt.setText(text);
			
			 String route= text.substring(text.indexOf("Route:"),
						text.indexOf("Click Here For Delhi Metro") );
			  
			 
			    route= route.replaceAll("-->"," \n");
			//  route=route.replace("Route:","");
			   
			txt.setText(text.substring(text.indexOf("Fare:"),
					text.indexOf("Fare:") + 12));

			super.onPostExecute(result);
		}
		
		}
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_fareroute, menu);
			return true;
		}
}