package lateralview.co.testapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import lateralview.co.testapp.R;
import lateralview.co.testapp.common.Constants;
import lateralview.co.testapp.utils.EmailValidator;

public class MainActivity extends AppCompatActivity {

    private EditText _etName;
    private EditText _etEmail;
    private EditText _etPassword;
    private Button _btnDone;
    private Switch _swFlowSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeControls();
    }

    private void initializeControls(){
        _etName = (EditText)findViewById(R.id.activity_sign_up_name);
        _etEmail = (EditText)findViewById(R.id.activity_sign_up_email);
        _etPassword = (EditText)findViewById(R.id.activity_sign_up_password);
        _btnDone = (Button)findViewById(R.id.sign_up_bt_sign_up);
        _swFlowSelector = (Switch)findViewById(R.id.option_switch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void doAcceptForm(View v){
        if(validateData()){
            Intent i;
            if(_swFlowSelector.isChecked()){
                i = new Intent(this,OptionAActivity.class);
            }else{
                i = new Intent(this,OptionBActivity.class);
            }
            startActivity(i);
        }
    }

    public boolean validateData() {
        if (_etName.getText() == null || _etName.getText().toString().matches("") || !_etName.getText().toString().matches(Constants.REGEX_CHARS)) {
            Toast.makeText(this, getString(R.string.sign_up_name_error), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (_etEmail.getText() == null || !EmailValidator.isValidEmail(_etEmail.getText())) {
            Toast.makeText(this, getString(R.string.sign_up_email_error), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (_etPassword.getText() == null || _etPassword.getText().toString().matches("") || !_etPassword.getText().toString().matches(Constants.REGEX_CHARS_NUMBERS)) {
            Toast.makeText(this, getString(R.string.sign_up_password_error), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
