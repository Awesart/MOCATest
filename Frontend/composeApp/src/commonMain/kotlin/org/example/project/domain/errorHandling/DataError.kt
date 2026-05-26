package org.example.project.domain.errorHandling

sealed interface DataError: Error {
    enum class Network: DataError{
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERIALIZATION,
        UNKNOWN,
        NOT_AUTHORIZED,
        FORBIDDEN,
        NOT_FOUND
    }

    enum class Local: DataError{
        HTTP_CLIENT_ISSUE,
        APPLICATION
    }

}