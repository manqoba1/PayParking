package za.co.amahle.payparking.model

enum class CentCoin(val denomination: Double) : Money {
    ONE_CENT(0.01), TWO_CENT(0.02), FIVE_CENT(0.05), TEN_CENT(0.10), TWENTY_CENT(0.20), FIFTY_CENT(0.50);

}