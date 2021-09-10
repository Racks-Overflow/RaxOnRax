package com.staxoverflow.demo.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validator {
    // checks for white spacing in username
    default boolean validateUsername(String input) {
        Pattern pattern = Pattern.compile("^\\s*\\S+\\s*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // checks if email is valid --> (must include [some string]@[some domain].com) <-- something like that
    default boolean validateEmail(String email) {
        final Pattern emailRegex = Pattern.compile(
                "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
                Pattern.CASE_INSENSITIVE);
        return emailRegex.matcher(email).matches();
    }

    // checks password strength (must include AT LEAST one special character//number//be at least 8-20 chars
    default boolean validatePassword(String password) {
        final Pattern passwordRegex = Pattern.compile(
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",
                Pattern.CASE_INSENSITIVE);
        return passwordRegex.matcher(password).matches();
    }
}
