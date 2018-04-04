package business;

import java.util.regex.Pattern;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class Validator {

    public static final String STRONG = "S";
    public static final String WEAK = "W";

    public static boolean isWellFormed(String string, int length, String type){

        if(type.equals(STRONG)) return length ==string.length();
        if(type.equals(WEAK)) return length >= string.length();
        return false;
    }

    public void validatePhone(int phoneno){
        if(phoneno < 700000000 || phoneno > 799999999){
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    public void validateEmail(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Invalid e-mail");
        }
    }






}
