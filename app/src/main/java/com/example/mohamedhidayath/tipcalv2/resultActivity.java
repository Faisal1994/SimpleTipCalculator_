package com.example.mohamedhidayath.tipcalv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity implements View.OnClickListener{
private TextView textViewBillAmount;
    private TextView textViewTipPercent;
    private TextView textViewNumberofpeople;
    private TextView textViewTipAmount;
    private TextView textViewtotalBill;
    private TextView textViewIndividualbill;

    String billAmount = "";
    String tipPerentage = "";
    String peopleCount = "";
    String tipAmount = "";
    String totalBillIncludingTip = "";
    String individualBill = "";

    private Button previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initialize();

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//ends oly the current activity
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            billAmount = bundle.getString("billAmount");
            tipPerentage = bundle.getString("tipPercent");
            peopleCount = bundle.getString("tipAmount");
            tipAmount = bundle.getString("numberofpeople");
            totalBillIncludingTip = bundle.getString("totalbill");
            individualBill = bundle.getString("individualbill");

            textViewBillAmount.setText(""+billAmount);
            textViewTipPercent.setText(""+tipPerentage);
            textViewNumberofpeople.setText(""+peopleCount);
            textViewTipAmount.setText(""+tipAmount);
            textViewtotalBill.setText(""+totalBillIncludingTip);
            textViewIndividualbill.setText(""+individualBill);
        }
    }
  private void initialize() {
        textViewBillAmount = (TextView) findViewById(R.id.text_view_bill_amount);
        textViewTipPercent = (TextView) findViewById(R.id.textView_tip_percentage);
        textViewNumberofpeople = (TextView) findViewById(R.id.numberofpeople_id);
        textViewTipAmount = (TextView) findViewById(R.id.tip_amount_id);
        textViewtotalBill = (TextView) findViewById(R.id.totalbill_id);
        textViewIndividualbill = (TextView) findViewById(R.id.individualbill_id);
        previous = (Button) findViewById(R.id.button);
    }

    @Override
    public void onClick(View view) {

    }
}
