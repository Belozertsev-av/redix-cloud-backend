package redix.cloud_backend.services

import redix.cloud_backend.dto.UserDto
import redix.cloud_backend.utils.BaseResponse

interface UserService {
    fun getAll(): List<UserDto>
    fun getSingleUser(id: Int): Any
    fun registerUser(dto: UserDto): BaseResponse
    fun deleteUser(id: Int): BaseResponse
}