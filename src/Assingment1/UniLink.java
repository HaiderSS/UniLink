package Assingment1;
import java.util.*;

public class UniLink {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // creating parent class array list for polymorphism
        ArrayList<Post> Posts = new ArrayList<Post>();

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

        System.out.println("Enter username");
        username = input1.nextLine();
        System.out.println("\n");

        System.out.println("Welcome " + username + "\n");

        if(choice == 1)
        {
            do {

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

                    Event e = new Event(tempName, tempDescription, tempVenue,tempDate, tempCapacity);
                    Posts.add(e);

                    System.out.println("Success! your event has been created with id EVE00" + e.EventCount);

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

                    Sale s = new Sale(tempName, tempDescription, tempAskingPrice, tempMinimumRaise);
                    Posts.add(s);

                    System.out.println("Success! your new sale has been created with id SAL00" + s.SaleCount);


                }
                else if(choice == 3) // new job post
                {
                    double tempProposePrice = 0.0;

                    System.out.println("Enter details of the job below:");
                    System.out.print("Name : ");
                    tempName = input1.nextLine();
                    System.out.print("Description : ");
                    tempDescription = input1.nextLine();
                    System.out.print("Propose price : ");
                    tempProposePrice = input.nextDouble();

                    Job j = new Job(tempName, tempDescription, tempProposePrice);

                    System.out.println("Success! your job has been created with id JOB00" + j.JobCount);

                }
                else if(choice == 4) // reply to post
                {
                    String tempPostID;
                    System.out.print("Enter post id or 'Q' to quit: ");
                    tempPostID = input1.nextLine();
                    for(int i=0; i<Posts.size();i++)
                    {
                        if(tempPostID.equals(Posts.get(i).getPostId()))
                        {
                            Posts.get(i).getPostDetails();
                            System.out.print("Enter your offer or 'Q' to quit: ");
                            double tempOffer = input.nextDouble();
                            Reply tempr = new Reply(tempPostID, tempOffer, username);
                            boolean tempStatus = Posts.get(i).handleReply(tempr);
                            if(tempStatus)
                            {
                                System.out.println("Offer Accepted!");
                            }
                            else{
                                System.out.println("Offer not Accepted!");
                            }
                        }
                    }
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

        }while (choice != 9);
        // if logout is called then return through else
    }
        else{
            return;
        }
}
}
