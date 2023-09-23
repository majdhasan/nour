package life.majd.nour.web

import life.majd.nour.domain.service.LessonService
import life.majd.nour.repository.entity.LessonEntity
import life.majd.nour.web.dto.LessonRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/lesson", consumes = [MediaType.APPLICATION_JSON_VALUE])
class LessonController(val lessonService: LessonService) {

    @GetMapping("")
    fun getCourses() = ResponseEntity(lessonService.getLessons(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getLesson(@PathVariable id: UUID) =
        ResponseEntity(lessonService.getLesson(id), HttpStatus.OK)

    @PostMapping("")
    fun createLesson(@RequestBody lessonRequest: LessonRequest): ResponseEntity<LessonEntity> {
        val createdLesson = lessonService.createLesson(lessonRequest.toEntity())
        return ResponseEntity(createdLesson, HttpStatus.CREATED)
    }

}
