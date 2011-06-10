package sg.edu.rp.c345.a01.hungrycomehere;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;

public class Restaurant {

	// Declarations Fields
	String name;
	String address;
	String phoneNumber;
	String email;
	String url;
	String openingHours;
	String closingHours;
	GeoPoint latLong;

	// Constructor generated from Fields
	public Restaurant(String name, String address, String phoneNumber,
			String email, String url, String openingHours, String closingHours,
			GeoPoint latLong) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.url = url;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
		this.latLong = latLong;
	}

	// Construct from Bundle
	public Restaurant(Bundle b) {
		name = b.getString("restaurantName");
		address = b.getString("restaurantAddress");
		phoneNumber = b.getString("restaurantPhoneNumber");
		email = b.getString("restaurantEmail");
		url = b.getString("restaurantUrl");
		openingHours = b.getString("restaurantOpeningHrs");
		closingHours = b.getString("restaurantClosingHrs");
		latLong = new GeoPoint(b.getInt("restaurantLat"),
				b.getInt("restaurantLong"));
	}

	// A mapping from String values to various Parcelable types.
	// Used for passing data between various Activities.
	// A special type-safe container, called Bundle, is available for key/value
	// maps of heterogeneous values.
	// Convert into bundle
	public Bundle getBundle() {
		Bundle bundle = new Bundle();
		bundle.putString("restaurantName", name);
		bundle.putString("restaurantAddress", address);
		bundle.putString("restaurantUrl", url);
		bundle.putString("restaurantEmail", email);
		bundle.putString("restaurantPhoneNumber", phoneNumber);
		bundle.putString("restaurantOpeningHrs", openingHours);
		bundle.putString("restaurantClosingHrs", closingHours);
		bundle.putInt("restaurantLat", latLong.getLatitudeE6());
		bundle.putInt("restaurantLong", latLong.getLongitudeE6());
		return bundle;
	}

	// Get, Set, toString!
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getClosingHours() {
		return closingHours;
	}

	public void setClosingHours(String closingHours) {
		this.closingHours = closingHours;
	}

	public GeoPoint getLatLong() {
		return latLong;
	}

	public void setLatLong(GeoPoint latLong) {
		this.latLong = latLong;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", url=" + url + ", openingHours=" + openingHours
				+ ", closingHours=" + closingHours + ", latLong=" + latLong
				+ "]";
	}

}