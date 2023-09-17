package life.majd.nour.repository.entity

import life.majd.nour.web.dto.CourseResponse
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "course")
data class CourseEntity(
    @Id
    val id: UUID? = null,
    val name: String,
    val description: String,
    val tutorId: UUID,
    val isPublic: Boolean,
) {

    fun toCourseResponse() = CourseResponse(
        name = name,
        description = description,
        tutorId = tutorId,
        isPublic = isPublic
    )
}

