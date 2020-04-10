package com.androidcourse.userprofilekotlin

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//We can use @Parcelize after upgrading the gradle
@Parcelize
data class Profile(
    val firstName: String,
    val lastName: String,
    val description: String,
    val imageUri: Uri? //? indicates this variable is nullable (profile image not required)
) : Parcelable

/*
* The data class implements Parcelable so that we can parse it between Activities. Using the
* Parcelize annotation will make sure that Kotlin takes care of configuring and updating the
* Parcelable implementation.
* */