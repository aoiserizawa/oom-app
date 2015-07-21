package com.serverus.oom;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignupActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText _userNameText;
    private EditText _nameText;
    private EditText _emailText;
    private EditText _passwordText;
    private EditText _confirmPasswordText;
    private TextInputLayout _nameLayout;
    private TextInputLayout _userNameLayout;
    private TextInputLayout _emailLayout;
    private TextInputLayout _passwordLayout;
    private TextInputLayout _confirmPasswordLayout;
    private Button _signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initToolBar();
        initViews();

        _signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        String userName = _userNameText.getText().toString();
        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if(!validate()){
            return;
        }

        _signupBtn.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        ParseUser user = new ParseUser();
        user.setUsername(userName);
        user.put("name", name.toLowerCase());
        user.setPassword(password);
        user.setEmail(email);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    progressDialog.dismiss();
                    _signupBtn.setEnabled(true);
                    Toast.makeText(getApplicationContext(),
                            "Successfully Signed up, please log in.",
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(),
                            e.getMessage(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    _signupBtn.setEnabled(true);
                }
            }
        });
    }

    private boolean validate() {
        boolean valid = true;

        String userName = _userNameText.getText().toString();
        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String confirmPassword = _confirmPasswordText.getText().toString();

        if(userName.isEmpty() || name.length() < 3){
            _userNameLayout.setErrorEnabled(true);
            _userNameLayout.setError("Username must be at least 3 charactes");
            valid = false;
        }else{
            _userNameLayout.setError(null);
        }


        if(name.isEmpty() || name.length() < 3){
            _nameLayout.setErrorEnabled(true);
            _nameLayout.setError("name must be at least 3 charactes");
            valid = false;
        }else{
            _confirmPasswordLayout.setError(null);
        }

        if(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            _emailLayout.setErrorEnabled(true);
            _emailLayout.setError("enter a valid email address");
            valid = false;
        }else{
            _emailLayout.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordLayout.setErrorEnabled(true);
            _passwordLayout.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordLayout.setError(null);
        }

        if(!(password.equals(confirmPassword))){
            _confirmPasswordLayout.setErrorEnabled(true);
            _confirmPasswordLayout.setError("password and confirm password didn't match");
            valid = false;
        }else{
            _confirmPasswordLayout.setError(null);
        }

        return valid;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == android.R.id.home){
            // emulate the back hardware press of the device
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolBar(){
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initViews(){
        _userNameText = (EditText) findViewById(R.id.edit_text_username);
        _nameText = (EditText) findViewById(R.id.edit_text_name);
        _emailText = (EditText) findViewById(R.id.edit_text_email);
        _passwordText = (EditText) findViewById(R.id.edit_text_password);
        _confirmPasswordText = (EditText) findViewById(R.id.edit_text_passwordConfirm);

        _userNameLayout = (TextInputLayout) findViewById(R.id.username_layout);
        _nameLayout = (TextInputLayout) findViewById(R.id.name_layout);
        _emailLayout = (TextInputLayout) findViewById(R.id.email_layout);
        _passwordLayout = (TextInputLayout) findViewById(R.id.password_layout);
        _confirmPasswordLayout = (TextInputLayout) findViewById(R.id.passwordConfirm_layout);

        _signupBtn = (Button) findViewById(R.id.signup_button);
    }

}
