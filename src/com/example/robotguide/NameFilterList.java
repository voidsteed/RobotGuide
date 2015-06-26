package com.example.robotguide;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
 
import com.example.robotguide.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class NameFilterList extends Activity {
 
 ArrayAdapter<String> dataAdapter = null;
 Date date = new Date();
 Context nameFilterListContext;
 String ipAddress;
 
 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  Intent intent = getIntent();
  ipAddress = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
  setContentView(R.layout.name_filter_list);
  nameFilterListContext = this.getApplicationContext();
  //Generate list View from ArrayList
  displayListView();
 
 } 
 
 private void displayListView() {
 
  //Array list of countries
  List<String> countryList = new ArrayList<String>();
  for (int i=0; i <100; i++){
	  countryList.add((Integer.toString(200+i)));
  }
  countryList.add("Media Center");
  countryList.add("Ralph Bruce");
  countryList.add("Linda Koger");
  countryList.add("Computer Lab");
  countryList.add("Study Area");
  countryList.add("Timothy Holman");
  countryList.add("Lewis Saettel");
  countryList.add("William Robinson");
  countryList.add("Hampton Albert");
  countryList.add("Daniel Fleetwood");
  countryList.add("Jerry Roth");
  countryList.add("Elevator");
  Collections.sort(countryList);
 
  //create an ArrayAdaptar from the String Array
  dataAdapter = new ArrayAdapter<String>(this,
    R.layout.country_list, countryList);
  ListView listView = (ListView) findViewById(R.id.listView1);
  // Assign adapter to ListView
  listView.setAdapter(dataAdapter);
 
  //enables filtering for the contents of the given ListView
  listView.setTextFilterEnabled(true);
 
  listView.setOnItemClickListener(new OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View view,
     int position, long id) {
    // When clicked, show a toast with the TextView text
    Toast.makeText(getApplicationContext(),
     ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
    
    final View socketText = view;
    /**
    Thread thread = new Thread()
    {
        @Override
        public void run() {
            try {
                
                    sleep(1000);
                    Socket socket = null;
                	try {
                		socket = new Socket("10.67.110.77",34090);
                	} catch (UnknownHostException e1) {
                		// TODO Auto-generated catch block
                		e1.printStackTrace();
                	} catch (IOException e1) {
                		// TODO Auto-generated catch block
                		e1.printStackTrace();
                	}
                    OutputStream OS = null;
                	try {
                		OS = socket.getOutputStream();
                	} catch (IOException e1) {
                		// TODO Auto-generated catch block
                		e1.printStackTrace();
                	}
                    try {
                    	byte[] strings = ((TextView)socketText).getText().toString().getBytes("US-ASCII");
                    	byte[] out = new byte[strings.length + 1];
                    	for(int i = 0; i < strings.length; ++i)
                    		out[i] = strings[i];
                    	out[strings.length] = 0;
                		OS.write(out);
                		
                	} catch (IOException e) {
                		// TODO Auto-generated catch block
                		e.printStackTrace();
                	}
                    try {
                		socket.close();
                	} catch (IOException e) {
                		// TODO Auto-generated catch block
                		e.printStackTrace();
                	}
                    
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    thread.start();
    **/
    String name = new String(((TextView) socketText).getText().toString());
    Logger.output(nameFilterListContext, "User clicked on Room " + name + "in MapOverlay Activity");
    System.out.println(name);

   }
  });
 
  EditText myFilter = (EditText) findViewById(R.id.myFilter);
  myFilter.addTextChangedListener(new TextWatcher() {
 
  public void afterTextChanged(Editable s) {
  }
 
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
  }
 
  public void onTextChanged(CharSequence s, int start, int before, int count) {
   dataAdapter.getFilter().filter(s.toString());
  }
  });
 }   
}