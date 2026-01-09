package components;

import enums.PackageType;

public class Package {
    private double weight;
    private double length;
    private double width;
    private double height;
    private PackageType type;

    public Package(double weight, double length, double width, double height, PackageType type) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }
}
