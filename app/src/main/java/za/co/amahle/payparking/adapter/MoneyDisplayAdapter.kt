package za.co.amahle.payparking.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import za.co.amahle.payparking.R

class MoneyDisplayAdapter(var ctx: Context, var layoutResourceId: Int, var data: List<Int>) : ArrayAdapter<Int?>(ctx, layoutResourceId, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: DrawableHolder
        if (convertView == null) {
            val inflater = ctx
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(layoutResourceId, parent, false)
            holder = DrawableHolder()
            holder.images = convertView.findViewById<View>(R.id.images) as ImageView
            convertView.tag = holder
        } else {
            holder = convertView.tag as DrawableHolder
        }
        holder.images!!.setImageDrawable(context.resources.getDrawable(data[position]))
        return convertView!!
    }

    internal class DrawableHolder {
        var images: ImageView? = null
    }
}