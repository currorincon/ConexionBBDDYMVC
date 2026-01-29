package model;

public class Bus {

    public String license;
    public String registrer;
    public String type;


    public Bus(String license, String registrer, String type) {
        this.license = license;
        this.registrer = registrer;
        this.type = type;
    }

    public Bus(){

    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getRegistrer() {
        return registrer;
    }

    public void setRegistrer(String registrer) {
        this.registrer = registrer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "license='" + license + '\'' +
                ", registrer='" + registrer + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
