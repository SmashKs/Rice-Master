package taiwan.no.one.ricemaster.registration.presentation.entity.mapper

import taiwan.no.one.ricemaster.registration.data.model.SignInInfoModel
import taiwan.no.one.ricemaster.registration.data.model.SignUpInfoModel
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInInfoEntity
import taiwan.no.one.ricemaster.registration.presentation.entity.SignUpInfoEntity

fun SignInInfoModel.toEntity(): SignInInfoEntity = SignInInfoEntity(
    email = email,
    password = password,
)

fun SignUpInfoModel.toEntity(): SignUpInfoEntity = SignUpInfoEntity(
    email = email,
    password = password,
    confirmPassword = confirmPassword,
)
