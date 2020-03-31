package Assingment1;
import java.util.*;

public class UniLink {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //static variables

        System.out.println("\n**  UniLink System  **");
        System.out.println("1. Log in");
        System.out.println("2. Quit\n");

        Scanner input= new Scanner(System.in); // for  integer input
        Scanner input1= new Scanner(System.in); // for string input

        int choice;
        String username;

        System.out.println("Enter Your Choice");
        choice = input.nextInt();
        System.out.println("\n");

        if(choice == 1)
        {
            System.out.println("Enter username");
            username = input.nextLine();
            System.out.println("\n");

            System.out.println("Welcome " + username + "\n");

            System.out.println("\n**  Student Menu  **");
            System.out.println("1. New Event Post");
            System.out.println("2. New Job Post");
            System.out.println("3. Reply To Post");
            System.out.println("4. Display My Post");
            System.out.println("6. Display All Post");
            System.out.println("7. Close Post");
            System.out.println("8. Delete Post");
            System.out.println("9. Log Out");

            System.out.print("\nEnter Your Choice");
            choice = input.nextInt();
            System.out.println("\n");


            // temporary variables
            String tempName = null;
            String tempDescription = null;

            if(choice == 1) // new Event post
            {
                // temporary variables
                String tempVenue = null;
                String tempDate = null;
                int tempCapacity = 0;
                String tempID = "EVE";

                System.out.println("Enter details of the event below:");
                System.out.print("Name : ");
                tempName = input1.nextLine();
                System.out.print("Description : ");
                tempDescription = input1.nextLine();
                System.out.print("Venue : ");
                tempVenue = input1.nextLine();
                System.out.print("Date : ");
                tempDate = input1.nextLine();
                System.out.print("Capacity : ");
                tempCapacity = input.nextInt();
            }
            else if(choice == 2) // new Sale post
            {
                // temporary variables
                double tempAskingPrice = 0.0;
                double tempMinimumRaise = 0.0;

                System.out.println("Enter details of the sale below:");
                System.out.print("Name : ");
                tempName = input1.nextLine();
                System.out.print("Description : ");
                tempDescription = input1.nextLine();
                System.out.print("Asking price : ");
                tempAskingPrice = input.nextDouble();
                System.out.print("Minimum raise : ");
                tempMinimumRaise = input.nextDouble();

            }
            else if(choice == 3) // new job post
            {
                double tempProposePrice = 0.0;

                System.out.println("Enter details of the sale below:");
                System.out.print("Name : ");
                tempName = input1.nextLine();
                System.out.print("Description : ");
                tempDescription = input1.nextLine();
                System.out.print("Propose price : ");
                tempProposePrice = input.nextDouble();




            }
            else if(choice == 4) // reply to post
            {

            }
            else if(choice == 5) // display my posts
            {

            }else if(choice == 6) // display all posts
            {

            }else if(choice == 7) // close post
            {

            }
            else if(choice == 8) // delete posy
            {

            }
            else if(choice == 9) // Log out
            {
                return;
            }
        }
        // if logout is called then return through else
        else{
            return;
        }

    }
}
