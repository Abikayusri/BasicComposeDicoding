package com.sinau.mybasiccomposedicoding.data

import com.sinau.mybasiccomposedicoding.model.Hero
import com.sinau.mybasiccomposedicoding.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }
}