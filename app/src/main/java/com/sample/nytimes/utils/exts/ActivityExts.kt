package com.sample.nytimes.utils.exts

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.sample.nytimes.generics.ViewModelFactory

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * Activity Extension functions
 */
fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance()).get(viewModelClass)