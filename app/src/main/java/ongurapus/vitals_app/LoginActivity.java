package ongurapus.vitals_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
DBhelper dbHelper;
    TextView username,password;

    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.lusername);
        password=findViewById(R.id.lpassword);
//        register.findViewById(R.id.btnregister);
//        register.setOnClickListener(v -> {
//            Intent intent1=new Intent(LoginActivity.this,RegisterActivity.class);
//            startActivity(intent1);
//
//        });
        login=findViewById(R.id.llogin);
        login.setOnClickListener(v -> {
            String user,pwd;
            user=username.getText().toString();
            pwd=password.getText().toString();

            if (user.isEmpty() || pwd.isEmpty()){
                Toast.makeText(LoginActivity.this,"please fill all the fields!", Toast.LENGTH_LONG).show();
            }

            if (dbHelper.login(user, pwd)) {
                // User login successful
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                // Proceed to your main activity or any other action
                Intent intent = new Intent(LoginActivity.this, jj.class);
                startActivity(intent);
            } else {
                // User login failed
                Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
