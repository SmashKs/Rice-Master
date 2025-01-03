package taiwan.no.one.ricemaster.registration.domain.handler

interface CredentialHandler {
    suspend fun loginInWithGoogle(): String
}
