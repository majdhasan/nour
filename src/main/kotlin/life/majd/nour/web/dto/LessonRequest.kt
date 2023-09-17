package life.majd.nour.web.dto

import life.majd.nour.repository.entity.LessonEntity
import java.util.*

data class LessonRequest(
    val title: String,
    val courseId: UUID,
    val content: String = "",
    val isPublic: Boolean
) {

    fun toEntity() = LessonEntity(
        courseId = courseId,
        content = content
    )
}

