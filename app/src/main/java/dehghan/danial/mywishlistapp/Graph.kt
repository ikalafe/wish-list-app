package dehghan.danial.mywishlistapp

import android.content.Context
import androidx.room.Room
import dehghan.danial.mywishlistapp.data.WishDataBase
import dehghan.danial.mywishlistapp.repository.WishRepository

object Graph {
    lateinit var database: WishDataBase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDataBase::class.java, "wishlist.db").build()
    }
}