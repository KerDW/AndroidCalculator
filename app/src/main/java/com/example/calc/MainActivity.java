package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void addOperator (View v){

        TextView  op = (TextView) findViewById(R.id.operator);
        EditText  number1 = (EditText) findViewById(R.id.number1);
        EditText  number2 = (EditText) findViewById(R.id.number2);
        EditText  result = (EditText) findViewById(R.id.result);

        if(op.getText() != ""){
            number1.setText(result.getText());
            number2.setText("");
        }

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

    public void specialChars(View v){

        TextView  op = (TextView) findViewById(R.id.operator);
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText  number2 = (EditText) findViewById(R.id.number2);
        EditText  result = (EditText) findViewById(R.id.result);

        EditText currentNumber = op.getText() == "" ? number1 : number2;

        switch(v.getTag().toString()){
            case ".":
                if(!isEmpty(currentNumber) && !currentNumber.getText().toString().contains("."))
                    currentNumber.setText(currentNumber.getText().toString()+".");
                break;
            case "%":
                if(!isEmpty(currentNumber))
                    currentNumber.setText(Double.toString(Double.parseDouble(number1.getText().toString())/100));
                break;
            case "C":
                result.setText("");
                number1.setText("");
                number2.setText("");
                op.setText("");
            case "=":
                number1.setText(result.getText());
                op.setText("");
                number2.setText("");
                break;
            case "back":
                if (isEmpty(number2) && currentNumber == number2)
                    op.setText("");
                if(currentNumber.getText().toString().length()>0 && android.text.TextUtils.isDigitsOnly(currentNumber.getText().toString()))
                    currentNumber.setText(currentNumber.getText().toString().substring(0, currentNumber.getText().toString().length() - 1));
                else
                    currentNumber.setText("");
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
            if(isEmpty(number1)){
                number1.setText("0");
            }

            number2.setText(number2.getText().toString()+press);
            result.setText("");

            switch(op.getText().toString()){
                case "*":
                    result.setText(Double.toString(Double.parseDouble(number1.getText().toString())*Double.parseDouble(number2.getText().toString())));
                    break;
                case "/":
                    result.setText(Double.toString(Double.parseDouble(number1.getText().toString())/Double.parseDouble(number2.getText().toString())));
                    break;
                case "-":
                    result.setText(Double.toString(Double.parseDouble(number1.getText().toString())-Double.parseDouble(number2.getText().toString())));
                    break;
                 case "+":
                     result.setText(Double.toString(Double.parseDouble(number1.getText().toString())+Double.parseDouble(number2.getText().toString())));
                    break;
            }




        }




    }

    public void realCalc(View v){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.miui.calculator");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }
    }

}
