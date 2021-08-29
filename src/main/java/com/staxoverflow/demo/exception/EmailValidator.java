package com.staxoverflow.demo.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface EmailValidator {

    default boolean validateString(String input) {
        return input.contains("@");
    }
}
