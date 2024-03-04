package Admin;

import java.io.Serializable;
import java.util.Arrays;

public class Doctors implements Serializable {
    private static final long serialVersionUID = -299482035708790407L;
    private String name;
    private String profession;
    private String[] times;

    Doctors(String name,String profession,String[]times)
    {
        this.name=name;
        this.profession=profession;
        this.times=times;
    }

    Doctors() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String[] getTimes() {
        return times;
    }

    public void setTimes(String[] times) {
        this.times = times;
    }

    public String getAll()
    {
        return this.profession+"."+this.name+": "+ Arrays.toString(this.times);
    }

    public void getOnlyOneOfTheTimes() {
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + "." + times[i]);
        }
    }

        public String getOnlyOneOfTheTimesForFind()
        {
            String result = null;
            for (int i = 0; i < times.length; i++)
            {
                result=times[i];
            }
            return result;
            }
    }

