/**
 * Logger.java
 * Anton Dukeman
 *
 * Logs user interaction with the system
 */
package com.example.robotguide;
import java.io.*;

import android.content.Context;

public class Logger
{
  private static long prevTime = System.currentTimeMillis();

  public static void output(Context context, String data)
  {
    try
    {
      File output = new File("/storage/emulated/0/logging/logging.csv");
      System.err.println(output.getAbsolutePath());
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(output, true)));
      long curTime = System.currentTimeMillis();
      long offset = curTime - prevTime;
      prevTime = curTime;
      out.println(curTime + "," + offset + "," + data);
      out.close();
    }
    catch(IOException e)
    {
      System.err.println("failed to log: " + data);
      System.err.println(e);
    }
  }
}
