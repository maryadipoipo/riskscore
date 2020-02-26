package com.example.riskscorehbp;

import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Integer score = 0;
    private RadioGroup radioGroup;
    private Integer radioGroupIds[] = {
            R.id.rg1,   R.id.rg2a,  R.id.rg2b, R.id.rg3,   R.id.rg4,
            R.id.rg5,   R.id.rg6,   R.id.rg7,  R.id.rg8,   R.id.rg9a,
            R.id.rg9b,  R.id.rg9c,  R.id.rg10, R.id.rg11a, R.id.rg11b,
            R.id.rg11c, R.id.rg11d, R.id.rg12, R.id.rg13,  R.id.rg14,
            R.id.rg15,  R.id.rg15,  R.id.rg16, R.id.rg17,  R.id.rg18,
            R.id.rg19,  R.id.rg20
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button calculate_scor = (Button) findViewById(R.id.calculate_scor);
        calculate_scor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 2; // Initial score for woman is 2
                String q1 = "";
                for(Integer i : radioGroupIds) {
                    radioGroup = (RadioGroup) findViewById(i);
                    if (radioGroup.getCheckedRadioButtonId() != -1) {
                        Integer selectedRadioId = radioGroup.getCheckedRadioButtonId();
                        RadioButton selectedRadio = (RadioButton) findViewById(selectedRadioId);
                        q1 = selectedRadio.getText().toString();
                        if (q1.equals(getResources().getString(R.string.ya))) {
                            if(i.equals(R.id.rg10) || i.equals(R.id.rg17) || i.equals(R.id.rg18)
                               || i.equals(R.id.rg19) || i.equals(R.id.rg20)){
                                score += 8;
                            } else {
                                score += 4;
                            }
                        } else {
                            Log.i("Not yet", "selected");
                        }
                    }
                }
                Toast.makeText(getApplicationContext(),"Temporary Score: " + score,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void generatePdf() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            PdfDocument document = new PdfDocument();
            // Will be continued later... :D
        }
    }
}
