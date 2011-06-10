package sg.edu.rp.c345.a01.hungrycomehere;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class ViewRestaurantMap extends MapActivity {

	// Declarations
	static final private int MAP_VIEW = Menu.FIRST;
	static final private int SAT_VIEW = Menu.FIRST + 1;
	MapView map;
	MapController myMapController;
	MyLocationOverlay myLocationOverlay;
	List<Overlay> mapOverlays;
	Drawable marker;
	HelloItemizedOverlay itemizedOverlay;
	Restaurant restaurant;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_map);

		// Get Intents from ViewRestaurantList
		restaurant = new Restaurant(getIntent().getExtras());

		// MapView and Controller
		map = (MapView) findViewById(R.id.map);
		map.setBuiltInZoomControls(true);
		myMapController = map.getController();
		myMapController.setZoom(11);
		myMapController.setCenter(new GeoPoint(1352083, 103819836));

		// MyLocationOverlay
		myLocationOverlay = new MyLocationOverlay(this, map);
		myLocationOverlay.enableMyLocation();
		map.getOverlays().add(myLocationOverlay);

		// Get Overlays
		mapOverlays = map.getOverlays();
		marker = this.getResources().getDrawable(R.drawable.marker);
		itemizedOverlay = new HelloItemizedOverlay(marker);

		// Add Marker on restaurant
		GeoPoint restaurantPoint = new GeoPoint(restaurant.getLatLong()
				.getLatitudeE6(), restaurant.getLatLong().getLongitudeE6());
		OverlayItem restaurantOverlayItem = new OverlayItem(restaurantPoint,
				"", "");

		itemizedOverlay.addOverlay(restaurantOverlayItem);
		mapOverlays.add(itemizedOverlay);
	}

	// Create Options menu
	@Override
	public boolean onCreateOptionsMenu(Menu optionsMenu) {
		super.onCreateOptionsMenu(optionsMenu);
		// Create and add new menu items.
		MenuItem itemMap = optionsMenu.add(0, MAP_VIEW, Menu.NONE,
				R.string.mapview);
		MenuItem itemSatellite = optionsMenu.add(0, SAT_VIEW, Menu.NONE,
				R.string.satview);

		itemMap.setIcon(R.drawable.mapview);
		itemSatellite.setIcon(R.drawable.satelliteview);
		return true;
	}

	// Execute option's action based on user click.
	@Override
	public boolean onOptionsItemSelected(MenuItem optionItem) {
		super.onOptionsItemSelected(optionItem);
		switch (optionItem.getItemId()) {
		case (MAP_VIEW): {

			map.setSatellite(false);
			return true;
		}
		case (SAT_VIEW): {

			map.setSatellite(true);
			return true;
		}

		}
		return false;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
