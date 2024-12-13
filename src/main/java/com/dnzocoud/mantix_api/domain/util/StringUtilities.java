package com.dnzocoud.mantix_api.domain.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtilities {
    /**
     * Validar si un email es valido en cuanto a estrcutura (SOLO PARA CAPA DE
     * DOMINIO)
     * 
     * @param email
     * @return true o false dependiendo el caso
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
