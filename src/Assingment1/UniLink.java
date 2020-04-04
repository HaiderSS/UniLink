package Assingment1;
import java.util.*;

public class UniLink {
    public static ArrayList<Post> Posts = new ArrayList<Post>(); // for keeping posts

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // creating parent class array list for polymorphism

        Scanner input = new Scanner(System.in); // for  integer input
        Scanner input1 = new Scanner(System.in); // for string input

        String username;
        String tempID;
        int choice;

        do {

            do{  // validation for user input
                System.out.println("\n**  UniLink System  **");
                System.out.println("1. Log in");
                System.out.println("2. Quit\n");

                System.out.println("Enter Your Choice");
                choice = input.nextInt();
            }while(choice!=1 && choice !=2);

            if(choice == 2)
            {
                return;
            }

            do{ // username validation
                System.out.println("Enter username");
                username = input1.nextLine();
            }while(!username.startsWith("s") && !username.startsWith("S"));


            System.out.println("Welcome " + username);

            if (choice == 1) {
                do {

                    System.out.println("\n**  Student Menu  **");
                    System.out.println("1. New Event Post");
                    System.out.println("2. New Sale Post");
                    System.out.println("3. New Job Post");
                    System.out.println("4. Reply To Post");
                    System.out.println("5. Display My Post");
                    System.out.println("6. Display All Post");
                    System.out.println("7. Close Post");
                    System.out.println("8. Delete Post");
                    System.out.println("9. Log Out");

                    System.out.print("\nEnter Your Choice");
                    choice = input.nextInt();
                    System.out.println();

                    // temporary variables
                    String tempName = null;
                    String tempDescription = null;

                    if (choice == 1) // new Event post
                    {
                        // temporary variables
                        String tempVenue = null;
                        String tempDate = null;
                        int tempCapacity = 0;

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

                        Event e = new Event(tempName, tempDescription, username, tempVenue, tempDate, tempCapacity);
                        Posts.add(e);

                        System.out.println("Success! your event has been created with id EVE00" + e.EventCount);

                    } else if (choice == 2) // new Sale post
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

                        Sale s = new Sale(tempName, tempDescription, username, tempAskingPrice, tempMinimumRaise);
                        Posts.add(s);

                        System.out.println("Success! your new sale has been created with id SAL00" + s.SaleCount);


                    } else if (choice == 3) // new job post
                    {
                        double tempProposePrice = 0.0;

                        System.out.println("Enter details of the job below:");
                        System.out.print("Name : ");
                        tempName = input1.nextLine();
                        System.out.print("Description : ");
                        tempDescription = input1.nextLine();
                        System.out.print("Propose price : ");
                        tempProposePrice = input.nextDouble();

                        Job j = new Job(tempName, tempDescription, username, tempProposePrice);
                        Posts.add(j);

                        System.out.println("Success! your job has been created with id JOB00" + j.JobCount);

                    } else if (choice == 4) // reply to post
                    {
                        String tempPostID;
                        boolean sameuserbit= true;
                        ArrayList<Reply> keepit = new ArrayList<Reply>(); // for keeping creator ids

                        System.out.print("Enter post id or 'Q' to quit: ");
                        tempPostID = input1.nextLine();
                        for (int i = 0; i < Posts.size(); i++) {
                            if (tempPostID.equals(Posts.get(i).getPostId())) {
                                if(Posts.get(i).getCreaterID() != username) // creater of post check
                                {
                                    keepit = Posts.get(i).getReplies();
                                    //for(int j=0;j<keepit.size();j++)
                                    for (Reply r: keepit)
                                    {
                                        if(username.equals(r.getResponderID()))
                                        {
                                            sameuserbit = false;
                                        }
                                    }
                                    if(sameuserbit) // same user reply check
                                    {
                                        System.out.println(Posts.get(i).getPostDetails());
                                        System.out.print("Enter your offer or 'Q' to quit: ");
                                        double tempOffer = input.nextDouble();
                                        Reply tempr = new Reply(tempPostID, tempOffer, username);
                                        boolean tempStatus = Posts.get(i).handleReply(tempr);
                                        if (tempStatus) {
                                            System.out.println("Offer Accepted!");
                                        } else {
                                            System.out.println("Offer not Accepted!");
                                        }
                                    }
                                    else{
                                        System.out.println("This user have already replied on this post");
                                    }
                                }
                                else{
                                    System.out.println("Creator of the post cannot reply to their own post");
                                }
                            }
                        }
                    } else if (choice == 5) // display my posts
                    {
                        System.out.println("Details of all my posts are below: ");
                        for (int i = 0; i < Posts.size(); i++) {
                            if (username.equals(Posts.get(i).getCreaterID())) {
                                System.out.println(Posts.get(i).getPostDetails());
                                System.out.println();
                                System.out.println(Posts.get(i).getReplyDetails());
                                System.out.println();
                            }
                        }
                    } else if (choice == 6) // display all posts
                    {
                        System.out.println("Details of all the posts are below: ");
                        for (int i = 0; i < Posts.size(); i++) // loop through whole posts
                        {
                            System.out.println(Posts.get(i).getPostDetails());
                            System.out.println();
                        }

                    } else if (choice == 7) // close post
                    {
                        System.out.println("Please enter the ID of the post you want to close");
                        String tempPostID = input1.nextLine();
                        boolean closestatus = true;
                        for (int i = 0; i < Posts.size(); i++) {
                            if (tempPostID.equals(Posts.get(i).getPostId()) && username.equals(Posts.get(i).getCreaterID())) {
                                Posts.get(i).setStatus(false); // post closed
                                System.out.println("Post successfully closed");
                                closestatus = false;
                            }
                        }
                        if (closestatus) // called if no ID is found
                        {
                            System.out.println("No such ID can be found");
                        }
                    } else if (choice == 8) // delete post
                    {
                        System.out.println("Please enter the ID of the post you want to delete");
                        String tempPostID = input1.nextLine();
                        boolean deletestatus = true;
                        for (int i = 0; i < Posts.size(); i++) {
                            if (tempPostID.equals(Posts.get(i).getPostId()) && username.equals(Posts.get(i).getCreaterID())) {
                                Posts.remove(i);
                                System.out.println("Post successfully deleted");
                                deletestatus = false;
                            }
                        }
                        if (deletestatus) // called if no ID is found
                        {
                            System.out.println("No such ID can be found");
                        }
                    } else if (choice == 9) // Log out
                    {
                        System.out.println("You have successfully logged out!");
                        break;
                    }
                    else {
                        System.out.println("Invalid choice");
                    }

                } while (choice != 9);
                // if logout is called then return through else
            }
        } while (choice != 2);
    }
}
