package com.staxoverflow.demo.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface EmailValidator {

    default boolean validateUsername(String input) {
        Pattern pattern = Pattern.compile("^\\s*\\S+\\s*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    //checks if email is valid --> (must include [some string]@[some domain].com) <-- something like that
    default boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile(
                "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
                Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }
}
