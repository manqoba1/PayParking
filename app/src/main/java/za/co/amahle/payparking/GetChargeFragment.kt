package za.co.amahle.payparking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import za.co.amahle.payparking.adapter.MoneyDisplayAdapter
import za.co.amahle.payparking.util.Util
import za.co.amahle.payparking.util.Util.breakingDownChangeIntoDenomination
import za.co.amahle.payparking.util.Util.createDisplayChangeOfDenominations
import za.co.amahle.payparking.util.Util.round

class GetChargeFragment : Fragment() {
    private lateinit var txtChange: TextView
    private lateinit var lvList: ListView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtChange = view.findViewById(R.id.txtChange)
        lvList = view.findViewById(R.id.lvList)
        val bundle = arguments
        val balance = round(bundle!!.getDouble(Util.AMOUNT_PAID) - bundle.getDouble(Util.AMOUNT_PAYABLE))
        txtChange.setText("R$balance")
        val monies = breakingDownChangeIntoDenomination(bundle.getDouble(Util.AMOUNT_PAID), bundle.getDouble(Util.AMOUNT_PAYABLE))
        val images = createDisplayChangeOfDenominations(monies)
        val displayAdapter = MoneyDisplayAdapter(requireContext(), R.layout.item_denomination_display, images)
        lvList.setAdapter(displayAdapter)
    }

    companion object {
        private const val TAG = "GetChargeFragment"
    }
}