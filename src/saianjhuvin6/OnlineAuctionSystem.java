package saianjhuvin6;

import java.util.Objects;

public class OnlineAuctionSystem {
    private String auctionName, bidderName;
    private Integer firstIncrement,lastIncrement,minBidIncrement;
    Auction auction;
    Bidder bidder;

    public Auction createAuction(String auctionName, Integer firstIncrement, Integer lastIncrement,Integer minBidIncrement ){
        this.auctionName=auctionName;
        this.firstIncrement= firstIncrement;
        this.lastIncrement=lastIncrement;
        this.minBidIncrement= minBidIncrement;
        auction=new Auction(auctionName, firstIncrement, lastIncrement, minBidIncrement);
        return auction;
    }
    public Bidder createBidder(String bidderName){
         return null;
    }
    public class Auction{
        private String auctionName;
        private Integer firstIncrement,lastIncrement,minBidIncrement;
        Auction(String auctionName, Integer firstIncrement, Integer lastIncrement,Integer minBidIncrement){
            this.auctionName=auctionName;
            this.firstIncrement= firstIncrement;
            this.lastIncrement=lastIncrement;
            this.minBidIncrement= minBidIncrement;
        }

        public Auction(String auctionName) {
            this.auctionName = auctionName;
        }

        public String getAuctionName() {
            return auctionName;
        }

        public void setAuctionName(String auctionName) {
            this.auctionName = auctionName;
        }

        public Integer getFirstIncrement() {
            return firstIncrement;
        }

        public void setFirstIncrement(Integer firstIncrement) {
            this.firstIncrement = firstIncrement;
        }

        public Integer getLastIncrement() {
            return lastIncrement;
        }

        public void setLastIncrement(Integer lastIncrement) {
            this.lastIncrement = lastIncrement;
        }

        public Integer getMinBidIncrement() {
            return minBidIncrement;
        }

        public void setMinBidIncrement(Integer minBidIncrement) {
            this.minBidIncrement = minBidIncrement;
        }

        @Override
        public String toString() {
            return "Auction{" +
                    "auctionName='" + auctionName + '\'' +
                    ", firstIncrement=" + firstIncrement +
                    ", lastIncrement=" + lastIncrement +
                    ", minBidIncrement=" + minBidIncrement +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Auction auction = (Auction) o;
            return Objects.equals(auctionName, auction.auctionName) &&
                    Objects.equals(firstIncrement, auction.firstIncrement) &&
                    Objects.equals(lastIncrement, auction.lastIncrement) &&
                    Objects.equals(minBidIncrement, auction.minBidIncrement);
        }

        @Override
        public int hashCode() {
            return Objects.hash(auctionName, firstIncrement, lastIncrement, minBidIncrement);
        }
    }
    public class Bidder{
        String bidderName;
        Integer bidderId;
        Bidder(Integer biddderId, String bidderName){
            this.bidderId=bidderId;
            this.bidderName=bidderName;
        }
    }
}
