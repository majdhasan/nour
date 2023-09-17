package life.majd.nour.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "lesson")
data class LessonEntity(
    @Id
    val id : UUID? = null,
    val courseId : UUID,
    val content: String
)