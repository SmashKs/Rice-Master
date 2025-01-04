package taiwan.no.one.ricemaster.registration.data.model

sealed class LoginMethodModel(
    val token: String,
) {
    class Google(token: String) : LoginMethodModel(token)

    class Facebook(token: String) : LoginMethodModel(token)
}
