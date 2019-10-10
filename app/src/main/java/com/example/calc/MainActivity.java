package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberStroke(View v){

        String press = v.getTag().toString();
        TextView  number1 = (TextView) findViewById(R.id.number1);
        TextView  number2 = (TextView) findViewById(R.id.number2);
        TextView  op = (TextView) findViewById(R.id.operator);

        if(op.getText() == ""){
            number1.setText(number1.getText()+press);


        }


    }

}
