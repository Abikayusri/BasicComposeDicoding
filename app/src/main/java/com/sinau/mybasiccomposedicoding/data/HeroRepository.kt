package com.sinau.mybasiccomposedicoding.data

import com.sinau.mybasiccomposedicoding.model.Hero
import com.sinau.mybasiccomposedicoding.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero> {
        return HeroesData.heroes.filter {
            // ignoreCase digunakan supaya proses search tidak memperhatikan besar kecilnya huruf
            it.name.contains(query, ignoreCase = true)
        }
    }
}