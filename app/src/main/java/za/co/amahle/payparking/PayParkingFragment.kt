package za.co.amahle.payparking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.textfield.TextInputEditText
import za.co.amahle.payparking.util.Util
import za.co.amahle.payparking.util.Util.round
import java.util.*

class PayParkingFragment : Fragment(), View.OnClickListener {
    private lateinit var txtCredit: TextView
    private lateinit var etAmountDue: TextInputEditText
    private lateinit var payNow: Button
    private var amountToBePaid = 0.0
    private var amountPaid = 0.0
    private val randomAmount: Double
        private get() {
            val minValue = 10
            val maxValue = 200
            val theRandom = Random()
            return if (java.lang.Double.valueOf((maxValue - minValue).toDouble()).isInfinite() == false) {
                round(minValue + (maxValue - minValue) * theRandom.nextDouble())
            } else 0.0
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
//        getActivity().setTitle();
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amountToBePaid = randomAmount
        payNow = view.findViewById(R.id.pay_now)
        payNow.setOnClickListener(this)
        txtCredit = view.findViewById(R.id.txtCredit)
        txtCredit.setText("R$amountToBePaid")
        etAmountDue = view.findViewById(R.id.etAmountDue)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.pay_now -> {
                if (etAmountDue!!.text.toString().isEmpty()) {
                    Toast.makeText(context, "Please enter amount due.", Toast.LENGTH_LONG).show()
                    return
                }
                amountPaid = round(etAmountDue!!.text.toString().toDouble())
                if (amountToBePaid > amountPaid) {
                    Toast.makeText(context, "Insufficient Amount.", Toast.LENGTH_LONG).show()
                    return
                }
                val bundle = Bundle()
                bundle.putDouble(Util.AMOUNT_PAYABLE, amountToBePaid)
                bundle.putDouble(Util.AMOUNT_PAID, amountPaid)
                NavHostFragment.findNavController(this@PayParkingFragment)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            }
        }
    }

    companion object {
        private const val TAG = "PayParkingFragment"
    }
}