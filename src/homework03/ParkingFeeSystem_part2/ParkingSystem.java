package homework03.ParkingFeeSystem_part2;

import homework03.ParkingFeeSystem_part1.Car;

public class ParkingSystem
{
    private int totalCap;
    private int remainingCap;
    private Car[] carEvents = new Car[500];
    private int numOfvalidcarEvents = 0;

    public ParkingSystem (int totalCap)
    {
        this.totalCap = totalCap;
        this.remainingCap = this.totalCap;

        for (int i = 0; i < carEvents.length; i++)
        {
            carEvents[i] = new Car("", "");
        }
    }

    public int getRemainingCap()
    {
        return this.remainingCap;
    }

    public boolean entry(String plate, String type, String day, String time)
    {
        if (this.remainingCap ==0)
        {
            return false;
        } else
        {
            this.carEvents[this.numOfvalidcarEvents].setPlateNumber(plate);

            if (type.equals("Standard"))
            {
                this.carEvents[this.numOfvalidcarEvents].setType(1);
            }
            if (type.equals("Large"))
            {
                this.carEvents[this.numOfvalidcarEvents].setType(2);
            }
            if (type.equals("Extra Large"))
            {
                this.carEvents[this.numOfvalidcarEvents].setType(3);
            }

            this.carEvents[this.numOfvalidcarEvents].setEntryDay(day);
            this.carEvents[this.numOfvalidcarEvents].setEntryTime(time);

            this.numOfvalidcarEvents++;
            this.remainingCap--;

            return true;
        }
    }

    public void exit(String plate, String day, String time)
    {
        for (int i = 0; i < this.carEvents.length; i++)
        {
            if (carEvents[i].getPlateNumber().equals(plate) &&
                carEvents[i].getExitDay().equals("") &&
                carEvents[i].getExitTime().equals(""))
            {
                carEvents[i].setExitDay(day);
                carEvents[i].setExitTime(time);

                this.remainingCap++;
            }
        }
    }

    public Car[] allCarEvents()
    {
        Car[] validCarEvents = new Car[this.numOfvalidcarEvents];

        for (int i = 0; i < validCarEvents.length; i++)
        {
            validCarEvents[i] = this.carEvents[i];
        }

        return validCarEvents;
    }

    public double totalFee()
    {
        Car[] allCarEvents = this.allCarEvents();
        double totalFee = 0;

        for (int i = 0; i < allCarEvents.length; i++)
        {
            totalFee += allCarEvents[i].getFee();
        }

        return totalFee;
    }
}
