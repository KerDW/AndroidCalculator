package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addOperator (View v){

        TextView  op = (TextView) findViewById(R.id.operator);

        switch(v.getTag().toString()){
            case "+":
                op.setText("+");
            break;
            case "-":
                op.setText("-");
            break;
            case "/":
                op.setText("/");
            break;
            case "*":
                op.setText("*");
            break;

        }
    }

    public void numberStroke(View v){

        String press = v.getTag().toString();
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText  number2 = (EditText) findViewById(R.id.number2);
        EditText  result = (EditText) findViewById(R.id.result);
        TextView  op = (TextView) findViewById(R.id.operator);

        if(op.getText() == ""){
            number1.setText(number1.getText().toString()+press);
            result.setText(number1.getText());
        } else {
            number2.setText(number2.getText().toString()+press);

            switch(op.getTag().toString()){
                case "*":
                    result.setText(Integer.parseInt(number1.getText().toString())*Integer.parseInt(number2.getText().toString()));
                    break;
                case "/":
                    result.setText(Integer.parseInt(number1.getText().toString())/Integer.parseInt(number2.getText().toString()));
                    break;
                case "-":
                    result.setText(Integer.parseInt(number1.getText().toString())-Integer.parseInt(number2.getText().toString()));
                    break;
                 case "+":
                    result.setText(Integer.parseInt(number1.getText().toString())+Integer.parseInt(number2.getText().toString()));
                    break;
            }


        }




    }

}
