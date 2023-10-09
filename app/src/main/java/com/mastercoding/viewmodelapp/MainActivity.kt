package com.mastercoding.viewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mastercoding.viewmodelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding object
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        // View Model Factory
        factory = MainActivityViewModelFactory(100)

        // View Model
        viewModel = ViewModelProvider(this,factory)
            .get(MainActivityViewModel::class.java)


        binding.textView.text = viewModel.getCurrentCount().toString()

        binding.btn.setOnClickListener(){
            binding.textView.text = viewModel.getUpdatedCount().toString()
        }




    }
}