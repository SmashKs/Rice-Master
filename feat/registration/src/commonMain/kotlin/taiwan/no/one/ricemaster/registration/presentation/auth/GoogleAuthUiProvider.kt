package taiwan.no.one.ricemaster.registration.presentation.auth

import taiwan.no.one.ricemaster.user.model.UserModel

interface GoogleAuthUiProvider {
    /**
     * Opens Sign In with Google UI,
     *
     * @return returns GoogleUser
     */
    suspend fun signIn(): UserModel?
}
