package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_QUANTITY = 4;
    Button button,button2,button3,button4,button5,button6,button7;
    EditText editTextText,editTextText2,editTextText3,editTextText4,editTextText5,editTextText6,editTextText7,editTextText8,editTextText9;
    EditText editTextText10,editTextText11,editTextText12,editTextText13,editTextText14,editTextText15;
    private int itemCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);

        editTextText=findViewById(R.id.editTextText);
        editTextText2=findViewById(R.id.editTextText2);
        editTextText3=findViewById(R.id.editTextText3);
        editTextText4=findViewById(R.id.editTextText4);
        editTextText5=findViewById(R.id.editTextText5);
        editTextText6=findViewById(R.id.editTextText6);
        editTextText7=findViewById(R.id.editTextText7);
        editTextText8=findViewById(R.id.editTextText8);
        editTextText9=findViewById(R.id.editTextText9);
        editTextText10=findViewById(R.id.editTextText10);
        editTextText11=findViewById(R.id.editTextText11);
        editTextText12=findViewById(R.id.editTextText12);
        editTextText13=findViewById(R.id.editTextText13);
        editTextText14=findViewById(R.id.editTextText14);
        editTextText15=findViewById(R.id.editTextText15);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemCount < MAX_QUANTITY) {
                    itemCount++;
                    updateTotalPrice();
                }                
            }
        });
    }

    private void updateTotalPrice() {
        double totalPrice = itemCount * getPriceForItem("Milk");
        editTextText.setText("Kshs." + String.format("%.2f", totalPrice));
    }

    private double getPriceForItem(String itemName) {
        switch (itemName) {
            case "Milk":
                return 60.00;
            case "Sugar":
                return 240.00;
            case "Flour":
                return 130.00;
            case "Bread":
                return 65.00;
            default:
                return 0.00;
        }
    }
}