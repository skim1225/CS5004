public class Email {
    private String user;
    private String domain;

    public Email(String user, String domain) {
        this.user = user;
        this.domain = domain;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "Email{" +
                "user='" + user + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
