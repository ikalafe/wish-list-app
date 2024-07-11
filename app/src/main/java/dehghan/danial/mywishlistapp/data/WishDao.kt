package dehghan.danial.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addWish(wishEntity:Wish)

    @Query("SELECT * FROM `wish_table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract fun updateWish(wishEntity: Wish)

    @Delete
    abstract fun deleteWish(wishEntity:Wish)

    @Query("SELECT * FROM `wish_table` where id=:id")
    abstract fun getWishById(id:Long):Flow<Wish>
}