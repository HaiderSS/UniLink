package Assingment1;

public class Sale extends Post{
    private double AskingPrice;
    private double HighestOffer;
    private double MinimumRate;

    // constructors

    public Sale(String eventname, String description)
    {
        super(eventname, description);
        AskingPrice = 0;
        HighestOffer = 0;
        MinimumRate = 0;
    }

    public Sale(String eventname, String description, double askingprice, double highestoffer, double minimumrate)
    {
        super(eventname, description);
        AskingPrice = askingprice;
        HighestOffer = highestoffer;
        MinimumRate = minimumrate;
    }

    // other methods
    @Override
    public String getPostDetails()
    {
        String temp;
        temp = super.getPostDetails();
        temp += "Minimum raise : "+ MinimumRate + "/n" + "Highest offer : "+ HighestOffer + "/n";
        return temp;
    }

    @Override
    public boolean handleReply(Reply reply) {
        if(super.isStatus()) // to confirm that the post is still open
        {
            if(reply.getValue() > HighestOffer + MinimumRate) // if new offer is valid
            {
                Replies.add(reply);
                if(reply.getValue() >= AskingPrice)
                {
                    super.setStatus(false);
                }
                return true;
            }
        }
        return false; // if offer is not valid
    }

    @Override
    public String getReplyDetails() {
        String OfferHistory = null;
        double tempMax = 0;
        int maxIndex = 0;

        // code for decreasing order
        if(Replies.size() > 0)
        {
            OfferHistory = "--   Offer History  --" + "/n";
            for(int i=0;i<Replies.size();i++)
            {
                tempMax = Replies.get(i).getValue();
                for(int j=0;j<Replies.size();i++)
                {
                    if(Replies.get(j).getValue() > tempMax)
                    {
                        tempMax = Replies.get(j).getValue();
                        maxIndex = j;
                    }
                }
                OfferHistory += Replies.get(maxIndex).getResponderID() + ": ";
                OfferHistory += Replies.get(maxIndex).getValue() + "/n";
                Replies.remove(maxIndex);
            }

        }
        else{
            // no offer
        }
        return null;
    }


}
