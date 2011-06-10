package sg.edu.rp.c345.a01.hungrycomehere;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class feedbackRestaurant extends Activity{
	TextView restName;
	RatingBar restRatingBar;
	Button submitBtn;
	Restaurant restaurant;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_feedback);
		
		// Get Intents from ViewRestaurantList
		restaurant = new Restaurant(getIntent().getExtras());
		
		// Get views from layout
		restName = (TextView) findViewById(R.id.restName);
		restRatingBar = (RatingBar) findViewById(R.id.restRating);
		submitBtn = (Button) findViewById(R.id.save);
		
		restName.setText(restaurant.getName());
		
		submitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Context context = getApplicationContext();
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(context, R.string.ratingSubmitted, duration);
				toast.show();
			}
			
		});
	}
}
