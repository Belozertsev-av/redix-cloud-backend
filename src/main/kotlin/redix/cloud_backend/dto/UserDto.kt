package redix.cloud_backend.dto

data class UserDto(
    val id: Int? = null,
    val login: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val avatar: String = "default_icon.png",
    val email: String,
    val phone: String,
    val diskSpace: Long = 1_000_000,
    val usedSpace: Long = 0
)
