package ni.com.zoes.kotlinstore.View.Activity

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_description.*
import ni.com.zoes.kotlinstore.DataBase.DBOpenHelper
import ni.com.zoes.kotlinstore.R
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.startActivity

class DetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val  db =DBOpenHelper.getInstance(this)

        intent?.extras?.let {
            val titl = it.getString("title")
            val decr = it.getString("desc")
            val price = it.getDouble("price")

            detail_title.text = it.getString("title")
            detail_desc.text = it.getString("desc")
            detail_price.text ="$ ${String.format("%.2f", it.getDouble("price"))}"

            btn_detail_buy.setOnClickListener {
                /** use nos permite acceder a db sin necesidad de obtener permisos*/
                db?.use {
                    /** el nombre debe sere el mismo declarado en la tabla */
                    val namePr = "name" to titl
                    val titlePr = "desc" to decr
                    val pricePr = "price" to price

                    insert("TNProductos",namePr,titlePr,pricePr)
                }
                startActivity<ShopCartActivity>()
            }
        }
    }
}
