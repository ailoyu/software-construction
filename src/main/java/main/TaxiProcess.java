package main;

import java.time.temporal.ValueRange;


public class TaxiProcess {

    public Double calculateTotalFee(Taxi taxi) {
        double totalFee = 0;

        int noPassengerPaid =  (taxi.getNoPassenger() - taxi.getNoChildren()) - 1;
        totalFee += calculateFeeByDistanceAndMinute(taxi.getMinuteAwaiting(), taxi.getDistance(), noPassengerPaid);

        if(taxi.getPassengerType()){
            if(checkHour(taxi.getHourCheckIn())) {
                totalFee += totalFee * 0.2;
            }
        } else {

            totalFee -= totalFee * 0.005;
        }
        return totalFee;
    }
    
    public Boolean checkHour(Integer hour){
        if(ValueRange.of(21, 23).isValidIntValue(hour) || ValueRange.of(0, 6).isValidIntValue(hour)){
            return true;
        } else {
            return false;
        }
    }
    
    public Double calculateFeeByDistanceAndMinute(Integer minuteAwaiting, Double distance, Integer noPassengerPaid){
        double totalFee = 0;
        if(minuteAwaiting > 3 && distance > 1){
            totalFee = 3;
            double distanceRemaining = distance - 1; // - 1 because calculated the first kilometer
            double minuteAwatingRemaining = minuteAwaiting - 1; // - 1 because calculated the first minute
            totalFee += (distanceRemaining / 0.5) + ((minuteAwatingRemaining * 0.5) / 2);
        } else if(minuteAwaiting <= 3 || distance <= 1){
            totalFee = 3d;
        } else {
            throw new RuntimeException("Number of distance compares to minute awaiting is not valid!");
        }
        totalFee += noPassengerPaid * 5; // surcharge of RM5 per additional passenger
        return totalFee;
    }



}
