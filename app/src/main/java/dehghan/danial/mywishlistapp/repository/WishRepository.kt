package dehghan.danial.mywishlistapp.repository

import dehghan.danial.mywishlistapp.data.Wish
import dehghan.danial.mywishlistapp.data.WishDao
import kotlinx.coroutines.flow.Flow
import kotlin.properties.Delegates

class WishRepository(private val wishDao: WishDao) {

    suspend fun addWish(wish: Wish) {
        wishDao.addWish(wish)
    }

    fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id: Long): Flow<Wish> {
        return wishDao.getWishById(id)
    }

    suspend fun updateWish(wish: Wish) {
        wishDao.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish) {
        wishDao.deleteWish(wish)
    }
}