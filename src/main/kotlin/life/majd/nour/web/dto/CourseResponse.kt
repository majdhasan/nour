package life.majd.nour.web.dto

import life.majd.nour.repository.entity.LessonEntity
import java.util.*

data class CourseResponse(
    val name: String,
    val description: String,
    val tutorId: UUID,
    val isPublic: Boolean,
    val lessons: List<LessonEntity> = emptyList()
)

