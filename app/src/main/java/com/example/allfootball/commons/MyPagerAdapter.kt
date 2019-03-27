package com.example.allfootball.commons

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.allfootball.laliga.LaligaFragment
import com.example.allfootball.premierleague.PremierLeagueFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PremierLeagueFragment()
            }
            1 -> {
                LaligaFragment()
            }
            else -> {
                return PremierLeagueFragment()
            }

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Premier League"
            1 -> "Laliga"
            else -> {
                return "Premier League"
            }
        }
    }

}