package Models;

public class Package {
    
    // Define VAriables
    int package_id;
    String package_name;
    String package_code;
    int package_cost;

    // Call default constructor
    public Package() {
    }

    public Package(String package_name, String package_code, int package_cost) {
        this.package_name = package_name;
        this.package_code = package_code;
        this.package_cost = package_cost;
    }

    // Create Getters and Setters to access private variables

    public int getPackageId() {
        return package_id;
    }

    public void setPackageId(int package_id) {
        this.package_id = package_id;
    }

    public String getPackageName() {
        return package_name;
    }

    public void setPackageName(String package_name) {
        this.package_name = package_name;
    }

    public String getPackageCode() {
        return package_code;
    }

    public void setPackageCode(String package_code) {
        this.package_code = package_code;
    }

    public int getPackageCost() {
        return package_cost;
    }

    public void setPackageCost(int package_cost) {
        this.package_cost = package_cost;
    }
       
       
    
}
