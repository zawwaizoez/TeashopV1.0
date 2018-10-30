package zoez.teashop.rhythm.teashop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private Button btnAccountVerify;
    private TextInputEditText et1,et2,et3,et4;
    private String s1,s2,s3,s4,code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
       initComponent();
       btnAccountVerify.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {
               btnAccountVerifyMethod();
           }
       });


    }

    private void btnAccountVerifyMethod() {
        s1= et1.getText().toString();
        s2= et2.getText().toString();
        s3= et3.getText().toString();
        s4= et4.getText().toString();
        code=s1+s2+s3+s4;
        if(code.equals("1234"))
        {
            SharedPreferences sharedPreferences = getSharedPreferences("ALL_DATA",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("IS_LOGIN","true");
            editor.commit();
            Intent intent = new Intent(Register.this,Main.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Your code is wrong",Toast.LENGTH_SHORT).show();
        }

    }

    private void initComponent() {
        btnAccountVerify=(Button)findViewById(R.id.btnAccountVerify);
        et1=(TextInputEditText)findViewById(R.id.et1);
        et2=(TextInputEditText)findViewById(R.id.et2);
        et3=(TextInputEditText)findViewById(R.id.et3);
        et4=(TextInputEditText)findViewById(R.id.et4);


    }
}
