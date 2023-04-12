package id.co.travel.fun.model;

import jakarta.persistence.*;

@Entity
@Table(name = "package")
public class Package {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "package_price")
    private int packagePrice;
    @Column(name = "package_desc")
    private String packageDesc;

    public Package() {
    }

    public Package(int id, String packageName, int packagePrice, String packageDesc) {
        this.id = id;
        this.packageName = packageName;
        this.packagePrice = packagePrice;
        this.packageDesc = packageDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(int packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }
}
