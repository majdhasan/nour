package life.majd.nour.web

import life.majd.nour.domain.service.EnrollmentCodeService
import life.majd.nour.repository.entity.EnrollmentCodeEntity
import life.majd.nour.web.dto.EnrollmentCodeRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/enroll-code", consumes = [MediaType.APPLICATION_JSON_VALUE])
class EnrollmentCodeController(val enrollmentCodeService: EnrollmentCodeService) {

    @PostMapping("")
    fun createEnrollmentCode(@RequestBody enrollmentCodeRequest: EnrollmentCodeRequest): ResponseEntity<EnrollmentCodeEntity> {
        val createdCourse =
            enrollmentCodeService.createEnrollmentCode(enrollmentCodeRequest.toEntity())
        return ResponseEntity(createdCourse, HttpStatus.CREATED)
    }

}
