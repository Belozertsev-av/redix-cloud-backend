package redix.cloud_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CloudBackendApplication

fun main(args: Array<String>) {
    runApplication<CloudBackendApplication>(*args)
}
