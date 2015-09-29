package com.example.reshad.actionbaronholotheme;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class CountryVisited extends AppCompatActivity {
    TextView alarm_view;
    Date date;
    private String time;
    private LinearLayout layout;
    final Handler handler = new Handler();

    public static final String INTENT_ACTION = "reshad.assingment.ALARM_BROADCAST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        //Intent intent = getIntent();
        layout = (LinearLayout)findViewById(R.id.linear_id);
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        int width = point.x;
      /*  if(intent.hasExtra("Hour"))
        {
            TextView view = new TextView(this);
            view.setTextSize(width / 30);
            view.setText(intent.getIntExtra("Hour", 0) + " : " + intent.getIntExtra("Minute", 0));
            layout.addView(view);
        }*/
        alarm_view = (TextView)findViewById(R.id.alarm_id);
        date = new Date(System.currentTimeMillis());
        time = DateFormat.getTimeInstance().format(date);
        display.getSize(point);
        alarm_view.setTextSize(width / 12);
        alarm_view.setText(time);

        /*Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try
                        {
                            date = new Date(System.currentTimeMillis());
                            time = DateFormat.getTimeInstance().format(date);
                             alarm_view.setText(time);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });
            }
        },0, 5000);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alarm, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(null);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(null);
        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_new_alarm_id) {
            startActivity(new Intent(this, NewAlarmActivity.class));
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
