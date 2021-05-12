package za.co.amahle.payparking.model

enum class SAMoney(val denomination: Double)  {
    ONE_CENT(0.01), TWO_CENT(0.02), FIVE_CENT(0.05), TEN_CENT(0.10), TWENTY_CENT(0.20), FIFTY_CENT(0.50), ONE_RAND(1.0), TWO_RAND(2.0), FIVE_RAND(5.0), TEN_RAND(10.0), TWENTY_RAND(20.0), FIFTY_RAND(50.0), ONE_HUNDRED_RAND(100.0), TWO_HUNDRED_RAND(200.0);

}