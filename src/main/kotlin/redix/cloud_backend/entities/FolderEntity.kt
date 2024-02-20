package redix.cloud_backend.entities

import jakarta.persistence.*

@Entity
@Table(name = "folders")
class FolderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String,
    val pathName: String,
    val parentId: Long,
    @JoinColumn(name = "user_id")
    val userId: Int,
    val path: String

)