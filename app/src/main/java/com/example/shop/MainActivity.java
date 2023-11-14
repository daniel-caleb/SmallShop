package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_QUANTITY = 4;
    Button button,button2,button3,button4,button5,button6,button7;
    EditText editTextText,editTextText2,editTextText3,editTextText4,editTextText5,editTextText6,editTextText7,editTextText8,editTextText9;
    EditText editTextText10,editTextText11,editTextText12,editTextText13,editTextText14,editTextText15;
    private int itemMilkCount = 0;
    private int itemSugarCount = 0;
    private int itemFlourCount = 0;
    private int itemBreadCount = 0;

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
                if (itemMilkCount < MAX_QUANTITY) {
                    itemMilkCount++;
                    updateMilkPrice();
                }                
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemSugarCount < MAX_QUANTITY) {
                    itemSugarCount++;
                    updateSugarPrice();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemFlourCount < MAX_QUANTITY) {
                    itemFlourCount++;
                    updateFlourPrice();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemBreadCount < MAX_QUANTITY) {
                    itemBreadCount++;
                    updateBreadPrice();
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate Grand Total and update EditText view
                double grandTotal = calculateGrandTotal();
                editTextText13.setText("Kshs." + String.format("%.2f", grandTotal));
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate Discount and update EditText view
                double grandTotal = calculateGrandTotal();
                double discount = calculateDiscount(grandTotal);
                editTextText14.setText("Kshs." + String.format("%.2f", discount));
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate Net Pay and update EditText view
                double grandTotal = calculateGrandTotal();
                double discount = calculateDiscount(grandTotal);
                double netPay = grandTotal - discount;
                editTextText15.setText("Kshs." + String.format("%.2f", netPay));
            }
        });
    }

    private void updateMilkPrice() {
        double itemMilkPrice = itemMilkCount * getPriceForItem("Milk");
        double vat = 0.16 * itemMilkPrice;
        double actualPrice = itemMilkPrice - vat;
        editTextText.setText("Kshs." + String.format("%.2f", itemMilkPrice));
        editTextText2.setText("KES." + String.format("%.2f", vat));
        editTextText3.setText("Kshs." + String.format("%.2f", actualPrice));

    }
    private void updateSugarPrice() {
        double itemSugarPrice = itemSugarCount * getPriceForItem("Sugar");
        double vat = 0.16 * itemSugarPrice;
        double actualPrice = itemSugarPrice - vat;
        editTextText4.setText("Kshs." + String.format("%.2f", itemSugarPrice));
        editTextText5.setText("KES." + String.format("%.2f", vat));
        editTextText6.setText("Kshs." + String.format("%.2f", actualPrice));
    }
    private void updateFlourPrice() {
        double itemFlourPrice = itemFlourCount * getPriceForItem("Flour");
        double vat = 0.16 * itemFlourPrice;
        double actualPrice = itemFlourPrice - vat;
        editTextText10.setText("Kshs." + String.format("%.2f", itemFlourPrice));
        editTextText8.setText("KES." + String.format("%.2f", vat));
        editTextText9.setText("Kshs." + String.format("%.2f", actualPrice));
    }
    private void updateBreadPrice() {
        double itemBreadPrice = itemBreadCount * getPriceForItem("Bread");
        double vat = 0.16 * itemBreadPrice;
        double actualPrice = itemBreadPrice - vat;
        editTextText7.setText("Kshs." + String.format("%.2f", itemBreadPrice));
        editTextText11.setText("KES." + String.format("%.2f", vat));
        editTextText12.setText("Kshs." + String.format("%.2f", actualPrice));
    }
    private double calculateGrandTotal() {;
        // Sum up the Actual Price for all items
        double grandTotal = getPriceForItem("Milk")
                + getPriceForItem("Sugar")
                + getPriceForItem("Flour")
                + getPriceForItem("Bread");

        return grandTotal;
    }

    private double calculateDiscount(double grandTotal) {
        // Apply a 15% discount if the Grand Total exceeds 10,000
        if (grandTotal > 10000) {
            return 0.15 * grandTotal;
        } else {
            // No discount
            showToast("No discount awarded.");
            return 0;
        }
    }

    private double getPriceForItem(String itemName) {
        switch (itemName) {
            case "Milk":
                return 71.43;
            case "Sugar":
                return 285.72;
            case "Flour":
                return 154.77;
            case "Bread":
                return 77.40;
            default:
                return 0.00;
        }
    }

    private void showToast(String s) {
        Toast.makeText(this, "Thank You For Shopping With Us!", Toast.LENGTH_SHORT).show();
    }
    }