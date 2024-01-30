package life.majd.nour.web

import life.majd.nour.domain.service.CourseService
import life.majd.nour.repository.entity.CourseEntity
import life.majd.nour.web.dto.CourseRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/course")
@CrossOrigin(origins = ["http://localhost:3000"])
class CourseController(val courseService: CourseService) {

    @GetMapping
    fun getCoursesByName(@RequestParam(required = false) name: String?): ResponseEntity<List<CourseEntity>> {
        if (name != null) {
            val filteredCourses = courseService.getCoursesByNameContaining(name)
            return ResponseEntity(filteredCourses, HttpStatus.OK)
        }

        val allCourses = courseService.getCourses()
        return ResponseEntity(allCourses, HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun getCourse(@PathVariable id: UUID) =
        ResponseEntity(courseService.getCourse(id), HttpStatus.OK)

    @GetMapping("/{id}/lessons")
    fun getCourseLessons(@PathVariable id: UUID) =
        ResponseEntity(courseService.getCourse(id), HttpStatus.OK)


    @PostMapping("")
    fun createCourse(@RequestBody courseRequest: CourseRequest): ResponseEntity<CourseEntity> {
        val createdCourse = courseService.createCourse(courseRequest.toEntity())
        return ResponseEntity(createdCourse, HttpStatus.CREATED)
    }

}
