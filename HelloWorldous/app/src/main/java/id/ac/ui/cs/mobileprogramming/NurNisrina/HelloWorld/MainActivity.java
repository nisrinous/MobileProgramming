package id.ac.ui.cs.mobileprogramming.NurNisrina.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton greetingImage = (ImageButton)findViewById(R.id.greetingImage);
        greetingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = StaticFunctions.GreetingMessage("Hello!");
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }
}