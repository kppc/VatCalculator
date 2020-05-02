package kr.hs.namyangju.vatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText SalesAmount;
    RadioButton Trunc, Round, Ceil;
    TextView price, tax;
    Button Calculation;
    LinearLayout calcu;
    float salesAmountVal = 0;
    float priceVal = 0;
    float taxVal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        Calculation.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                calcu.setVisibility(View.VISIBLE);
                salesAmountVal = Integer.parseInt(SalesAmount.getText().toString());
                Log.v("TAG", "" + salesAmountVal);
                priceVal = (salesAmountVal / 11) * 10;
                taxVal = salesAmountVal / 11;

                if (Trunc.isChecked() == true) {
                    price.setText(String.format("%.0f", Math.floor(priceVal)) + "원");
                    tax.setText(String.format("%.0f", Math.floor(taxVal)) + "원");

                } else if (Round.isChecked() == true) {
                    price.setText(String.valueOf(Math.round(priceVal)) + "원");
                    tax.setText(String.valueOf(Math.round(taxVal)) + "원");

                } else if (Ceil.isChecked() == true) {
                    price.setText(String.format("%.0f", Math.ceil(priceVal)) + "원");
                    tax.setText(String.format("%.0f", Math.ceil(taxVal)) + "원");

                }

            }
        });
    }

    void init() {
        calcu = (LinearLayout) findViewById(R.id.calcu);
        SalesAmount = (EditText) findViewById(R.id.SalesAmount);
        price = (TextView) findViewById(R.id.price);
        tax = (TextView) findViewById(R.id.tax);
        Calculation = (Button) findViewById(R.id.CalculationBtn);
        Trunc = (RadioButton) findViewById(R.id.trunc);
        Round = (RadioButton) findViewById(R.id.round);
        Ceil = (RadioButton) findViewById(R.id.ceil);
    }
}
