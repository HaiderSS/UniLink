package Assingment1;

public class StartUp {
    public static void main(String[] args){
        UniLink US = new UniLink();
        Event e = new Event("Event1", "Australian open", "s1", "Australia", "01/01/2020", 3);
        Sale s = new Sale("Event2", "Apple laptop sale", "s2", 200, 10);
        Job j = new Job("Event3", "Assingnment 1", "s3", 500);

        Reply r1 = new Reply("EVE001", 1 , "s2");
        Reply r2 = new Reply("EVE001", 1 , "s3");
        Reply r3 = new Reply("SAL001", 80 , "s1");
        Reply r4 = new Reply("SAL001", 20 , "s1"); // not going to be added cause it voilates conditions
        Reply r5 = new Reply("SAL001", 150 , "s3");
        Reply r6 = new Reply("JOB001", 600 , "s1"); // not going to be added cause it voilates conditions
        Reply r7 = new Reply("JOB001", 300 , "s1");
        Reply r8 = new Reply("JOB001", 100 , "s3");

        e.handleReply(r1);
        e.handleReply(r2);
        s.handleReply(r3);
        s.handleReply(r4);
        s.handleReply(r5);
        j.handleReply(r6);
        j.handleReply(r7);
        j.handleReply(r8);

        US.Posts.add(e);
        US.Posts.add(s);
        US.Posts.add(j);

        US.main(null);
    }

}
