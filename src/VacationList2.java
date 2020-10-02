

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class VacationList2 here.
 *
 * @AnvayBhanap
 * @summer project: VL.2
 */
public class VacationList2
{
    public static void main (String [] args)
    {
        ArrayList<String> critical = new ArrayList<String>();
        ArrayList<String> elec = new ArrayList<String>();
        ArrayList<String> toil = new ArrayList<String>();
        ArrayList<String> clothOut = new ArrayList<String>();
        ArrayList<String> clothIn = new ArrayList<String>();
        ArrayList<String> misc = new ArrayList<String>();

        int days;
        int temp;

        String rain;
        String sunny;
        String swim;
        String country;
        String list;

        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

        //main questions
        System.out.println("How many days is your trip? ");
        days = scan.nextInt();

        System.out.println("Which country are you visiting?");
        country = scan.next();

        System.out.println("What is the average temperature there? ");
        temp = scan.nextInt();

        System.out.println("Will it be raining there? Y/N");
        rain = scan.next();

        System.out.println("Will it be very sunny there? Y/N");
        sunny = scan.next();

        System.out.println("Will there be swimming involved?");
        swim = scan.next();

        int half = days / 2;

        //array list starts from here
        critical.add("Visa/pan card");
        critical.add("Passport");
        critical.add("Passport photos");
        critical.add("Universal power adapter");
        critical.add(country + " currency");
        critical.add("Vitamins");
        critical.add("Medicines");

        elec.add("iPhone");
        elec.add("iPhone charger");
        elec.add("Computer");
        elec.add("Computer cables");
        elec.add("Bluetooth");
        elec.add("Headphones");
        elec.add("USB");
        elec.add("USB cable");

        toil.add("Toothbrush");
        toil.add("Toothpaste");
        toil.add("Deodorant");
        toil.add("Moisturizer");
        toil.add("Shaving blades");
        toil.add("Shaving cream");
        if (sunny.equals("Y") || sunny.equals("y"))
        {
            toil.add("Remember to pack sunscreen!");
        }

        misc.add("Spare glasses");
        misc.add("Tickets printout");
        misc.add("Business cards");
        misc.add("Online check-in");
        misc.add("Earplugs");
        misc.add("Books to read");
        if (rain.equals("Y") || rain.equals("y"))
        {
            misc.add("Remember to pack an umbrella!");
        }

        clothOut.add("Suit (2)");
        clothOut.add("Blazer");
        clothOut.add("Tie (3)");
        clothOut.add("Black shoes");
        clothOut.add("Black belt");
        clothOut.add("Dress shirt (8)");
        clothOut.add("Dress pants (3)");
        clothOut.add("Dress socks");
        clothOut.add("Sweater");
        if (swim.equals("Y") || rain.equals("y"))
        {
            clothOut.add("Swim shorts/shirt");
        }

        clothIn.add(days + " UW");
        clothIn.add(days + " Undershirts");
        clothIn.add("Night suit, T-shirts");
        clothIn.add("Handkerchiefs");

        System.out.println("\n Enter C to view 'critcal' list." +
            "\n Enter M to view 'misc' list." +
            "\n Enter E to view 'electronics' list."+
            "\n Enter T to view 'toiletries' list."+
            "\n Enter Co to view 'Clothes-Outside' list."+
            "\n Enter Ci to view 'Clothes-Inside' list."+
            "\n Enter ALL to view the entire list.");
        list = scan.next();

        if (list.equals("C"))
        {
            for (String c : critical)
            {
                System.out.println(c);
            }
        }
        if (list.equals("M"))
        {
            for (String m : misc)
            {
                System.out.println(m);
            }
        }
        if (list.equals("E"))
        {
            for (String e : elec)
            {
                System.out.println(e);
            }
        }
        if (list.equals("T"))
        {
            for (String t : toil)
            {
                System.out.println(t);
            }
        }
        if (list.equals("Co"))
        {
            for (String co : clothOut)
            {
                System.out.println(co);
            }
        }
        if (list.equals("Ci"))
        {
            for (String ci : clothIn)
            {
                System.out.println(ci);
            }
        }
        if (list.equals("ALL"))
        {
        	//incomplete
        }
    }
}
