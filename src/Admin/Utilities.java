package Admin;

import java.io.*;
import java.util.*;

public class Utilities {
//    Config.doctorList=new ArrayList<Doctors>();
    public static Doctors fillDoctors()
    {
        String name= InputUtilities.requiredName();
        String profession=InputUtilities.requiredProfession();
        String [] times=InputUtilities.requiredTimes();
        Doctors d=new Doctors(name,profession,times);
        return d;
    }

    public static void registerDoctors()
    {
//        try {
//           int count = InputUtilities.requiredNum("How many doctors will you register?:");
//            Config.doctors=new Doctors[count];
//            for (int i = 0; i < count; i++) {
//               System.out.println((i + 1) + ".Register.");
//               registerDoctor(fillDoctors());
//           }
//           System.out.println("Operation executed succesfully.");
//            printAllRegistered();
//       } catch (InputMismatchException e)
//       {
//            System.out.println("Invalid Option!");
//        }
       Doctors doctors=fillDoctors();
        Config.doctorList.add(doctors);
        displayDocs();
    }

    public static void printAllRegistered()
    {
        if(Config.doctorList.isEmpty()) System.out.println("No result.");
        else displayDocs();
    }

    public static ArrayList findText(String text)
    {
        int count=0;
        for (int i=0; i<Config.doctorList.size();i++)
        {
            Doctors doc = Config.doctorList.get(i);
            if (doc.getName().equals(text) || doc.getProfession().equals(text) || doc.getTimes().equals(text)) count++;
        }

        int found=0;
        ArrayList<Doctors>result=new ArrayList<>();
        for(int i = 0; i<Config.doctorList.size(); i++)
        {
            Doctors docs= Config.doctorList.get(i);
            if ((docs.getName().equals(text) || docs.getProfession().equals(text))) result.set(found++, docs);
            else System.out.println("There is no a doctor like that.");
        }
        return result;
    }

//    public static void findDoctorsAndPrint()
//    {
//        String text=InputUtilities.requireText("Enter name, profession or meeting time:");
//        ArrayList<Doctors> result=findText(text);
//        for (int i=0;i< result.size();i++)
//            System.out.println(result.get(i).getAll());
//    }

    public static void update()
    {
        try {
        Utilities.printAllRegistered();
        if(Config.doctorList.isEmpty()) return;
        else {
            int index = InputUtilities.requiredNum("Which doctor do you want do update?:");
            Doctors selecetedDoc = Config.doctorList.get(index - 1);
            String changeParams = InputUtilities.requireText("What do you want to change?:");
            String[] params = changeParams.split(",");
            for (int i = 0; i < params.length; i++) {
                String param = params[i];
            }
            if (changeParams.equalsIgnoreCase("name")) selecetedDoc.setName(InputUtilities.requireText("Name:"));
            if (changeParams.equalsIgnoreCase("profession"))
                selecetedDoc.setProfession(InputUtilities.requireText("Profession:"));
            if (changeParams.equalsIgnoreCase("times")) selecetedDoc.setTimes(InputUtilities.requiredArr("Times:",InputUtilities.requiredNum("How many times:")));
        }
    } catch (ArrayIndexOutOfBoundsException | InputMismatchException e)
        {
            System.out.println("Invalid option.");
        }
        catch (NullPointerException n)
        {
            System.out.println("Empty Array.");
        }
        Message();
    }

    public static void remove()
    {
        Utilities.printAllRegistered();
        if(Config.doctorList.isEmpty()) System.out.println("There is no doctor.");
        else {
            int index = InputUtilities.requiredNum("Which doctor do you want do remove?:");
            Config.doctorList.remove(index-1);
            Message();
        }
    }

    public static void Message()
    {
        System.out.println("Completed succesfully.");
    }

    public static void saveDoctorsToFile(String filePath)
    {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Doctors doctors : Config.doctorList) {
                outputStream.writeObject(doctors);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readDoctorsFromFile(String fileName)
    {
        File file = new File(fileName);

        if (file.exists()) {
            try (FileInputStream fileIn = new FileInputStream(fileName);
                 ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

                ArrayList<Doctors> doctorsList = new ArrayList<>();
                while (fileIn.available() > 0) {
                    Doctors doctor = (Doctors) objectIn.readObject();
                    doctorsList.add(doctor);
                }

                Config.doctorList.addAll(doctorsList);
                System.out.println("Doctors read from file and added to Config.doctorList.");

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else return null;
        return null;
    }

    public static void registerDoctor(Doctors doctor) {

        try
        {
            Config.doctorList.add(doctor);
        }catch (Exception e)
        {
            System.out.println("Error!");
        }
    }

    public static void displayDocs()
    {
        try {
            int i = 0;
            for (Doctors doctors : Config.doctorList) {
                i++;
                System.out.println(i + "." + doctors.getProfession() + "." + doctors.getName() + ": " + Arrays.toString(doctors.getTimes()));
            }
        }catch (Exception e)
        {
            System.out.println("Error!");
        }
    }

    public static <T extends Doctors> T findObjectByNameOrSurname(ArrayList<T> objectList) {
        Scanner sc=new Scanner(System.in);
        if(objectList.isEmpty()) System.out.println("There is no doctor.");
        else {
            String nameOrSurname = sc.nextLine();
            for (T obj : objectList) {
                if (obj.getName().equalsIgnoreCase(nameOrSurname) || obj.getProfession().equalsIgnoreCase(nameOrSurname)) {
                    return obj;
                }
            }
        }
        return null;
    }

    public static void showSearched()
    {
        findObjectByNameOrSurname(Config.doctorList);
        displayDocs();
    }

    public static void removeDoctorsFromFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Doctors removed from file: " + fileName);
            } else {
                System.out.println("Failed to remove doctors from file: " + fileName);
            }
        } else {
            System.out.println("File does not exist: " + fileName);
        }
    }
}
