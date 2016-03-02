package lateralview.co.testapp;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import lateralview.co.testapp.activities.MainActivity;
import lateralview.co.testapp.activities.OptionAActivity;
import lateralview.co.testapp.activities.OptionBActivity;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.robolectric.Shadows.shadowOf;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest{
    @Mock
    Context mMockContext;

    private MainActivity mainActivity;
    private OptionAActivity activityA;
    private OptionBActivity activityB;

    Button btn;
    Switch swt;
    EditText etName,etEmail,etPassword;

    @Before
    public void setUp() throws Exception {
        activityA = Robolectric.setupActivity(OptionAActivity.class);
        activityB = Robolectric.setupActivity(OptionBActivity.class);
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        btn = (Button)mainActivity.findViewById(R.id.sign_up_bt_sign_up);
        swt = (Switch)mainActivity.findViewById(R.id.option_switch);
        etName = (EditText)mainActivity.findViewById(R.id.activity_sign_up_name);
        etEmail = (EditText)mainActivity.findViewById(R.id.activity_sign_up_email);
        etPassword = (EditText)mainActivity.findViewById(R.id.activity_sign_up_password);
    }

    @Test
    public void onClickAndSwitchTrueOptionA() {
        ShadowActivity shadowActivity = shadowOf(mainActivity);

        swt.setChecked(Boolean.TRUE);
        etName.setText("John Doe");
        etEmail.setText("john@doe.com");
        etPassword.setText("12345678");
        btn.performClick();

        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        Intent expectedIntent = new Intent(mainActivity, OptionAActivity.class);
        assertEquals(shadowIntent, expectedIntent);

    }

    @Test
    public void onClickAndSwitchTrueOptionB() {
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        swt.setChecked(Boolean.FALSE);
        etName.setText("John Doe");
        etEmail.setText("john@doe.com");
        etPassword.setText("12345678");
        btn.performClick();

        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        Intent expectedIntent = new Intent(mainActivity, OptionBActivity.class);
        assertEquals(shadowIntent, expectedIntent);
    }

    @Test
    public void formShouldBeValid() {
        etName.setText("John Doe");
        etEmail.setText("john@doe.com");
        etPassword.setText("12345678");

        assertTrue("Valid Fields Data", mainActivity.validateData());
    }

    @Test
    public void formShouldBeInValidBecauseEmail() {
        etName.setText("John Doe");
        etEmail.setText("doe.com");
        etPassword.setText("12345678");

        assertFalse("Invalid Email", mainActivity.validateData());
    }

    @Test
    public void formShouldBeInValidBecauseName() {
        etName.setText("");
        etEmail.setText("john@doe.com");
        etPassword.setText("12345678");

        assertFalse("Invalid Name", mainActivity.validateData());
    }

    @Test
    public void formShouldBeInValidBecausePassword() {
        etName.setText("John Doe");
        etEmail.setText("john@doe.com");
        etPassword.setText("");

        assertFalse("Invalid Password", mainActivity.validateData());
    }

}