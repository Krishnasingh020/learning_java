class Leetcode1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinked = 0;
        int EB = 0;
        while( numBottles > 0){
            drinked += numBottles;
            EB += numBottles;

            numBottles = EB / numExchange;
            EB = EB % numExchange;
        }
        return drinked;
    }
}