package life.majd.nour.web

import life.majd.nour.domain.service.CourseService
import life.majd.nour.domain.service.EnrollmentCodeService
import life.majd.nour.domain.service.EnrollmentService
import life.majd.nour.repository.entity.CourseEntity
import life.majd.nour.repository.entity.EnrollmentCodeEntity
import life.majd.nour.repository.entity.EnrollmentEntity
import life.majd.nour.web.dto.CourseRequest
import life.majd.nour.web.dto.EnrollmentCodeRequest
import life.majd.nour.web.dto.EnrollmentRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.function.ServerResponse
import java.util.*

@RestController
@RequestMapping("/enroll-code", consumes = [MediaType.APPLICATION_JSON_VALUE])
class EnrollmentCodeController(val enrollmentCodeService: EnrollmentCodeService) {

    @PostMapping("")
    fun createEnrollmentCode(@RequestBody enrollmentCodeRequest: EnrollmentCodeRequest): ResponseEntity<EnrollmentCodeEntity> {
        val createdCourse = enrollmentCodeService.createEnrollmentCode(enrollmentCodeRequest.toEntity())
        return ResponseEntity(createdCourse, HttpStatus.CREATED)
    }

}
