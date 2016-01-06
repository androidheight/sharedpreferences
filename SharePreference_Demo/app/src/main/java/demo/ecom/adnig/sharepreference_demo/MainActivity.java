package demo.ecom.adnig.sharepreference_demo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    EditText etName,etEmail;
    Button btnSubmit,btnNextActivity;
    String name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etemail);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnNextActivity = (Button)findViewById(R.id.btnLink);



        // initilze sharedPreferences

        mSharedPreferences= getApplicationContext().getSharedPreferences("myprefence", Context.MODE_PRIVATE);
        mEditor= mSharedPreferences.edit();




btnSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        if(!(name.equals("")) && !(email.equals(""))) {
            mEditor.putString("name", name);
            mEditor.putString("email", email);
            mEditor.commit();
            Toast.makeText(MainActivity.this,"Your data save in Share Preferences",Toast.LENGTH_LONG).show();
        }

    }
});

        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
