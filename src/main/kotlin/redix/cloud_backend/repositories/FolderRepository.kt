package redix.cloud_backend.repositories

import org.springframework.data.repository.CrudRepository
import redix.cloud_backend.entities.FolderEntity

interface FolderRepository : CrudRepository<FolderEntity, Int> {
    fun getByUserId(id: Int): FolderEntity
}