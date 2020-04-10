package com.androidcourse.userprofilekotlin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_profile.*

class CreateProfileActivity : AppCompatActivity() {

    //A class variable var profileImageUri is created to keep track of the latest image selected.
    //The ImageView is set using this uri.
    private var profileImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)
        initViews()
    }

    private fun initViews() {
        btnGallery.setOnClickListener { onGalleryClick() }
        btnConfirm.setOnClickListener { onConfirmClick() }
    }

    private fun onGalleryClick() {
        //Intent is used to open the picture gallery
        // Create an Intent with action as ACTION_PICK
        val galleryIntent = Intent(Intent.ACTION_PICK)

        // Sets the type as image/*. This ensures only components of type image are selected
        galleryIntent.type = "image/*"

        // Start the activity using the gallery intent
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }

    /*
     * Create a [Profile] object start the [ProfileActivity] and parse the [Profile] object to it.
     */
    private fun onConfirmClick() {

        //Profile object is created using the input the user has given
        val profile = Profile(
            etFirstName.text.toString(),
            etLastName.text.toString(),
            etProfileDescription.text.toString(),
            profileImageUri
        )

        /*
        * An Intent is created with the ProfileActivity class to indicate that we want to start this
        * Activity.
        */
        val profileActivityIntent = Intent(this, ProfileActivity::class.java)
        //The Profile object is put as an extra with using a constant key.
        profileActivityIntent.putExtra(ProfileActivity.PROFILE_EXTRA, profile)
        //The activity is started using startActivity with the intent.
        startActivity(profileActivityIntent)
    }

    /*
     * When a [GALLERY_REQUEST_CODE] has been found store the uri in [profileImageUri] and set the
     * imageView with it.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                GALLERY_REQUEST_CODE -> {
                    profileImageUri = data?.data
                    ivProfileImage.setImageURI(profileImageUri)
                }
            }
        }
    }
    
    companion object {
        const val GALLERY_REQUEST_CODE = 100
    }
}
