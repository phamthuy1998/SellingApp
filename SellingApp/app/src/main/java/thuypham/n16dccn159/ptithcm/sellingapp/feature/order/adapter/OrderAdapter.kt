package thuypham.n16dccn159.ptithcm.sellingapp.feature.order.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_order.view.*
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Order

class OrderAdapter(
    private var items: ArrayList<Order> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.item_order, viewGroup, false);
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OrderViewHolder).bind(items.get(position))
    }

    fun setOrderList(list: List<Order>) {

        items.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(order: Order) {
            // get name in list order detail to create string name include anothor names which have the same order id
            itemView.tv_name_item_order.text = order.name

            // set order id
            itemView.tv_item_order_detail_id.text = order.id.toString()
            // set order date
            itemView.tv_item_order_detail_date.text = order.buyDate
            // set status for order
            var status = ""
            // have received
            when (order.statusID) {
                1 -> {
                    status = itemView.context.getString(R.string.status_1)
                    itemView.iv_order_ic_status.setImageResource(R.drawable.ic_circle_arrow);
                }
                // shipping
                2 -> {
                    status = itemView.context.getString(R.string.status_2)
                    itemView.iv_order_ic_status.setImageResource(R.drawable.ic_shipping);
                }
                // order success
                3 -> {
                    status = itemView.context.getString(R.string.status_3)
                    itemView.iv_order_ic_status.setImageResource(R.drawable.ic_success);
                }
                // order cancel
                4 -> {
                    status = itemView.context.getString(R.string.status_4)
                    itemView.iv_order_ic_status.setImageResource(R.drawable.ic_error);
                }
            }
            itemView.tv_item_order_status.text = status

//            itemView.ll_item_order.setOnClickListener(){
//                val intent = Intent(context, OrderDetailActivity::class.java)
//                intent.putExtra("order_id", order.id)
//                context.startActivity(intent)
//            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
}