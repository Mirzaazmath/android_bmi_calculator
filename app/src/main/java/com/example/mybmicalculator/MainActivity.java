package com.example.mybmicalculator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    // Here we are creating variables
    EditText heightFT,heightIn,weight;
    Button submitBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Here we are assigning the values to the variable
        heightFT =findViewById(R.id.editHeightFt);
        heightIn = findViewById(R.id.editHeightIN);
        weight = findViewById(R.id.editWeight);
        submitBtn = findViewById(R.id.submitBtn);

       submitBtn.setOnClickListener((v)->{
           // Here we are getting
           int ft= Integer.parseInt(heightFT.getText().toString());
           int in= Integer.parseInt(heightIn.getText().toString());
           int wt= Integer.parseInt(weight.getText().toString());

           // Here we are getting  total Inches
           int totalIN = ft * 12 +in;
           // Here we are getting  total Centimeter
           double totalCM= totalIN*2.53;
           // Here we are getting  total Meter
           double totalM = totalCM/100;
           // Here we are getting  total BMI
           double totalBMI = wt/(totalM*totalM);

           if(totalBMI>25){
               System.out.println("OverWeight");
               // OverWeight
           }else if(totalBMI<18){
               // UnderWeight
               System.out.println("UnderWeight");

           }else {
               // Healthy
               System.out.println("Healthy");
           }

       });




    }
}