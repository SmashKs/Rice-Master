package taiwan.no.one.ricemaster.registration.presentation.auth

interface CredentialHandler {
    suspend fun loginInWithGoogle(): String
}
