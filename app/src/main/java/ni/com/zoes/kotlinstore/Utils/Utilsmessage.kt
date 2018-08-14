package ni.com.zoes.kotlinstore.Utils

import android.app.Activity
import android.widget.Toast

/**
 * Created by LuisMT on 8/10/18.
 */

fun Activity.toastShort(mensaje:String){
    Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show()
}

fun Activity.toastLong(mensaje:String){
    Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()
}