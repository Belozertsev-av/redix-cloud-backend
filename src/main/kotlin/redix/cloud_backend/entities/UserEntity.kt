package redix.cloud_backend.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val login: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val email: String,
    val phone: String,
    val diskSpace: Long,
    val usedSpace: Long
)