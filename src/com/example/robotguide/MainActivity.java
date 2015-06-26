package com.example.robotguide;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
 
	public Spinner building_spinner,fghFloorSpinner,isisFloorSpinner,stevensonFloorSpinner,buttonMapSpinner,typeInSpinner,building,floor,method;
  //private Spinner spinner1,spinner2;
	
	private Button btnSubmit, btnNameList,btnMap;
	Date date= new Date();
	Context mainContext;
	public final static String EXTRA_MESSAGE = "com.example.robotguide.MESSAGE";
	
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	mainContext = this.getApplicationContext();
	Logger.output(mainContext, "User start RobotGuide app");
	chooseCategory();
	chooseFghFloor();
	chooseISIS();
	chooseStevenson();
//	openButtonMap();
	openNameList();
	openOverLayButtonMap();
	//chooseButtonMap();
	//chooseTypeIn();
	
  }
  


public void chooseCategory() {

	  	building_spinner = (Spinner) findViewById(R.id.building_spinner);
	    ArrayAdapter<CharSequence> catAdapter = ArrayAdapter.createFromResource(this, R.array.building_arrays, android.R.layout.simple_spinner_item);
	    catAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    building_spinner.setAdapter(catAdapter);
	    building_spinner.setOnItemSelectedListener(new planOnClickListener());
	}
  
  private void chooseFghFloor(){
	  	fghFloorSpinner = (Spinner) findViewById(R.id.floor_spinner);
	    List<String> planlist = new ArrayList<String>();
	    planlist.add("1st floor");
	    planlist.add("2nd floor");
	    planlist.add("3rd floor");
	    ArrayAdapter<String> planAdapter1 = new ArrayAdapter<String>(this,
	        android.R.layout.simple_spinner_item, planlist);
	    planAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    fghFloorSpinner.setAdapter(planAdapter1);

	}
  
  private void chooseISIS(){

	  	isisFloorSpinner = (Spinner) findViewById(R.id.floor_spinner);
	    List<String> planlist1 = new ArrayList<String>();
	    planlist1.add("1st floor");
	    planlist1.add("2nd floor");
	    planlist1.add("3rd floor");
	    planlist1.add("4th floor");
	    ArrayAdapter<String> planAdapter2 = new ArrayAdapter<String>(this,
	        android.R.layout.simple_spinner_item, planlist1);
	    planAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    isisFloorSpinner.setAdapter(planAdapter2);


	}
  
  private void chooseStevenson(){

	  	stevensonFloorSpinner = (Spinner) findViewById(R.id.floor_spinner);
	    List<String> planlist2 = new ArrayList<String>();
	    planlist2.add("NMR");
	    planlist2.add("Math");
	    planlist2.add("Molecular Biology");
	    planlist2.add("Science Library");
	    planlist2.add("Lecture Hall");
	    planlist2.add("Science&Engineering");
	    planlist2.add("Physics");
	    planlist2.add("Chemistry");
	    ArrayAdapter<String> planAdapter3 = new ArrayAdapter<String>(this,
	        android.R.layout.simple_spinner_item, planlist2);
	planAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		stevensonFloorSpinner.setAdapter(planAdapter3);

	}
  
  //called when Click Submit button 
  /*public void openButtonMap(){
	  
	  building = (Spinner) findViewById(R.id.building_spinner);
	  floor = (Spinner) findViewById(R.id.floor_spinner);
	  method = (Spinner) findViewById(R.id.method_spinner);
	  
	  btnSubmit = (Button)findViewById(R.id.btnSubmit);
	  
	  btnSubmit.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			
			String b = building.getSelectedItem().toString();
			String f = floor.getSelectedItem().toString();
			String m = method.getSelectedItem().toString();
			
			Intent buttonMap = new Intent(MainActivity.this,DisplayButtonMapActivity.class);
			//if (b == "Feathering Hall" && f == "2nd floor" && m == "Button Map"){
			startActivity(buttonMap);
			Logger.output(mainContext, "User start a new older vision Button Map activity");
			
			//}
		}
		  
	  });

	  
  }*/
  
  public void openNameList() {
	btnNameList = (Button)findViewById(R.id.button_name_list);
	btnNameList.setOnClickListener(new OnClickListener(){
		public void onClick(View view) {
			// TODO Auto-generated method stub
			
	/*		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
			View promptsView = inflater.inflate(R.layout.dialog_input_ip, null);
			builder.setView(promptsView);
	        builder.setMessage(R.string.dialog_message)
	               .setPositiveButton(R.string.enter, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                  EditText ipAddress = (EditText) findViewById(R.id.ip_address);
	                  String ipMessage = ipAddress.getText().toString();	                  
	                  
	                	  Intent nameFilterList = new Intent(((Dialog) dialog).getContext(),NameFilterList.class);
	                	  nameFilterList.putExtra(EXTRA_MESSAGE, ipMessage);
	                	  startActivity(nameFilterList);
	                	  Logger.output(mainContext, "User start a new name filter list activity");
	                  }
	                  	
	               })
	               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                       // User cancelled the dialog
	                   }
	               });
	        // Create the AlertDialog object and return it
	        builder.create();
	        builder.show();		
		}*/
		Intent nameFilterList = new Intent(MainActivity.this,NameFilterList.class);
		startActivity(nameFilterList);
		Logger.output(mainContext, "User start a new name filter list activity");
		}
		});				
  }


  public void openOverLayButtonMap() {
	  btnMap = (Button)findViewById(R.id.button_map);
	  btnMap.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				
				/*AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				LayoutInflater inflater = LayoutInflater.from(mainContext);
				View promptsView = inflater.inflate(R.layout.dialog_input_ip, null);
				builder.setView(promptsView);
				builder.setMessage(R.string.text_ip_address)
		               .setPositiveButton(R.string.enter, new DialogInterface.OnClickListener() {
		                  public void onClick(DialogInterface dialog, int id) {
		                  EditText ipAddress = (EditText) findViewById(R.id.ip_address);
		                  String ipMessage = ipAddress.getText().toString();
		                	  Intent nameFilterList = new Intent(MainActivity.this,NameFilterList.class);
		                	  nameFilterList.putExtra(EXTRA_MESSAGE, ipMessage);
		                	  startActivity(nameFilterList);
		                	  Logger.output(mainContext, "User start a new overlay map activity");
		                  }
		                  
		               })
		               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
		                   public void onClick(DialogInterface dialog, int id) {
		                       // User cancelled the dialog
		                   }
		               });
		        // Create the AlertDialog object and return it
		        builder.create();
		        builder.show();		
			}
		});*/
	  Intent mapOverlay = new Intent(MainActivity.this,MapOverlay.class);
	  //nameFilterList.putExtra(EXTRA_MESSAGE, ipMessage);
	  startActivity(mapOverlay);
	}
	  });}
  
  public class planOnClickListener implements OnItemSelectedListener {

      @Override
     public void onItemSelected(AdapterView<?> parent, View v, int pos,
             long id) {

         parent.getItemAtPosition(pos);  

         if (pos==0){
        	chooseFghFloor();
         }else if (pos==1){
     		chooseISIS();
         } else if (pos==2){
     		chooseStevenson();
         }
     }
     @Override
     public void onNothingSelected(AdapterView<?> arg0) {
         // TODO Auto-generated method stub

     }
 }
 

  
  

  
}