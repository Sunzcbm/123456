package com.example.zhanghao;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int DengLu = 1;

    Button D_deng;
    Button D_zhu;
    EditText D_number;
    EditText D_pas;

    String _number,_pas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        D_deng = findViewById(R.id.D_deng);
        D_zhu = findViewById(R.id.D_zhu);
        D_number = findViewById(R.id.D_number);
        D_pas = findViewById(R.id.D_pas);

        D_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,DengLu);
            }
        });
        D_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_number.equals(D_number.getText().toString()) &&
                _pas.equals(D_pas.getText().toString())){
                    Toast.makeText(MainActivity.this, "登陆成功!", Toast.LENGTH_SHORT).show();
                    Intent intent = null;
                    intent = new Intent(MainActivity.this,Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "账号或密码错误,请重新登陆!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DengLu){
            if (resultCode == RESULT_OK){
                String number1 = data.getStringExtra("number");
                String pas1 = data.getStringExtra("pas");
                D_number.setText(number1);
                D_pas.setText(pas1);
                _number = number1;
                _pas = pas1;
            }
        }
    }
}