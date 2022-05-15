package sg.edu.rp.c346.id21020263.l04_reservation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etGroup;
    DatePicker dp;
    TimePicker tp;
    CheckBox cb;
    Button submit;
    Button reset;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName.findViewById(R.id.editTextPersonName);
        etPhone.findViewById(R.id.editTextPhone);
        etGroup.findViewById(R.id.editTextPax);
        dp.findViewById(R.id.datePicker);
        tp.findViewById(R.id.timePicker);
        cb.findViewById(R.id.checkBox);
        submit.findViewById(R.id.btnSubmit);
        reset.findViewById(R.id.btnReset);

        dp.updateDate(2020, 6,1);
        tp.setHour(19);
        tp.setMinute(30);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String pn = etPhone.getText().toString();
                String gs = etGroup.getText().toString();
                int year = dp.getYear();
                int month = dp.getMonth();
                int day = dp.getDayOfMonth();
                String date = day + "/" + month + "/" + year;
                int hour = tp.getHour();
                int minute = tp.getMinute();
                String time = hour + ":" + minute;
                String table = "";
                if (cb.isChecked()) {
                    table = "Table type: Smoking Area";
                } else {
                    table = "Table type: Non-Smoking Area";
                }
                String text = "Your table reservation request has been made, please wait for confirmation via SMS\nName: " + name + "\nMobile Number: " + pn + "\nGroup Size: " + gs + "\nTable Type: " + table + "\nBooking Date: " + date + "\nBooking Time: " + time;
                if (name.isEmpty() || pn.isEmpty() || gs.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.getText().clear();
                etPhone.getText().clear();
                etGroup.getText().clear();
                cb.setChecked(false);
                dp.updateDate(2020, 6,1);
                tp.setHour(19);
                tp.setMinute(30);
            }
        });
    }
}