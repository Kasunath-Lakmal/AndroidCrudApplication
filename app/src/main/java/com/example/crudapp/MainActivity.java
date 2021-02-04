package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_name,editText_email;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = (EditText)findViewById(R.id.edittext_name);
        editText_email = (EditText)findViewById(R.id.edittext_email);
        button_add = (Button)findViewById(R.id.button_add);
        button_view = (Button)findViewById(R.id.button_view);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String StringName = editText_name.getText().toString();
                String StringEmail = editText_email.getText().toString();

                if(StringName.length() <=0 || StringEmail.length() <=0)
                {
                    Toast.makeText(MainActivity.this,"Enter All Data", Toast.LENGTH_SHORT);
                }
                else
                {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    EmployeeModelClass employeeModelClass = new EmployeeModelClass(StringName,StringEmail);
                    databaseHelperClass.addEmployee(employeeModelClass);
                    Toast.makeText(MainActivity.this, "Add Employee Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewEmployeeActivity.class);
                startActivity(intent);
            }
        });


    }
}