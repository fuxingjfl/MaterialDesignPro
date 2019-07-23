package mdp.xha.com.materialdesignpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ysq on 2019/7/22.
 */

public class LoginActivity extends AppCompatActivity {


    private TextInputLayout til_name,til_password;
    private EditText et_name,et_password;
    private Button btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        til_name=findViewById(R.id.til_name);
        til_password=findViewById(R.id.til_password);
        et_name=findViewById(R.id.et_name);
        et_password=findViewById(R.id.et_password);
        btn_login=findViewById(R.id.btn_login);
        til_name.setError("用户名为空");
        til_name.setErrorEnabled(true);
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pw = s.toString().trim();
                if (pw.length()<5||pw.length()>10){
                    til_password.setError("密码不得小于4位大于9位");
                    til_password.setErrorEnabled(true);
                }else{
                    til_password.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String pw = s.toString().trim();
                if (pw.length()<5||pw.length()>10){
                    til_password.setError("密码不得小于4位大于9位");
                    til_password.setErrorEnabled(true);
                }else{
                    til_password.setErrorEnabled(false);
                }

            }
        });
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = s.toString().trim();
                if (name.length()<=0){
                    til_name.setError("用户名为空");
                    til_name.setErrorEnabled(true);
                }else{
                    til_name.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String name = s.toString().trim();
                if (name.length()<=0){
                    til_name.setError("用户名为空");
                    til_name.setErrorEnabled(true);
                }else{
                    til_name.setErrorEnabled(false);
                }
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
    }


}
