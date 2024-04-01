package PHAN_CONG_LAI_XE_BUS;

import java.io.Serializable;

public class Route implements Serializable {
    private static int i = 1;
    private String maTuyen;
    private double distance;
    private int numberOfStops;

    public Route(double distance, int numberOfStops) {
        this.maTuyen = String.format("%03d", i++);
        this.distance = distance;
        this.numberOfStops = numberOfStops;
    }

    public String getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(String maTuyen) {
        this.maTuyen = maTuyen;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }
    @Override
    public String toString() {
        return "Route{ " +
                "Ma tuyen = " + maTuyen +
                ", distance = " + distance + "km"+
                ", numberOfStops = " + numberOfStops +
                '}';
    }
}
