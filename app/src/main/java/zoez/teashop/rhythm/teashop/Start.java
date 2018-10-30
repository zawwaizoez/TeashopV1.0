package zoez.teashop.rhythm.teashop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Start extends AppCompatActivity {
    private RadioButton rdZawgyi,rdUnicode;
    private RadioGroup radioGroup;
    private Button btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        initComponent();

        SharedPreferences sharedPreferences = getSharedPreferences("ALL_DATA",MODE_PRIVATE);
        final String font_selected = sharedPreferences.getString("FONT_SELECTED", "false");
        final String is_login = sharedPreferences.getString("IS_LOGIN", "false");
        if(font_selected.equals("true"))
            {
                if (is_login.equals("false"))
                {
                    goToRegister();
                }
                else if(is_login.equals("true"))
                {
                    goToMain();
                }

            }

        btnContinue.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btnContinueMethod();
            }
        });

    }

    private void goToMain() {
        Intent intent = new Intent(Start.this,Main.class);
        startActivity(intent);
        finish();
    }

    private void goToRegister() {
        Intent intent = new Intent(Start.this,Register.class);
        startActivity(intent);
        finish();
    }

    private void initComponent() {

        rdZawgyi=(RadioButton)findViewById(R.id.rdZawgyi);
        rdUnicode=(RadioButton)findViewById(R.id.rdUnicode);
        btnContinue=(Button)findViewById(R.id.btnContinue);

    }
    private void btnContinueMethod(){
        if(rdZawgyi.isChecked())
        {
            SharedPreferences sharedPreferences = getSharedPreferences("ALL_DATA",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("FONT","zawgyi");
            editor.putString("FONT_SELECTED","true");
            editor.commit();
            goToRegister();

        }
        else if(rdUnicode.isChecked())
        {
            SharedPreferences sharedPreferences = getSharedPreferences("ALL_DATA",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("FONT","unicode");
            editor.putString("FONT_SELECTED","true");
            editor.commit();
            goToRegister();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Select Font !",Toast.LENGTH_SHORT).show();
        }
    }
}
