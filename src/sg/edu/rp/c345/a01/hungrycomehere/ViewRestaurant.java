package sg.edu.rp.c345.a01.hungrycomehere;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewRestaurant extends Activity {

	// Declarations
	TextView restNameInfo, restAddressInfo, restContactInfo,
			restOpeningHoursInfo;
	Restaurant restInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_info);

		// Get Intents From ViewRestaurantList
		restInfo = new Restaurant(getIntent().getExtras());

		// Get Views From Layout
		restNameInfo = (TextView) findViewById(R.id.restNameInfo);
		restAddressInfo = (TextView) findViewById(R.id.restAddressInfo);
		restContactInfo = (TextView) findViewById(R.id.restPhoneNumberInfo);
		restOpeningHoursInfo = (TextView) findViewById(R.id.restOpeningHoursInfo);

		// Concatenate TextViews with Strings from Intents
		restNameInfo.setText(" " + restInfo.getName());
		restAddressInfo.setText(" " + restInfo.getAddress());
		restContactInfo.setText(" " + restInfo.getPhoneNumber());
		restOpeningHoursInfo.setText(" " + restInfo.getOpeningHours() + " to "
				+ restInfo.getClosingHours());
	}
}
