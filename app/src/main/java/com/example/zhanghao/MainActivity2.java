package com.example.zhanghao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button Z_zhu;
    Button Z_deng;
    EditText Z_number;
    EditText Z_pas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Z_number = findViewById(R.id.Z_number);
        Z_pas = findViewById(R.id.Z_pas);
        Z_zhu = findViewById(R.id.Z_zhu);
        Z_deng = findViewById(R.id.Z_deng);

        Z_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Toast.makeText(MainActivity2.this, "注册成功", Toast.LENGTH_SHORT).show();
            }
        });

        Z_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("number",Z_number.getText().toString());
                intent.putExtra("pas",Z_pas.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}