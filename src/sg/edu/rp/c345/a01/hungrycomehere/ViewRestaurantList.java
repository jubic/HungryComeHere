package sg.edu.rp.c345.a01.hungrycomehere;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.maps.GeoPoint;

public class ViewRestaurantList extends ListActivity {
	// Declarations
	ListView restaurantListView;
	ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	ArrayList<String> restaurantName = new ArrayList<String>();
	ArrayAdapter<String> restaurantAdapter;
	static final private int FEEDBACK = Menu.FIRST;
	static final private int VIEW_REST = Menu.FIRST + 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_list_view);
		setRestaurant("Ban Leong Wah Hoe Seafood",
				"122 Casuarina Road, Singapore", "64522824",
				"contact@wahhoe-seafood.com", "http://www.wahhoe-seafood.com",
				"5:00 PM", "1:30 AM", new GeoPoint(1376700, 103828170));
		setRestaurant(
				"Ngee Fou Restaurant (Hakka) Ampang Yong Tou Foo",
				"928 Upper Thomson Road, Singapore",
				"64521801",
				null,
				"http://www.hungrygowhere.com/singapore/ngee_fou_restaurant_hakka_ampang_yong_tou_foo/",
				"9:30 AM", "7:30 PM", new GeoPoint(1399455, 103817878));
		setElements();
	}

	// Create onListItemClick method
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent viewRestaurantMap = new Intent(getBaseContext(),
				ViewRestaurantMap.class);
		viewRestaurantMap.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		// Put all restaurants' data across activity
		viewRestaurantMap.putExtras(restaurantList.get(position).getBundle());

		startActivity(viewRestaurantMap);
	}

	// Populate list
	private void setElements() {
		restaurantListView = getListView();
		registerForContextMenu(restaurantListView);
		restaurantAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, restaurantName);
		restaurantListView.setAdapter(restaurantAdapter);
	}

	private void setRestaurant(String name, String address, String phoneNumber,
			String email, String url, String openingHours, String closingHours,
			GeoPoint latLong) {
		restaurantList.add(new Restaurant(name, address, phoneNumber, email,
				url, openingHours, closingHours, latLong));
		restaurantName.add(name);

	}

	// Create Context Menu
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle(R.string.chooseAction);
		menu.add(0, FEEDBACK, Menu.NONE, R.string.feedback);
		menu.add(0, VIEW_REST, Menu.NONE, R.string.view);
	}

	// Execute Context Item Action based on user long-click.
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		switch (item.getItemId()) {
		case (FEEDBACK): {

			AdapterView.AdapterContextMenuInfo menuInfo;
			menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			int index = menuInfo.position;
			
			Intent feedbackRestaurant = new Intent(getBaseContext(),
					feedbackRestaurant.class);
			feedbackRestaurant.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			// Put all restaurants' data across activity
			feedbackRestaurant.putExtras(restaurantList.get(index).getBundle());

			startActivity(feedbackRestaurant);
			
			return true;
		}
		case (VIEW_REST): {
			
			AdapterView.AdapterContextMenuInfo menuInfo;
			menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			final int index = menuInfo.position;
			
			Intent viewRestaurant = new Intent(getBaseContext(),
					ViewRestaurant.class);
			viewRestaurant.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			// Put all restaurants' data across activity
			viewRestaurant.putExtras(restaurantList.get(index).getBundle());

			startActivity(viewRestaurant);

			return true;
		}
		}
		return false;
	}
}