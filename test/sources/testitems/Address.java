package sources.testitems;

public class Address {
    private String line;
    private String city;
    private String state;
    private Integer zip;
    // getters and setters

    public String getLine() {
        return line;
    }

    public Address setLine(String line) {
        this.line = line;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Integer getZip() {
        return zip;
    }

    public Address setZip(Integer zip) {
        this.zip = zip;
        return this;
    }
}
