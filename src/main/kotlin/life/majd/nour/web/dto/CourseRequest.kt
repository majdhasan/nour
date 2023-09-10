package life.majd.nour.web.dto

import life.majd.nour.repository.entity.CourseEntity
import java.util.*

data class CourseRequest(
    val name: String,
    val description: String,
    val tutorId: String,
    val isPublic: Boolean
) {

    fun toEntity() = CourseEntity(
        name = name,
        description = description,
        tutorId = UUID.fromString(tutorId),
        isPublic = isPublic
    )
}

