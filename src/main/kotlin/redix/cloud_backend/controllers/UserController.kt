package redix.cloud_backend.controllers

import org.springframework.web.bind.annotation.*
import redix.cloud_backend.dto.UserDto
import redix.cloud_backend.services.UserService
import redix.cloud_backend.utils.BaseResponse

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    //GET
    @GetMapping
    fun getUsers(): List<UserDto> = userService.getAll()

    @GetMapping("/{id}")
    fun getSingleUser(@PathVariable("id") id: Int): Any = userService.getSingleUser(id)

    //POST
    @PostMapping
    fun registerUser(@RequestBody dto: UserDto): BaseResponse = userService.registerUser(dto)

    //DELETE
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: Int): BaseResponse = userService.deleteUser(id)

}