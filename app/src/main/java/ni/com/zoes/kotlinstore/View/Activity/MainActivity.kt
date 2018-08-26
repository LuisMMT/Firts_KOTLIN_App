package ni.com.zoes.kotlinstore.View.Activity
import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import ni.com.zoes.kotlinstore.View.Adapter.AdapterLanding
import ni.com.zoes.kotlinstore.DataBase.DBOpenHelper
import ni.com.zoes.kotlinstore.Models.ItemLanding
import ni.com.zoes.kotlinstore.R
import org.jetbrains.anko.act
import org.jetbrains.anko.db.select

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc_landing.layoutManager = GridLayoutManager(this,2)

        val itemsShop = (0..20).map {
            ItemLanding("Jose $it","Descr $it",200.00+it)
        }
        val adapter = AdapterLanding(itemsShop,act)
        rc_landing.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        val db=DBOpenHelper.getInstance(this)
        db?.use{
           select("TNProductos").exec {
               Log.e("Columnas:","${this.columnCount}")
               Log.e("Columnas:","${this.columnNames.size}")

           }
        }
    }
}
