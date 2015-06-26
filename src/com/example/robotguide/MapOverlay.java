package com.example.robotguide;



import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import com.example.robotguide.ImageMap.Area;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MapOverlay extends Activity {
	ImageMap mImageMap;
    Dialog popup;
    Date date = new Date();
    Timestamp clickOnMapTime;
    Context mapOverlayContext;
    String ipAddress;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ipAddress = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        setContentView(R.layout.activity_map_overlay);
        mapOverlayContext = this.getApplicationContext();
        
        // find the image map in the view
        mImageMap = (ImageMap)findViewById(R.id.map);
        
        // add a click handler to react when areas are tapped
        mImageMap.addOnImageMapClickedHandler(new ImageMap.OnImageMapClickedHandler() {
			@Override
			public void onImageMapClicked(int id) {
				// when the area is tapped, show the name in a 
				// text bubble
				mImageMap.showBubble(id);
				
				final Area a = mImageMap.mIdToArea.get(id);
				AlertDialog.Builder builder = new AlertDialog.Builder(MapOverlay.this);
		        builder.setMessage(R.string.dialog_message)
		               .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
		                   public void onClick(DialogInterface dialog, int id) {
		                       // FIRE ZE MISSILES!
		       					String name = a.getName();
		       					System.out.println(name);
		       					Logger.output(mapOverlayContext, "User clicked on Room " + name + "in MapOverlay Activity");
		                	
		       					if (a != null) {
		       					final String roomName = a.getName();
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
		       				                    	byte[] strings = roomName.getBytes("US-ASCII");
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

		       				    thread.start();**/
		       					
		       					System.out.println(name);
		       				}
		                   }
		               })
		               .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
		                   public void onClick(DialogInterface dialog, int id) {
		                       // User cancelled the dialog
		                   }
		               });
		        // Create the AlertDialog object and return it
		        builder.create();
	        builder.show();		
			}

			@Override
			public void onBubbleClicked(int id) {
				
				// react to info bubble for area being tapped
				
			}
		});
    }
}
