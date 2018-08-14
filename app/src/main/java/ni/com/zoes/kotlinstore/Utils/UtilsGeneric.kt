package ni.com.zoes.kotlinstore.Utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by LuisMT on 8/10/18.
 */
fun ViewGroup.inflate(layoutId:Int): View {
    return LayoutInflater.from(context).inflate(layoutId,this,false)

}