package com.example.robotguide;
import java.io.File;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayButtonMapActivity extends Activity {
	String warning;
	Button mybtn1,mybtn2,mybtn3,mybtn4,mybtn5,mybtn6,mybtn7,mybtn8;
	TextView txtView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);        
		setContentView(R.layout.display_button_map_activity);
		mybtn1 = (Button)findViewById(R.id.button1);
		mybtn2 = (Button)findViewById(R.id.button2);
		mybtn3 = (Button)findViewById(R.id.button3);
		mybtn4 = (Button)findViewById(R.id.button4);
		mybtn5 = (Button)findViewById(R.id.button5);
		mybtn6 = (Button)findViewById(R.id.button6);
		mybtn7 = (Button)findViewById(R.id.button7);
		mybtn8 = (Button)findViewById(R.id.button8);
		txtView=(TextView)findViewById(R.id.txtViewXX);

		warning = "Not implemented yet!";
		mybtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				txtView.setText(warning);
			}
		});
mybtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				txtView.setText(warning);
			}
		});
mybtn3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		txtView.setText(warning);
	}
});
mybtn4.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		txtView.setText(warning);
	}
});
mybtn5.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		txtView.setText(warning);
	}
});
mybtn6.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		txtView.setText(warning);
	}
});

mybtn7.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		txtView.setText(warning);
	}
});
mybtn8.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		txtView.setText(warning);
	}
});

		
    }
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_button_map, menu);
		return true;
	}
	
	

}
