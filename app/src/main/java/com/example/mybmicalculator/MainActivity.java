package com.example.mybmicalculator;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
           // Here we are creating  a variable to store our dialog
           Dialog resultDialog=new Dialog(this);
           resultDialog.setContentView(R.layout.custom_dailog_layout);
           TextView title, context;
           Button closeBtn, okBtn;
           LinearLayout header;

           title = resultDialog.findViewById(R.id.dialogTitle);
           context = resultDialog.findViewById(R.id.dialogContext);
           closeBtn = resultDialog.findViewById(R.id.dialogClose);
           okBtn = resultDialog.findViewById(R.id.dialogOk);
           header = resultDialog.findViewById(R.id.dialogHeadBg);
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
               title.setText("OverWeight");
               context.setText("You have to lose sum weight");
               header.setBackgroundColor(getColor(R.color.red));

               // OverWeight
           }else if(totalBMI<18){
               // UnderWeight
               System.out.println("UnderWeight");
               title.setText("UnderWeight");
               context.setText("You have to gain sum weight");
               header.setBackgroundColor(getColor(R.color.yellow));

           }else {
               // Healthy
               System.out.println("Healthy");
               title.setText("Healthy");
               context.setText("You have perfect weight");
               header.setBackgroundColor(getColor(R.color.green));
           }
           resultDialog.show();
           closeBtn.setOnClickListener((v1 -> {
               resultDialog.dismiss();
              Toast.makeText(getApplicationContext(),"You have Pressed Close Button",Toast.LENGTH_LONG).show();

           }));
           okBtn.setOnClickListener((v1 -> {
               resultDialog.dismiss();
               Toast.makeText(getApplicationContext(),"You have Pressed Okay Button",Toast.LENGTH_LONG).show();

           }));

       });




    }
}