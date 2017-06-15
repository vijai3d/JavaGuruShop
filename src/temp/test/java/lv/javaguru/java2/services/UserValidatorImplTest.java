package lv.javaguru.java2.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserValidatorImplTest {

    private UserValidator validator = new UserValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenFirstNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name must be not empty!");
        validator.validate(null, "password");
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name must be not empty!");
        validator.validate("", "password");
    }

    @Test
    public void shouldThrowExceptionWhenLastNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Last Name must be not empty!");
        validator.validate("foo", null);
    }

    @Test
    public void shouldThrowExceptionWhenLastNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Last Name must be not empty!");
        validator.validate("foo", "");
    }



    // too long first name and last name
    @Test
    public void shouldThrowExceptionWhenFirstNameIsTooLarge() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name is too long");
        validator.validate("ggggggggggggggggggggggggggggggggg", "password");
    }

    @Test
    public void shouldThrowExceptionWhenLastNameIsTooLarge() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Last Name is too long");
        validator.validate("foo", "ggggggggggggggggggggggggggggggggg");
    }
}