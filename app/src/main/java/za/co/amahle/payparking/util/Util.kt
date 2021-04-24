package za.co.amahle.payparking.util

import android.util.Log
import com.google.gson.Gson
import za.co.amahle.payparking.R
import za.co.amahle.payparking.model.CentCoin
import za.co.amahle.payparking.model.Money
import za.co.amahle.payparking.model.RandCoin
import za.co.amahle.payparking.model.RandNote
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

object Util {
    const val AMOUNT_PAYABLE = "amount_payable"
    const val AMOUNT_PAID = "amount_paid"
    private const val TAG = "Util"
    @JvmStatic
    fun round(value: Double): Double {
        var bd = BigDecimal(java.lang.Double.toString(value))
        bd = bd.setScale(2, RoundingMode.HALF_UP)
        return bd.toDouble()
    }

    /**
     * @param monies
     * @return This method create a list of images to be displayed based on the list of denominations
     */
    @JvmStatic
    fun createDisplayChangeOfDenominations(monies: List<Money?>): List<Int> {
        val drawables: MutableList<Int> = ArrayList()
        for (m in monies) {
            if (m is RandNote) {
                val randNote = m
                if (randNote.denomination == RandNote.TWO_HUNDRED_RAND.denomination) {
                    drawables.add(R.drawable.r200)
                } else if (randNote.denomination == RandNote.ONE_HUNDRED_RAND.denomination) {
                    drawables.add(R.drawable.r100)
                } else if (randNote.denomination == RandNote.FIFTY_RAND.denomination) {
                    drawables.add(R.drawable.r50)
                } else if (randNote.denomination == RandNote.TWENTY_RAND.denomination) {
                    drawables.add(R.drawable.r20)
                } else if (randNote.denomination == RandNote.TEN_RAND.denomination) {
                    drawables.add(R.drawable.r10)
                }
            } else if (m is RandCoin) {
                val randNote = m
                if (randNote.denomination == RandCoin.FIVE_RAND.denomination) {
                    drawables.add(R.drawable.r5)
                } else if (randNote.denomination == RandCoin.TWO_RAND.denomination) {
                    drawables.add(R.drawable.r2)
                } else if (randNote.denomination == RandCoin.ONE_RAND.denomination) {
                    drawables.add(R.drawable.r1)
                }
            } else if (m is CentCoin) {
                val randNote = m
                if (randNote.denomination == CentCoin.FIFTY_CENT.denomination) {
                    drawables.add(R.drawable.c50)
                } else if (randNote.denomination == CentCoin.TWENTY_CENT.denomination) {
                    drawables.add(R.drawable.c20)
                } else if (randNote.denomination == CentCoin.TEN_CENT.denomination) {
                    drawables.add(R.drawable.c10)
                } else if (randNote.denomination == CentCoin.FIVE_CENT.denomination) {
                    drawables.add(R.drawable.c5)
                } else if (randNote.denomination == CentCoin.TWO_CENT.denomination) {
                    drawables.add(R.drawable.c2)
                } else if (randNote.denomination == CentCoin.ONE_CENT.denomination) {
                    drawables.add(R.drawable.c1)
                }
            }
        }
        return drawables
    }

    /**
     * @param paymentAmount
     * @param amountPayable
     * @return This method returns a list of change denomination
     */
    @JvmStatic
    fun breakingDownChangeIntoDenomination(paymentAmount: Double, amountPayable: Double): List<Money?> {
        var changes: MutableList<Money?> = Collections.EMPTY_LIST as MutableList<Money?>
        changes = ArrayList()
        var balance = round(paymentAmount - amountPayable)
        while (balance > 0.00) {

            if (balance >= RandNote.TWO_HUNDRED_RAND.denomination) {
                changes.add(RandNote.TWO_HUNDRED_RAND)
                balance = round(balance - RandNote.TWO_HUNDRED_RAND.denomination)
                continue
            } else if (balance >= RandNote.ONE_HUNDRED_RAND.denomination) {
                changes.add(RandNote.ONE_HUNDRED_RAND)
                balance = round(balance - RandNote.ONE_HUNDRED_RAND.denomination)
                continue
            } else if (balance >= RandNote.FIFTY_RAND.denomination) {
                changes.add(RandNote.FIFTY_RAND)
                balance = round(balance - RandNote.FIFTY_RAND.denomination)
                continue
            } else if (balance >= RandNote.TWENTY_RAND.denomination) {
                changes.add(RandNote.TWENTY_RAND)
                balance = round(balance - RandNote.TWENTY_RAND.denomination)
                continue
            } else if (balance >= RandNote.TEN_RAND.denomination) {
                changes.add(RandNote.TEN_RAND)
                balance = round(balance - RandNote.TEN_RAND.denomination)
                continue
            } else if (balance >= RandCoin.FIVE_RAND.denomination) {
                changes.add(RandCoin.FIVE_RAND)
                balance = round(balance - RandCoin.FIVE_RAND.denomination)
                continue
            } else if (balance >= RandCoin.TWO_RAND.denomination) {
                changes.add(RandCoin.TWO_RAND)
                balance = round(balance - RandCoin.TWO_RAND.denomination)
                continue
            } else if (balance >= RandCoin.ONE_RAND.denomination) {
                changes.add(RandCoin.ONE_RAND)
                balance = round(balance - RandCoin.ONE_RAND.denomination)
                continue
            } else if (balance >= CentCoin.FIFTY_CENT.denomination) {
                changes.add(CentCoin.FIFTY_CENT)
                balance = round(balance - CentCoin.FIFTY_CENT.denomination)
                continue
            } else if (balance >= CentCoin.TWENTY_CENT.denomination) {
                changes.add(CentCoin.TWENTY_CENT)
                balance = round(balance - CentCoin.TWENTY_CENT.denomination)
                continue
            } else if (balance >= CentCoin.TEN_CENT.denomination) {
                changes.add(CentCoin.TEN_CENT)
                balance = round(balance - CentCoin.TEN_CENT.denomination)
                continue
            } else if (balance >= CentCoin.FIVE_CENT.denomination) {
                changes.add(CentCoin.FIVE_CENT)
                balance = round(balance - CentCoin.FIVE_CENT.denomination)
                continue
            } else if (balance >= CentCoin.TWO_CENT.denomination) {
                changes.add(CentCoin.TWO_CENT)
                balance = round(balance - CentCoin.TWO_CENT.denomination)
                continue
            } else if (balance >= CentCoin.ONE_CENT.denomination) {
                changes.add(CentCoin.ONE_CENT)
                balance = round(balance - CentCoin.ONE_CENT.denomination)
                continue
            }
        }
        return changes
    }
}