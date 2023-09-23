package life.majd.nour.web.dto

import life.majd.nour.repository.entity.CourseEntity

data class TutorResponse(
    val name: String,
    val courses: List<CourseEntity> = emptyList()
)

