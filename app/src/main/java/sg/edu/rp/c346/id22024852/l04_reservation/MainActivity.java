package sg.edu.rp.c346.id22024852.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reserve;
        Button reset;
        DatePicker dp;
        TimePicker tp;
        RadioGroup area;

        EditText nameinp;
        EditText telinp;
        EditText paxinp;

        reserve = findViewById(R.id.buttonReserve);
        reset = findViewById(R.id.buttonReset);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        nameinp = findViewById(R.id.editTextName);
        telinp = findViewById(R.id.editTextPhone);
        area = findViewById(R.id.radioGroupArea);
        paxinp = findViewById(R.id.editTextPax);

        dp.updateDate(2020,5,1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);



        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                int checked = area.getCheckedRadioButtonId();
                String areachoice = "";
                if (checked == R.id.radioButtonSmoke) {
                    areachoice = "Smoking Area";
                } else {
                    areachoice = "Non-Smoking Area";
                }


                message += "Name: " + nameinp.getText().toString() + "\n";
                message += "Pax: " + paxinp.getText().toString() +"\n";
                message += "Tel: " + telinp.getText().toString() + "\n";
                message += "Date: " + dp.getDayOfMonth() +"/"+ (dp.getMonth()+1) +"/"+ dp.getYear() + "\n";
                message += "Area: " + areachoice + "\n";
                message += String.format("%s %02d:%02d","Time: ", tp.getCurrentHour(), tp.getCurrentMinute());

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                nameinp.setText(" ");
                telinp.setText(" ");
                paxinp.setText(" ");

            }
        });






    }
}