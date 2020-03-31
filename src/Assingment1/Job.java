package Assingment1;

public class Job extends Post{
    private double ProposedPrice;
    private double LowestOffer;

//Constructor
    public Job(String eventname, String description, double proposedPrice, double lowestOffer) {
        super(eventname, description);
        ProposedPrice = proposedPrice;
        LowestOffer = lowestOffer;
    }

// Methods

    @Override
    public String getPostDetails()
    {
        String temp;
        temp = super.getPostDetails();
        temp += "Proposed Price : "+ ProposedPrice + "\n" + "Lowest offer : "+ LowestOffer + "\n";
        return temp;
    }
    
    @Override
    public boolean handleReply(Reply reply)
    {
        if(super.isStatus()) // to confirm that the post is still open
        {
            if(reply.getValue() < LowestOffer) // if new offer is valid
            {
                Replies.add(reply);
                LowestOffer = reply.getValue(); // lowest set to current lowest offer
                return true;
            }
        }
        return false; // if offer is not valid
    }

    @Override
    public String getReplyDetails()
    {
        String OfferHistory = null;
        double tempMin = 0;
        int minIndex = 0;
        int staticSize = Replies.size();

        // code for decreasing order
        if (Replies.size() > 0) {
            OfferHistory = "--   Offer History  --" + "\n";
            for (int i = 0; i < staticSize; i++) {
                tempMin = Replies.get(0).getValue();
                for (int j = 0; j < Replies.size(); j++) {
                    if (Replies.get(j).getValue() < tempMin) {
                        tempMin = Replies.get(j).getValue();
                        minIndex = j;
                        System.out.println(minIndex);
                    }
                }

                OfferHistory += Replies.get(minIndex).getResponderID() + ": ";
                OfferHistory += Replies.get(minIndex).getValue() + "\n";
                Replies.remove(minIndex);
                minIndex = 0;
            }
            return OfferHistory;
        }
        else
            return null;
    }

// Assesors and Mutators
    public double getProposedPrice() {
        return ProposedPrice;
    }

    public void setProposedPrice(double proposedPrice) {
        ProposedPrice = proposedPrice;
    }


    public double getLowestOffer() {
        return LowestOffer;
    }

    public void setLowestOffer(double lowestOffer) {
        LowestOffer = lowestOffer;
    }


}
