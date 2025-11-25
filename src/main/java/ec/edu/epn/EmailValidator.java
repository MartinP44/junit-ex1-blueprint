package ec.edu.epn;

public class EmailValidator {

    /**
     * Validates if the provided email has a basic valid format.
     * @param email The email address to validate.
     * @return true if the email is valid, false otherwise.
     */
    public boolean isValid(String email){
        return email != null && email.contains("@") && email.contains(".");
    }

}
