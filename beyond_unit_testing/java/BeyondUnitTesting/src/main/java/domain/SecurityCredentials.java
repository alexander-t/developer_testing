package domain;

public class SecurityCredentials {
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
