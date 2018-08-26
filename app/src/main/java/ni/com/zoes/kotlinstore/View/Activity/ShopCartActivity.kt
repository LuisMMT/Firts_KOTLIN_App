package ni.com.zoes.kotlinstore.View.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_shop_cart.*
import ni.com.zoes.kotlinstore.DataBase.DBOpenHelper
import ni.com.zoes.kotlinstore.Models.ItemLanding
import ni.com.zoes.kotlinstore.R
import ni.com.zoes.kotlinstore.View.Adapter.AdapterCart
import org.jetbrains.anko.db.select

class ShopCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_cart)

        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        rc_cart.layoutManager = layoutManager
        rc_cart.setHasFixedSize(true)

        val items = arrayListOf<ItemLanding>()

        (0..5).map {
            items.add(ItemLanding("Item $it","Desc $it", it+100.00))

            rc_cart.adapter = AdapterCart(items)
        }


    }
   override fun onResume() {
        super.onResume()
       val db = DBOpenHelper.getInstance(this)
       db?.use {
           select("TNProductos").exec {
               Log.e("Columnas","${this.columnCount}")
               Log.e("Columnas","${this.columnNames}")

               (this.columnNames).map {
                   Log.e("Columna","$it")
                   Log.e("Columna","${this.getColumnIndex(it)}")
                   Log.e("Columna","${this.getColumnName(this.getColumnIndex(it))}")
               }

               this.moveToFirst()
               do {
                   Log.e("Value",this.getString(1)?:"")
                   Log.e("Value",this.getString(2)?:"")
                   Log.e("Value","${this.getDouble(3)}")
               }while (this.moveToNext())
           }
       }
    }
}
