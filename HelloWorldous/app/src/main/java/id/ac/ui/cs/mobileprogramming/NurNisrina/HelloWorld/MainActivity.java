package id.ac.ui.cs.mobileprogramming.NurNisrina.HelloWorld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    TextView textViewTimer = null;
    Button buttonStart, buttonStop;
    Integer pressed;

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onbackpressed func");
        pressed = pressed + 1;
        Log.d("CDA", "pressed + 1");
        Toast.makeText(getApplicationContext(), "Press again to exit", Toast.LENGTH_LONG).show();

        if (pressed > 1) {
            super.onBackPressed();
        }gi

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart, buttonStop;

        textViewTimer = (TextView)findViewById(R.id.textViewTimer);
        buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStop = (Button)findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, Services.class));

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, Services.class));
                textViewTimer.setText("00:00:00.0");
            }
        });
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateGUI(intent);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(br, new IntentFilter(Services.STOPWATCH_BR));
    }

    @Override
    protected void onStop() {
        unregisterReceiver(br);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, Services.class));
        super.onDestroy();
    }

    private void updateGUI(Intent intent) {
        if (intent.getExtras() != null) {
            String hours = intent.getStringExtra("hours");
            String minutes = intent.getStringExtra("minutes");
            String seconds = intent.getStringExtra("seconds");
            String milliseconds = intent.getStringExtra("milliseconds");
            textViewTimer.setText(hours + ":" + minutes + ":" + seconds + "." + milliseconds);
        }
    }
}