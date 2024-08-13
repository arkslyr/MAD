package com.example.mycalc;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bd, bc, beq, add, sub, div, mul, clr;
    EditText e1;
    List<String> operations = new ArrayList<>();
    List<Float> numbers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bd = findViewById(R.id.bd);
        beq = findViewById(R.id.beq);
        bc = findViewById(R.id.clr);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);
        clr = findViewById(R.id.clr);
        e1 = findViewById(R.id.e1);

        // Number buttons
        b0.setOnClickListener(view -> e1.setText(e1.getText() + "0"));
        b1.setOnClickListener(view -> e1.setText(e1.getText() + "1"));
        b2.setOnClickListener(view -> e1.setText(e1.getText() + "2"));
        b3.setOnClickListener(view -> e1.setText(e1.getText() + "3"));
        b4.setOnClickListener(view -> e1.setText(e1.getText() + "4"));
        b5.setOnClickListener(view -> e1.setText(e1.getText() + "5"));
        b6.setOnClickListener(view -> e1.setText(e1.getText() + "6"));
        b7.setOnClickListener(view -> e1.setText(e1.getText() + "7"));
        b8.setOnClickListener(view -> e1.setText(e1.getText() + "8"));
        b9.setOnClickListener(view -> e1.setText(e1.getText() + "9"));

        add.setOnClickListener(view -> handleOperator("+"));
        sub.setOnClickListener(view -> handleOperator("-"));
        mul.setOnClickListener(view -> handleOperator("*"));
        div.setOnClickListener(view -> handleOperator("/"));

        beq.setOnClickListener(view -> {
            if (!e1.getText().toString().isEmpty()) {
                numbers.add(Float.parseFloat(e1.getText().toString()));
                float result = calculateResult();
                e1.setText(String.valueOf(result));
                operations.clear();
                numbers.clear();
            }
        });

        // Clear button
        clr.setOnClickListener(view -> {
            e1.setText("");
            operations.clear();
            numbers.clear();
        });
    }

    private void handleOperator(String operator) {
        if (!e1.getText().toString().isEmpty()) {
            numbers.add(Float.parseFloat(e1.getText().toString()));
            operations.add(operator);
            e1.setText("");
        }
    }

    private float calculateResult() {
        float result = numbers.get(0);

        for (int i = 0; i < operations.size(); i++) {
            String operator = operations.get(i);
            float nextNumber = numbers.get(i + 1);

            switch (operator) {
                case "+":
                    result += nextNumber;
                    break;
                case "-":
                    result -= nextNumber;
                    break;
                case "*":
                    result *= nextNumber;
                    break;
                case "/":
                    result /= nextNumber;
                    break;
            }
        }

        return result;
    }
}
