package redix.cloud_backend.repositories

import org.springframework.data.repository.CrudRepository
import redix.cloud_backend.entities.UserEntity

interface UserRepository : CrudRepository<UserEntity, Int> {
    fun findByOrderById(): List<UserEntity>
    fun getById(id: Int): UserEntity
}