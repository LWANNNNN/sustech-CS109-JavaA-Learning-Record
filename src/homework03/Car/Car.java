package homework03.Car;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Car
{
    private String plateNumber;
    private int type;
    private String entryDay = "";
    private String entryTime = "";
    private String exitDay = "";
    private String exitTime = "";

    //Constructor
    public Car (String plateNumber, String type)
    {
        this.plateNumber = plateNumber;
        if (type.equals("Standard"))
        {
            this.type = 1;
        } else if (type.equals("Large"))
        {
            this.type = 2;
        } else if (type.equals("Extra Large"))
        {
            this.type = 3;
        }
    }

    //Getters and Setters
    public String getPlateNumber()
    {
        return this.plateNumber;
    }

    public void setPlateNumber(String plate)
    {
        this.plateNumber = plate;
    }

    public int getType()
    {
        return this.type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getEntryDay()
    {
        return this.entryDay;
    }

    public void setEntryDay(String Day)
    {
        this.entryDay = Day;
    }

    public String getEntryTime()
    {
        return this.entryTime;
    }

    public void setEntryTime(String time)
    {
        this.entryTime = time;
    }

    public String getExitDay()
    {
        return this.exitDay;
    }

    public void setExitDay(String Day)
    {
        this.exitDay = Day;
    }

    public String getExitTime()
    {
        return this.exitTime;
    }

    public void setExitTime(String time)
    {
        this.exitTime = time;
    }

    //getTypeName
    public String getTypeName()
    {
        if (this.type == 1)
        {
            return "Standard";
        } else if (this.type == 2)
        {
            return "Large";
        } else
        {
            return "Extra Large";
        }
    }
    //toString
    public String toString()
    {
        return  "{\n  \"plateNumber\": \"" + this.plateNumber + "\",\n" +
                "  \"type\": \"" + this.getTypeName() + "\",\n" +
                "  \"entryDay\": \"" + this.entryDay + "\",\n" +
                "  \"entryTime\": \"" + this.entryTime + "\",\n" +
                "  \"exitDay\": \"" + this.exitDay + "\",\n" +
                "  \"exitTime\": \"" + this.exitTime + "\"\n}";
    }

    public double getFee()
    {
        double Fee = 0;
        if (entryDay.equals("") || exitDay.equals("") || entryTime.equals("") || exitTime.equals(""))
        {
            return Fee;
        }

        LocalDate startDay = LocalDate.parse(this.entryDay);
        LocalDate endDay = LocalDate.parse(this.exitDay);
        boolean theSameDay = false;
        long weekdays = 0;
        long weekends = 0;

        if (endDay.isAfter(startDay))
        {
            LocalDate today = startDay.plusDays(1);
            while (endDay.isAfter(today))
            {
                if (today.getDayOfWeek() == DayOfWeek.SATURDAY || today.getDayOfWeek() == DayOfWeek.SUNDAY)
                {
                    weekends++;
                } else
                {
                    weekdays++;
                }

                today = today.plusDays(1);
            }
        } else
        {
            theSameDay = true;
        }
        Fee = Fee + weekdays*66 + weekends*39.5;

        double startTime = Double.parseDouble(entryTime);
        double endTime = Double.parseDouble(exitTime);

        if (theSameDay)
        {
            if (startDay.getDayOfWeek() == DayOfWeek.SATURDAY || startDay.getDayOfWeek() == DayOfWeek.SUNDAY)
            {
                double timelength = endTime - startTime;
                if (timelength <= 1)
                {
                    Fee += 5;
                } else
                {
                    timelength--;
                    Fee += 5 + (timelength*1.5);
                }
            } else
            {
                if ((startTime < 8 && endTime <= 8) || (startTime >= 20 && endTime >= 20))
                {
                    double timelength = endTime - startTime;
                    Fee += timelength * 1.5;
                } else if (startTime >= 8 && endTime <= 20)
                {
                    double timelength = endTime - startTime;
                    if (timelength <= 1)
                    {
                        Fee += 15;
                    } else
                    {
                        timelength--;
                        Fee += 15 + (timelength*2*1.5);
                    }
                } else if (startTime < 8 && endTime > 8 && endTime <= 20)
                {
                    double offpeaktimelength = 8 - startTime;
                    double peaktimelength = endTime - 8;
                    if (peaktimelength <= 1)
                    {
                        Fee += 15 + (offpeaktimelength*1.5);
                    } else
                    {
                        peaktimelength--;
                        Fee += 15 + (peaktimelength*2*1.5) + (offpeaktimelength*1.5);
                    }
                } else if (startTime >= 8 && startTime < 20 && endTime > 20)
                {
                    double offpeaktimelength = endTime - 20;
                    double peaktimelength = 20 - startTime;
                    if (peaktimelength <= 1)
                    {
                        Fee += 15 + (offpeaktimelength*1.5);
                    } else
                    {
                        peaktimelength--;
                        Fee += 15 + (peaktimelength*2*1.5) + (offpeaktimelength*1.5);
                    }
                } else if (startTime <= 8 && endTime >= 20)
                {
                    double timelength = (8 - startTime) + (endTime - 20);
                    Fee += 48 + (1.5*timelength);
                }
            }

        } else
        {
            if (startDay.getDayOfWeek() == DayOfWeek.SATURDAY || startDay.getDayOfWeek() == DayOfWeek.SUNDAY)
            {
                double timelength = 24 - startTime;
                if (timelength <= 1)
                {
                    Fee += 5;
                } else
                {
                    timelength--;
                    Fee += 5 + (timelength*1.5);
                }
            } else
            {
                if (startTime < 8)
                {
                    double offpeaktimelength = (8 - startTime) + 4;
                    Fee += 48 + (offpeaktimelength*1.5);
                } else if (startTime >= 8 && startTime <= 20)
                {
                    double peaktimelength = 20 - startTime;
                    if (peaktimelength < 1)
                    {
                        Fee += 15 + (4*1.5);
                    } else
                    {
                        peaktimelength--;
                        Fee += 15 + (peaktimelength*2*1.5) + (4*1.5);
                    }
                } else if (startTime >= 20)
                {
                    double offpeaktimelength = 24 - startTime;
                    Fee += offpeaktimelength*1.5;
                }
            }

            if (endDay.getDayOfWeek() == DayOfWeek.SATURDAY || endDay.getDayOfWeek() == DayOfWeek.SUNDAY)
            {
                double timelength = endTime - 0;
                if (timelength <= 1)
                {
                    Fee += 5;
                } else
                {
                    timelength--;
                    Fee += 5 + (timelength*1.5);
                }
            } else
            {
                if (endTime < 8)
                {
                    double offpeaktimelength = endTime - 0;
                    Fee += offpeaktimelength*1.5;
                } else if (endTime >= 8 && endTime <= 20)
                {
                    double peaktimelength = endTime - 8;
                    if (peaktimelength < 1)
                    {
                        Fee += 15 + (8*1.5);
                    } else
                    {
                        peaktimelength--;
                        Fee += 15 + (peaktimelength*2*1.5) + (8*1.5);
                    }
                } else if (endTime >= 20)
                {
                    double offpeaktimelength = 8 + (endTime - 20);
                    Fee += 48 + (offpeaktimelength*1.5);
                }
            }
        }

        Fee *= this.type;
        return Fee;
    }

}
