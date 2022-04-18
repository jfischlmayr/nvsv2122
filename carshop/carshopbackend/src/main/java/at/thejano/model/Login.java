package at.thejano.model;

public class Login {
    public String userName;
    public String password;

    public static class LoginResult {
        /* much wow */
        public String token;

        public LoginResult(String jwt) {
            this.token = jwt;
        }
    }
}
