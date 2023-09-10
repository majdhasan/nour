package life.majd.nour.web

import life.majd.nour.domain.service.TutorService
import life.majd.nour.repository.entity.TutorEntity
import life.majd.nour.web.dto.TutorRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.function.ServerResponse
import java.util.*

@RestController
@RequestMapping("/tutor")
class TutorController (
    val tutorService: TutorService
){

    @GetMapping("")
    fun getTutors(): ServerResponse {
        return ServerResponse.ok().body(tutorService.getTutors())
    }

    @PostMapping("")
    fun createCourse(@RequestBody tutorRequest: TutorRequest): ResponseEntity<TutorEntity> {
        val createdTutor = tutorService.createTutor(tutorRequest.toEntity())
        return ResponseEntity(createdTutor, HttpStatus.CREATED)
    }
}
