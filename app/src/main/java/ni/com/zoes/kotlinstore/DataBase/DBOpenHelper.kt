package ni.com.zoes.kotlinstore.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by LuisMT on 8/14/18.
 */
class DBOpenHelper(ctx:Context):ManagedSQLiteOpenHelper(ctx,"KotlinStore",null,1) {

    /**crea una instancia del objeto*/
    companion object {
        private var instance :DBOpenHelper? = null

        /**obtiene la instancia retorna la instancia*/
        fun getInstance(ctx: Context):DBOpenHelper?= if (instance==null) {

            instance = DBOpenHelper(ctx)
            instance
        }else{
            instance
        }
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val id = "id" to INTEGER + PRIMARY_KEY
        val name = "name" to TEXT
        val title = "desc" to TEXT
        val price = "price" to REAL

        /**this line create Table*/
        db?.createTable("TNProductos",true,id,name,title,price)

    }

    override fun onUpgrade(db: SQLiteDatabase?, odl: Int, newV: Int) {
        /** borra base de datos */
        db?.dropTable("TNProductos",true)


    }

    /** sobreescribe el get*/
    val Context.dataBase : DBOpenHelper?
    get() = getInstance(applicationContext)


}