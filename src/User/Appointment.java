package User;

import Admin.Config;
import Admin.Doctors;
import Admin.InputUtilities;
import Admin.Utilities;

public class Appointment {
    public static void getAppointment()
    {
        System.out.println("\tDoctors:");
        Utilities.printAllRegistered();
        if(Config.doctorList.isEmpty()) return;
        else {
            int input= InputUtilities.requiredNum("Please enter your choice:");
            Doctors choosenDoc=Config.doctorList.get(input-1);
            System.out.println("\tTimes:");
            choosenDoc.getOnlyOneOfTheTimes();
            int i=InputUtilities.requiredNum("Please enter one of the meeting times:");
            if(choosenDoc.getTimes()[i-1].equals("taken")) System.out.println("Please enter another meeting time, it was taken.");
            else {
                if (i > choosenDoc.getTimes().length) System.out.println("Please enter valid time!");
                else {
                    System.out.println("Your time is scheduled.");
                    choosenDoc.getTimes()[i-1] = "taken";
                }
            }
        }
    }
}
