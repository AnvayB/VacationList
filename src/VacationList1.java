

import java.util.Scanner;
/**
 * Write a description of class VacationList1 here.
 *
 * @AnvayBhanap
 * @summer project: VL.1
 */
public class VacationList1
{
    public static void main (String [] args)
    {
        int days;
        int temp;
        String rain;
        String sunny;
        String swim;

        //main questions
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        System.out.println("How many days is your trip? ");
        days = scan.nextInt();

        System.out.println("What is the average temperature there? ");
        temp = scan.nextInt();

        System.out.println("Will it be raining there? Y/N");
        rain = scan.next();

        System.out.println("Will it be very sunny there? Y/N");
        sunny = scan.next();

        System.out.println("Will there be swimming involved?");
        swim = scan.next();

        int half = days / 2;

        //results depending on previous answers
        if (temp >= 80)
        {
            System.out.println("\nTotal items to pack: "+
                "\n"+(days+1) + " UW "+
                "\n"+(days+1) + " pairs of socks "+
                "\n"+days + " half sleeve shirts "+
                "\n"+half + 1 + " shorts "+
                "\n"+ half + " pants "+

                "\n"+"1 cap "+
                "\n"+ "toiletries, etc ");

            if (swim.equals("y") || swim.equals("Y"))
            {
                if (days <= 4)
                {
                    System.out.println("1 swim shirt/shorts");
                    System.out.println("1 pair of sandals/slippers");
                }
                else if (days > 4)
                {
                    System.out.println("2 swim shirt/shorts");
                    System.out.println("2 pairs of sandals/slippers");
                }
            }
            if (sunny.equals("y") || sunny.equals("Y"))
            {
                System.out.println("Remember to pack sunscreen!");
            }
            if (rain.equals("y") || rain.equals("Y"))
            {
                System.out.println("Remember to pack an umbrella!");
            }
        }

        if (temp >= 70 && temp < 80)
        {
            System.out.println("\nTotal items to pack: "+
                "\n"+(days+1) + " UW "+
                "\n"+(days+1) + " pairs of socks "+
                "\n"+days + " half sleeve shirts "+
                "\n"+ (half+1) + " shorts "+
                "\n"+ (half) + " pants "+
                "\n"+half + " light jacket/hoodie/sweater "+
                "\n"+"1 cap "+
                "\n"+ "toiletries, etc ");

            if (swim.equals("y") || swim.equals("Y"))
            {
                if (days <= 4)
                {
                    System.out.println("1 swim shirt/shorts");
                    System.out.println("1 pair of sandals/slippers");
                }
                else if (days > 4)
                {
                    System.out.println("2 swim shirt/shorts");
                    System.out.println("2 pairs of sandals/slippers");
                }
            }
            if (sunny.equals("y") || sunny.equals("Y"))
            {
                System.out.println("Remember to pack sunscreen!");
            }
            if (rain.equals("y") || rain.equals("Y"))
            {
                System.out.println("Remember to pack an umbrella!");
            }
        }

        if (temp >= 60 && temp < 70)
        {
            System.out.println("\nTotal items to pack: "+
                "\n"+(days+1) + " UW "+
                "\n"+(days+1) + " pairs of socks "+
                "\n"+days + " long sleeve shirts "+

                "\n"+ days + " pants "+
                "\n"+half + " moderate jacket/hoodie/sweater "+

                "\n"+ "toiletries, etc ");

            if (swim.equals("y") || swim.equals("Y"))
            {
                if (days <= 4)
                {
                    System.out.println("1 swim shirt/shorts");
                    System.out.println("1 pair of sandals/slippers");
                }
                else if (days > 4)
                {
                    System.out.println("2 swim shirt/shorts");
                    System.out.println("2 pairs of sandals/slippers");
                }
            }
            if (sunny.equals("y") || sunny.equals("Y"))
            {
                System.out.println("Remember to pack sunscreen!");
            }
            if (rain.equals("y") || rain.equals("Y"))
            {
                System.out.println("Remember to pack an umbrella!");
            }
        }

        if (temp < 60)
        {
            System.out.println("\nTotal items to pack: "+
                "\n"+(days+1) + " UW "+
                "\n"+(days+1) + " pairs of socks "+
                "\n"+days + " long sleeve shirts "+

                "\n"+ days + " pants "+
                "\n"+half + " heavy jacket/hoodie/sweater "+

                "\n"+ "toiletries, etc ");

            if (swim.equals("y") || swim.equals("Y"))
            {
                if (days <= 4)
                {
                    System.out.println("1 swim shirt/shorts");
                    System.out.println("1 pair of sandals/slippers");
                }
                else if (days > 4)
                {
                    System.out.println("2 swim shirt/shorts");
                    System.out.println("2 pairs of sandals/slippers");
                }
            }
            if (sunny.equals("y") || sunny.equals("Y"))
            {
                System.out.println("Remember to pack sunscreen!");
            }
            if (rain.equals("y") || rain.equals("Y"))
            {
                System.out.println("Remember to pack an umbrella!");
            }
        }
    }
}

