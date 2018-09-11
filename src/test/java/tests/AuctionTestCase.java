package tests;

import domain.*;
import org.joda.time.DateTime;
import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import static domain.AuctionBuilder.aAuction;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AuctionTestCase {

    private Auction auction;
    private Auction auctionMock;
    private User owner2;

    @Before
    public void setUp() throws Exception{
        auction = aAuction().build();
        owner2 = new User("Miguel","Caneo","chinocaneo@qac.com",
                "vamosCervecero78",new DateTime("1983-09-17"));
        auction.setState(new InProgressAuction());
    }


    @Test
    public void testUserBidInAuctionInWhickHeNotIsOwner(){

        assertEquals(10,auction.getPriceInit(),0);
        auction.makeABid(owner2,20);
        assertEquals(10.5,auction.getPriceInit(),0);
    }

    @Test
    public void testUserBidInAuctionInWhickHeIsOwner(){
        assertEquals(10,auction.getPriceInit(),0);
        auction.makeABid(owner2,20);
        assertEquals(10.5,auction.getPriceInit(),0);
        auction.makeABid(owner2,20);
        assertEquals(10.5,auction.getPriceInit(),0);
    }

    @Test
    public void testBidAuctionThatHasFiveMinutesToClose(){

        LocalTime menusFiveMinutes = LocalTime.now().minusMinutes(4);
        auction.setHoursFinal(menusFiveMinutes);
        assertEquals(10,auction.getPriceInit(),0);
        auction.makeABid(owner2,20);
        assertEquals(10.5,auction.getPriceInit(),0);
        DateTime extendTwoDays = auction.getDateFinal().plusDays(2);
        assertEquals(extendTwoDays,auction.getDateFinalNew());
    }

    @Test
    public void testBidAtAuctionWithTheEndDate(){

        assertEquals(10,auction.getPriceInit(),0);
        auction.setState(new CloseAuction());
        auction.makeABid(owner2,20);
        assertEquals(10,auction.getPriceInit(),0);

    }

}