package life.majd.nour.web

import life.majd.nour.domain.service.CourseService
import life.majd.nour.repository.entity.CourseEntity
import life.majd.nour.web.dto.CourseRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/course", consumes = [MediaType.APPLICATION_JSON_VALUE])
@CrossOrigin(origins = ["http://localhost:3000"])
class CourseController(val courseService: CourseService) {

    @GetMapping("")
    fun getCourses() = ResponseEntity(courseService.getCourses(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getCourse(@PathVariable id: UUID) =
        ResponseEntity(courseService.getCourse(id), HttpStatus.OK)

    @PostMapping("")
    fun createCourse(@RequestBody courseRequest: CourseRequest): ResponseEntity<CourseEntity> {
        val createdCourse = courseService.createCourse(courseRequest.toEntity())
        return ResponseEntity(createdCourse, HttpStatus.CREATED)
    }

}
