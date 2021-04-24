package za.co.amahle.payparking.model

enum class RandNote(val denomination: Double) : Money {
    TEN_RAND(10.0), TWENTY_RAND(20.0), FIFTY_RAND(50.0), ONE_HUNDRED_RAND(100.0), TWO_HUNDRED_RAND(200.0);

}