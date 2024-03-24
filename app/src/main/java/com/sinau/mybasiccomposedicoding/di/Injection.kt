package com.sinau.mybasiccomposedicoding.di

import com.sinau.mybasiccomposedicoding.data.RewardRepository

object Injection {
    fun provideRepository(): RewardRepository = RewardRepository.getInstance()
}