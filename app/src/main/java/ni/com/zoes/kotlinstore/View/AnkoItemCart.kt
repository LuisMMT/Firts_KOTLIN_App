package ni.com.zoes.kotlinstore.View

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import ni.com.zoes.kotlinstore.R
import ni.com.zoes.kotlinstore.View.Adapter.AdapterCart
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by LuisMT on 8/16/18.
 */
class AnkoItemCart :AnkoComponent<AdapterCart>{
    override fun createView(ui: AnkoContext<AdapterCart>): View = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            cardView {
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    lparams(width = matchParent)

                    imageView(R.drawable.abc_ab_share_pack_mtrl_alpha) {
                        id = R.id.imgItem
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }.lparams(width = dip(0), height = dip(100), weight = 1f)

                    linearLayout {
                        padding = dip(5)
                        orientation = LinearLayout.VERTICAL
                        textView("Titulo producto") {
                            id = R.id.title
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Large)
                        }
                        textView("Descrición corta del producto") {
                            id = R.id.txt_title_desc
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Small)
                        }
                        textView("$230") {
                            id = R.id.txt_title_price
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Large)
                            textColor = resources.getColor(R.color.colorAccent)
                        }.lparams {
                            topMargin = dip(5)
                            gravity = Gravity.END
                        }
                    }.lparams(width = dip(0), height = wrapContent, weight = 2f)
                }
            }
        }
    }

}