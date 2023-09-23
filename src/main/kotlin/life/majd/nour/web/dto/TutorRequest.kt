package life.majd.nour.web.dto

import life.majd.nour.repository.entity.TutorEntity

sealed class TutorRequest {

    class Register(
        private val email: String,
        private val password: String,
        private val name: String
    ) {

        fun toEntity() = TutorEntity(
            name = name,
            email = email,
            password = password
        )
    }

    class Login(
        val email: String,
        val password: String
    )
}

