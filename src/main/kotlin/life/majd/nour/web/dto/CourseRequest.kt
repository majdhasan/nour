package life.majd.nour.web.dto

import life.majd.nour.repository.entity.CourseEntity
import java.util.*

data class CourseRequest(
    val name: String,
    val description: String,
    val tutorId: String
) {

    fun toEntity() = CourseEntity(
        name = name,
        description = description ?: "",
        tutorId = UUID.fromString(tutorId)
    )
}

