package Admin;

import javax.print.Doc;
import java.util.Scanner;

public class InputUtilities {
    public static String requireText(String title)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(title+" ");
        String result= sc.nextLine();
        return result;
    }
    public static String[] requiredArr(String title,int a)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(title+" ");
        String[] result= new String[a];
        for (int i=0;i< result.length;i++)
        {
            result[i]=sc.nextLine();
        }
        return result;
    }

    public static int requiredNum(String title)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(title+" ");
        int num=sc.nextInt();
        return num;
    }




    public static String requiredName()
    {
        return requireText("Enter Name:");
    }

    public static String requiredProfession()
    {
        return requireText("Enter Profession:");
    }

    public static String[] requiredTimes()
    {
        return requiredArr("Enter Times:",requiredNum("Enter number of times:"));
    }

    public static int requiredNum()
    {
        return requiredNum("Enter Num:");
    }
}
