package ni.com.zoes.kotlinstore.Activity

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_description.*
import ni.com.zoes.kotlinstore.R

class DetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.extras?.let {
            nameDetail.text = it.getString("name")
            titleDetail.text = it.getString("title")
            priceDetail.text ="$ ${String.format("%.2f", it.getDouble("price"))}"
        }
    }
}
