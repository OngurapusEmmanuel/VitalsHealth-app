package ongurapus.vitals_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
EditText username,password,confirmpassword;
Button btnregister,btnlogin;
DBhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirmpassword=findViewById(R.id.confirmpassword);
        btnregister=findViewById(R.id.register);
        btnlogin=findViewById(R.id.login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        dbHelper=new DBhelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String user,pwd,cpwd;
user=username.getText().toString();
pwd=password.getText().toString();
cpwd=confirmpassword.getText().toString();

if (user.equals("")||pwd.equals("")||cpwd.equals("")){
    Toast.makeText(RegisterActivity.this,"please fill all the fields!", Toast.LENGTH_LONG).show();
}

else{
    if (pwd.equals(cpwd)){
        if (dbHelper.checkUser(user)){
            Toast.makeText(RegisterActivity.this,"User already exists in the system",Toast.LENGTH_SHORT).show();
        return;

        }
        boolean registerSuccess;
        registerSuccess = dbHelper.insertData(user,pwd);
        if (registerSuccess){
            Toast.makeText(RegisterActivity.this,"User registered seccessfully",Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
            confirmpassword.setText("");
            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(RegisterActivity.this,"User registeration failed!",Toast.LENGTH_SHORT).show();
        }
    }else {
        Toast.makeText(RegisterActivity.this,"passwords do not match!", Toast.LENGTH_LONG).show();
    }
}
            }
        });

    }
}