package ni.com.zoes.kotlinstore.Adapter
import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_landing.view.*
import ni.com.zoes.kotlinstore.Activity.DetailActivity
import ni.com.zoes.kotlinstore.Models.Item_Landing
import ni.com.zoes.kotlinstore.R
import ni.com.zoes.kotlinstore.Utils.inflate

/**
 * Created by LuisMT on 8/10/18.
 */
class AdapterLanding(val data:List<Item_Landing>,activity: Activity) : RecyclerView.Adapter<AdapterLanding.Holder>() {
    val mActivity = activity
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindView(data[position],mActivity)
    }

    override fun getItemCount(): Int = data.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(parent?.inflate(R.layout.item_landing))




    class Holder(itemView: View):RecyclerView.ViewHolder(itemView){


        fun bindView(item_Landing: Item_Landing,activity: Activity){
            with(item_Landing){
                itemView.txtNameItem.text = name
                itemView.txtTitleItem.text = title
                itemView.txtFechaPedidoItem.text = "F. Compra: $fechaPedido"
                itemView.txtFechaEntregaItem.text = "F. Entrega: $fechaEntrega"
                itemView.txtPriceItem.text ="$ ${String.format("%.2f",price)}"
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context,DetailActivity::class.java)
                    intent.putExtra("name",name)
                    intent.putExtra("title",title)
                    intent.putExtra("price",price)

                    val p1:Pair<View,String> = Pair.create(itemView.imageitemHeader,"transitionHeader")
                    val p2:Pair<View,String> = Pair.create(itemView.txtTitleItem,"transitionTitle")
                    val p3:Pair<View,String> = Pair.create(itemView.txtNameItem,"transitionName")
                    val p4:Pair<View,String> = Pair.create(itemView.txtPriceItem,"transitionPrice")
                    val options:ActivityOptionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(activity ,p1,p2,p3,p4)
                    itemView.context.startActivity(intent,options.toBundle())


                }

            }
        }
    }


}