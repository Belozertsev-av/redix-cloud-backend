package redix.cloud_backend.services.implementations

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import redix.cloud_backend.dto.UserDto
import redix.cloud_backend.entities.FolderEntity
import redix.cloud_backend.entities.UserEntity
import redix.cloud_backend.repositories.FolderRepository
import redix.cloud_backend.repositories.UserRepository
import redix.cloud_backend.services.UserService
import redix.cloud_backend.utils.BaseResponse
import redix.cloud_backend.utils.STORAGE_PATH
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val folderRepository: FolderRepository
) : UserService {
    override fun getAll(): List<UserDto> {
        return userRepository.findByOrderById().map { it.toDto() }
    }

    override fun getSingleUser(id: Int): Any {
        return userRepository.findByIdOrNull(id)?.toDto()
            ?: BaseResponse(404, "Пользователь с id = $id не найден")
    }

    override fun registerUser(dto: UserDto): BaseResponse {
        val userId = userRepository.save(dto.toEntity()).id
        val uploadDir = File(STORAGE_PATH + '/' + dto.login)
        if (!uploadDir.exists()) uploadDir.mkdir()
        folderRepository.save(
            FolderEntity(
                name = "Домашняя папка",
                pathName = dto.login,
                parentId = 0,
                userId = userId,
                path = "/${dto.login}"
            )
        )
        return BaseResponse(200, "Пользователь успешно создан")
    }

    override fun deleteUser(id: Int): BaseResponse {
        val user = userRepository.findByIdOrNull(id)
            ?: throw NotFoundException()
        val userFolder = folderRepository.getByUserId(id)
        Files.delete(Path(STORAGE_PATH + userFolder.path))
        folderRepository.deleteById(userFolder.id)
        userRepository.deleteById(user.id)
        return BaseResponse(200, "Пользователь успешно удален")
    }

    private fun UserEntity.toDto(): UserDto {
        return UserDto(
            id = this.id,
            login = this.login,
            password = this.password,
            firstName = this.firstName,
            lastName = this.lastName,
            avatar = this.avatar,
            email = this.email,
            phone = this.phone,
            diskSpace = this.diskSpace,
            usedSpace = this.usedSpace
        )
    }

    private fun UserDto.toEntity(): UserEntity {
        return UserEntity(
            login = this.login,
            password = this.password,
            firstName = this.firstName,
            lastName = this.lastName,
            avatar = this.avatar,
            email = this.email,
            phone = this.phone,
            diskSpace = this.diskSpace,
            usedSpace = this.usedSpace
        )
    }
}

