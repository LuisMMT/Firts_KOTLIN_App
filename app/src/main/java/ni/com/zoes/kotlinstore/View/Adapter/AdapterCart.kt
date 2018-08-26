package ni.com.zoes.kotlinstore.View.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ni.com.zoes.kotlinstore.Models.ItemLanding
import ni.com.zoes.kotlinstore.R
import ni.com.zoes.kotlinstore.View.AnkoItemCart
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

/**
 * Created by LuisMT on 8/16/18.
 */
class AdapterCart(val data : List<ItemLanding>): RecyclerView.Adapter<AdapterCart.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(AnkoItemCart().createView(AnkoContext.Companion.create(parent!!.context,this,false)))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindView(data = data[position])

       }


    override fun getItemCount(): Int = data.size




    class Holder(itemView : View):RecyclerView.ViewHolder(itemView) {

        val imgV : ImageView by lazy {
            itemView.find<ImageView>(R.id.imgItem)
        }


        val txttitle: TextView by lazy {
            itemView.find<TextView>(R.id.text_title_item)
        }

        val txtdesc by lazy {
            itemView.find<TextView>(R.id.txt_title_desc)
        }

        val txtprice by lazy {
            itemView.find<TextView>(R.id.text_price_item)
        }
        fun bindView(data :ItemLanding){
            with(data){

            }
        }

    }




}

