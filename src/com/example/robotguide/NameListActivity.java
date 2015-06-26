package com.example.robotguide;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NameListActivity extends Activity {
	String warning;
	Button mybtn1,mybtn2,mybtn3,mybtn4,mybtn5;
	TextView txtView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name_list);
		mybtn1 = (Button)findViewById(R.id.Button01);
		mybtn2 = (Button)findViewById(R.id.Button02);
		mybtn3 = (Button)findViewById(R.id.Button03);
		mybtn4 = (Button)findViewById(R.id.Button04);
		mybtn5 = (Button)findViewById(R.id.Button05);
		txtView=(TextView)findViewById(R.id.textViewNamelist);
		
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

}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.name_list, menu);
		return true;
	}

}
