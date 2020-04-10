package com.androidcourse.userprofilekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    /**
     * Populate the views with the profile object retrieved from the extras.
     */
    private fun initViews() {
        //By setting DisplayHomeAsUpEnabled to true a back arrow is added to the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "This is your profile!"

        //In the initViews method the Profile object sent with the Intent is retrieved using
        // intent.getParcelableExtra with the PROFILE_EXTRA key.
        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        if (profile != null) {

            //The name TextView is populated using the firstName and lastName from the profile
            // object which have been concatenated using a String with two placeholders from the
            // Strings.xml resource file.
            tvName.text = getString(R.string.name, profile.firstName, profile.lastName)

            //The description is populated using the description from the profile object
            tvDescription.text = profile.description

            //The ImageView has been set using the imageUri from the Profile object.
            if (profile.imageUri != null) ivProfileImage.setImageURI(profile.imageUri)
        }
    }

    //To detect a user clicking the back arrow button we need to override onOptionsItemSelected
    // which gets invoked when a menu button is selected. Each menu item has an id to identify which
    // button is clicked. The id of the back arrow is android.R.id.home. The activity is simply
    // finished when this button is clicked to it returns to the previous activity.
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val PROFILE_EXTRA = "PROFILE_EXTRA"
    }
}
