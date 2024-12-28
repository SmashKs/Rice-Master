package taiwan.no.one.ricemaster.registration.presentation.auth

interface GoogleAuthUiProvider {
    /**
     * Opens Sign In with Google UI,
     *
     * @return returns GoogleUser
     */
    suspend fun signIn(): GoogleUser?
}
