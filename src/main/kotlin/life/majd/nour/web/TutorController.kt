package life.majd.nour.web

import life.majd.nour.domain.service.TutorService
import life.majd.nour.repository.entity.TutorEntity
import life.majd.nour.web.dto.TutorRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.function.ServerResponse
import java.util.*

@RestController
@RequestMapping("/api/v1/tutor")
@CrossOrigin(origins = ["http://localhost:3000"])
class TutorController(
    val tutorService: TutorService
) {

    val logger: Logger = LoggerFactory.getLogger(TutorController::class.java)

    @GetMapping("")
    fun getTutors(): ServerResponse {
        return ServerResponse.ok().body(tutorService.getTutors())
    }

    @GetMapping("/{id}")
    fun getTutor(@PathVariable id: String): ServerResponse {
        return ServerResponse.ok().body(tutorService.getTutor(UUID.fromString(id)))
    }

    @PostMapping("/register")
    fun createTutor(@RequestBody tutorRequest: TutorRequest.Register): ResponseEntity<TutorEntity> {
        val createdTutor = tutorService.createTutor(tutorRequest.toEntity())
        return ResponseEntity(createdTutor, HttpStatus.CREATED)
    }

    @PostMapping("/login")
    fun loginTutor(@RequestBody tutorRequest: TutorRequest.Login): ResponseEntity<TutorEntity> {
        logger.info("login invoked")
        return tutorService.loginTutor(tutorRequest)?.let { ResponseEntity(it, HttpStatus.OK) }
            ?: ResponseEntity(HttpStatus.FORBIDDEN)
    }
}
