package main;

public class Taxi {

    private Integer hourCheckIn;
    private Double distance;
    private Integer minuteAwaiting;
    private Integer noPassenger;
    private Integer noChildren;
    private Boolean passengerType; // (True: one-time passenger || False: regular clients)

    public Integer getHourCheckIn() {
        return hourCheckIn;
    }

    public void setHourCheckIn(Integer hourCheckIn) {
        this.hourCheckIn = hourCheckIn;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getMinuteAwaiting() {
        return minuteAwaiting;
    }

    public void setMinuteAwaiting(Integer minuteAwaiting) {
        this.minuteAwaiting = minuteAwaiting;
    }

    public Integer getNoPassenger() {
        return noPassenger;
    }

    public void setNoPassenger(Integer noPassenger) {
        this.noPassenger = noPassenger;
    }

    public Integer getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(Integer noChildren) {
        this.noChildren = noChildren;
    }

    public Boolean getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(Boolean passengerType) {
        this.passengerType = passengerType;
    }


}
