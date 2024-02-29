package com.slivtis.tienda.data.db.entity

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "productos")
class Products(
    @ColumnInfo(name = "descripcion")var descripcion: String?,
    @ColumnInfo(name = "cantidad")var cantidad: Double,
    @ColumnInfo(name = "fecha")var fecha: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
    @ColumnInfo(name = "activo")
    var activo: Boolean = true
    @ColumnInfo(name = "created_at")
    var createdAt: Long =  System.currentTimeMillis()
    @ColumnInfo(name = "updated_at")
    var updatedAt: Long? = null
    @ColumnInfo(name = "deleted_at")
    var deletedAt: Long? = null
}
