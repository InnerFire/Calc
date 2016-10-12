package com.example.harshmodi.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView calculator_result;

    Button button_one, button_two, button_three,
            button_four, button_five, button_six,
            button_seven, button_eight, button_nine,
            button_zero, button_plus, button_minus,
            button_multiply, button_divide, button_power,
            button_root, button_abs, button_clear, button_equals;

    ArrayList<Double> math = new ArrayList<>();
    double first_number;
    double second_number;

    int currentOperation = 0;
    int nextOperation;

    final static int ADD = 1;
    final static int SUBTRACT = 2;
    final static int MULTIPLY = 3;
    final static int DIVISION = 4;
    final static int POWER = 5;
    final static int ROOT = 6;
    final static int ABS = 7;
    final static int EQUALS = 0;
    final static int CLEAR = 1;
    final static int DONT_CLEAR = 0;
    int clearDisplay = 0;
    private TextView calculator_preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator_result = (TextView) findViewById(R.id.resultTextView);
        calculator_preview = (TextView) findViewById(R.id.previewTextView);

        button_one = (Button) findViewById(R.id.number_one);
        button_one.setOnClickListener(this);
        button_two = (Button) findViewById(R.id.number_two);
        button_two.setOnClickListener(this);
        button_three = (Button) findViewById(R.id.number_three);
        button_three.setOnClickListener(this);
        button_four = (Button) findViewById(R.id.number_four);
        button_four.setOnClickListener(this);
        button_five = (Button) findViewById(R.id.number_five);
        button_five.setOnClickListener(this);
        button_six = (Button) findViewById(R.id.number_six);
        button_six.setOnClickListener(this);
        button_seven = (Button) findViewById(R.id.number_seven);
        button_seven.setOnClickListener(this);
        button_eight = (Button) findViewById(R.id.number_eight);
        button_eight.setOnClickListener(this);
        button_nine = (Button) findViewById(R.id.number_nine);
        button_nine.setOnClickListener(this);
        button_zero = (Button) findViewById(R.id.number_zero);
        button_zero.setOnClickListener(this);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);
        button_divide = (Button) findViewById(R.id.button_divide);
        button_divide.setOnClickListener(this);
        button_power = (Button) findViewById(R.id.button_power);
        button_power.setOnClickListener(this);
        button_root = (Button) findViewById(R.id.button_root);
        button_root.setOnClickListener(this);
        button_abs = (Button) findViewById(R.id.button_abs);
        button_abs.setOnClickListener(this);
        button_clear = (Button) findViewById(R.id.button_clear);
        button_clear.setOnClickListener(this);
        button_equals = (Button) findViewById(R.id.button_equals);
        button_equals.setOnClickListener(this);
    }

    private void calcLogic(int operator) {
        try{
            math.add(Double.parseDouble(calculator_result.getText().toString()));
        }catch (NumberFormatException e){
            Toast.makeText(this,"Enter operand first",Toast.LENGTH_SHORT).show();
        }
        if (operator != EQUALS) {
            nextOperation = operator;
        } else {
            nextOperation = 0;
        }
        switch (currentOperation) {
            case ADD:
                first_number = math.get(0);
                second_number = math.get(1);
                math.removeAll(math);
                math.add(first_number + second_number);
                calculator_result.setText(String.format("%.3f", math.get(0)));
                break;
            case SUBTRACT:
                first_number = math.get(0);
                second_number = math.get(1);
                math.removeAll(math);
                math.add(first_number - second_number);
                calculator_result.setText(String.format("%.3f", math.get(0)));
                break;
            case MULTIPLY:
                first_number = math.get(0);
                second_number = math.get(1);
                math.removeAll(math);
                math.add(first_number * second_number);
                calculator_result.setText(String.format("%.3f", math.get(0)));
                break;
            case DIVISION:
                first_number = math.get(0);
                second_number = math.get(1);
                math.removeAll(math);
                math.add(first_number / second_number);
                calculator_result.setText(String.format("%.3f", math.get(0)));
                break;
            case POWER:
                first_number = math.get(0);
                second_number = math.get(1);
                math.removeAll(math);
                math.add(Math.pow(first_number, second_number));
                calculator_result.setText(String.format("%.3f", math.get(0)));
                break;
            //For the square root only put the number that you want obtain his square root and press equal
            case ROOT:
                first_number = math.get(0);
                second_number = math.get(1);
                math.removeAll(math);
                math.add(Math.sqrt(first_number));
                calculator_result.setText(String.format("%.3f", math.get(0)));
                break;
            //For the absolute number only put the number that you want obtain his absolute and press equal
            case ABS:
                first_number = math.get(0);
                second_number = math.get(1);
                math.removeAll(math);
                math.add(Math.abs(first_number));
                calculator_result.setText(String.format("%.3f", math.get(0)));
                break;
        }
        clearDisplay = CLEAR;
        currentOperation = nextOperation;
        if (operator == EQUALS) {
            first_number = 0;
            second_number = 0;
            math.removeAll(math);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number_one:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("1");
                calculator_preview.append("1");
                break;

            case R.id.number_two:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("2");
                calculator_preview.append("2");
                break;

            case R.id.number_three:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("3");
                calculator_preview.append("3");
                break;

            case R.id.number_four:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("4");
                calculator_preview.append("4");
                break;

            case R.id.number_five:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("5");
                calculator_preview.append("5");
                break;

            case R.id.number_six:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("6");
                calculator_preview.append("6");
                break;

            case R.id.number_seven:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("7");
                calculator_preview.append("7");
                break;

            case R.id.number_eight:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("8");
                calculator_preview.append("8");
                break;

            case R.id.number_nine:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("9");
                calculator_preview.append("9");
                break;

            case R.id.number_zero:
                if (clearDisplay == CLEAR) {
                    calculator_result.setText("");
                }
                clearDisplay = DONT_CLEAR;
                calculator_result.append("0");
                calculator_preview.append("0");
                break;

            case R.id.button_plus:
                calculator_preview.setText(calculator_preview.getText() + "+");
                calcLogic(ADD);
                break;
            case R.id.button_minus:
                calculator_preview.setText(calculator_preview.getText() + "-");
                calcLogic(SUBTRACT);
                break;
            case R.id.button_multiply:
                calculator_preview.setText(calculator_preview.getText() + "x");
                calcLogic(MULTIPLY);
                break;
            case R.id.button_divide:
                calculator_preview.setText(calculator_preview.getText() + "÷");
                calcLogic(DIVISION);
                break;
            case R.id.button_power:
                calculator_preview.setText(calculator_preview.getText() + "^");
                calcLogic(POWER);
                break;
            case R.id.button_root:
                calculator_preview.setText(calculator_preview.getText() + "√");
                calcLogic(ROOT);
                break;
            case R.id.button_abs:
                calcLogic(ABS);
                break;
            case R.id.button_equals:
                calcLogic(EQUALS);
                break;
            case R.id.button_clear:
                calculator_result.setText("0");
                calculator_preview.setText("0");
                first_number = 0;
                second_number = 0;
                math.removeAll(math);
                currentOperation = 0;
                nextOperation = 0;
                break;
        }
    }
}
