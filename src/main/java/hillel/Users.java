package hillel;

public enum Users {

    BILL("Bill"),
    SAM("Sam"),
    TOM("Tom"),
    STEVE("Steve"),
    LUCK("Luck");

    private String code;

    Users(String code) {
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
