package ni.com.zoes.kotlinstore.Activity
import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ni.com.zoes.kotlinstore.Adapter.AdapterLanding
import ni.com.zoes.kotlinstore.Models.Item_Landing
import ni.com.zoes.kotlinstore.R
import org.jetbrains.anko.act

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcViewLanding.layoutManager = GridLayoutManager(this,2)

        val itemsShop = (0..50).map {
            Item_Landing("Jose $it","Nintendo Switch $it","25/02/200$it","25/05/200$it",200.0000+it)
        }
        val adapter = AdapterLanding(itemsShop,act)
        rcViewLanding.adapter = adapter

    }
}
