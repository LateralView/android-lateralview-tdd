package lateralview.co.testapp;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;

import javax.inject.Inject;

import lateralview.co.testapp.activities.MainActivity;
import lateralview.co.testapp.common.AndroidTDDApplication;
import lateralview.co.testapp.components.DaggerDiComponent;
import lateralview.co.testapp.utils.EmailValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SmallTest
public class EmailValidatorTest {

    EmailValidator mEmailValidator;

    @Before
    public void setUp() {
        mEmailValidator = new EmailValidator();
    }

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(mEmailValidator.isValidEmail("name@email.com"));
    }

    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(mEmailValidator.isValidEmail("name@email.co.uk"));
    }

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(mEmailValidator.isValidEmail("name@email"));
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(mEmailValidator.isValidEmail("name@email..com"));
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(mEmailValidator.isValidEmail("@email.com"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(mEmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(mEmailValidator.isValidEmail(null));
    }
}