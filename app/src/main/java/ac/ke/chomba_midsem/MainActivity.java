package ac.ke.chomba_midsem;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextEmail,editTextPassword;

    Button signin;

    TextView signup;

    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

         editTextEmail= findViewById(R.id.email);
         editTextPassword=findViewById(R.id.password);
         signin=findViewById(R.id.sign_in);
         signup=findViewById(R.id.sign_up);

         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this,RegisterPage.class);
                 startActivity(intent);
                 finish();
             }
         });

         signin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String email,password;
                 email = String.valueOf(editTextEmail.getText());
                 password = String.valueOf(editTextPassword.getText());
                 if (TextUtils.isEmpty(email)){
                     Toast.makeText(MainActivity.this,"enter email",Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if (TextUtils.isEmpty(password)){
                     Toast.makeText(MainActivity.this,"enter password",Toast.LENGTH_SHORT).show();
                     return;
                 }
                 firebaseAuth.signInWithEmailAndPassword(email,password)
                         .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if(task.isSuccessful()){
                                     Toast.makeText(MainActivity.this,"login successful",Toast.LENGTH_SHORT).show();
                                     Intent intent= new Intent(MainActivity.this,HomePage.class);
                                     startActivity(intent);
                                     finish();
                                 }
                                 else{
                                     Toast.makeText(MainActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                                 }
                             }
                         });
             }
         });



    }
}