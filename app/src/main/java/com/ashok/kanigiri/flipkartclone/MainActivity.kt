package com.ashok.kanigiri.flipkartclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.setupWithNavController
import com.ashok.kanigiri.flipkartclone.databinding.ActivityMainBinding
import com.ashok.kanigiri.flipkartclone.features.utils.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpBottomNav()
    }

    private fun setUpBottomNav() {
        val navGraphIds = listOf<Int>(
            R.navigation.nav_graph_home,
            R.navigation.nav_graph_categories,
            R.navigation.nav_graph_notifications,
            R.navigation.nav_graph_account,
            R.navigation.nav_graph_cart,
        )

        binding.bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )
    }
}