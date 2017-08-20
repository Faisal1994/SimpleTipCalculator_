package com.example.mohamedhidayath.tipcalv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.mohamedhidayath.tipcalv2.Utils.Constants;
import com.example.mohamedhidayath.tipcalv2.Utils.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static  final String TAG = MainActivity.class.getSimpleName();
    private EditText billamount;
    private EditText tippercent;
    private EditText count;
    private SeekBar seekBar;

    private Button mcalculate;
    private Button mExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.printLog(TAG, "Begining of the program");
        initialize();
        listners();
        seekBar.setOnSeekBarChangeListener(this);
    }

    private void resetviews() {
        billamount.setText("");
        tippercent.setText("");
        count.setText("");
        Utils.printLog(TAG, "reseted the values");
    }

    private void listners() {
        mcalculate.setOnClickListener(this);
        mExit.setOnClickListener(this);
    }

    private void initialize() {
        billamount = (EditText) findViewById(R.id.editTextBill);
        tippercent = (EditText) findViewById(R.id.editText_tip_percent);
        count = (EditText) findViewById(R.id.editText_number_of_people);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        mcalculate = (Button) findViewById(R.id.caculate_id);
        mExit = (Button) findViewById(R.id.button_exit);
        Utils.printLog(TAG, "initialize with ids");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.caculate_id:
                String billAmount = billamount.getText().toString().trim();
                String tip = tippercent.getText().toString().trim();
                String people = count.getText().toString().trim();

                if(TextUtils.isEmpty(billAmount)){
                    Toast.makeText(getApplicationContext(),"Input bill amount",Toast.LENGTH_SHORT).show();
                    Utils.printLog(TAG, "bill amount empty");
                    return;
                }
                if(TextUtils.isEmpty(tip)){
                    Toast.makeText(getApplicationContext(),"enter tip",Toast.LENGTH_SHORT).show();
                    Utils.printLog(TAG, "tip entered is empty");
                    return;
                }
                if(TextUtils.isEmpty(people)){
                    Toast.makeText(getApplicationContext(),"enter the amount",Toast.LENGTH_SHORT).show();
                    Utils.printLog(TAG, "enter the amount");
                    return;
                }

                Float billedAmount = Float.parseFloat(billAmount);
                int tippercentage = Integer.parseInt(tip);
                int countofpeople = Integer.parseInt(people);

                float tipamount = billedAmount * tippercentage/100.0f;
                Float totalbill = (billedAmount + tipamount);
                float individualbill = totalbill/countofpeople;
                Utils.printLog(TAG, "Calculating the price");


                Intent intent = new Intent(MainActivity.this,resultActivity.class);
                Bundle b = new Bundle();
                b.putString(Constants.kEY_BILL_AMOUNT,""+billedAmount);
                b.putString(Constants.kEY_TIP_PERCENT,""+tippercentage);
                b.putString(Constants.kEY_TIP_AMOUNT,""+tipamount);
                b.putString(Constants.kEY_PEOPLE_COUNT,""+countofpeople);
                b.putString(Constants.kEY_TOTAL_BILL_AMOUNT,""+totalbill);
                b.putString(Constants.kEY_INDIVIDUAL_BILL_AMOUNT,""+individualbill);

                intent.putExtras(b);
                startActivity(intent);
                resetviews();
                break;

            case R.id.button_exit:
                finish();
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar1) {
        tippercent.setText(String.valueOf(seekBar1.getProgress()));
    }
}
