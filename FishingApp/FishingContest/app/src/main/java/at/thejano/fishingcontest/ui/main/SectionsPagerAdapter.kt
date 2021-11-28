package at.thejano.fishingcontest.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import at.thejano.fishingcontest.R

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    private  var tabs: List<TabEntry> = listOf(
        TabEntry(ContestHistoryFragment(), R.string.tab_title_contest_history),
        TabEntry(LeaderboardFragment(), R.string.tab_title_leaderboard)
    )

    override fun getItem(position: Int): Fragment {
        return tabs[position].fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(tabs[position].tabTitleId)
    }

    override fun getCount(): Int {
        return tabs.size
    }
}

class TabEntry (
    public var fragment: Fragment,
    public var tabTitleId: Int
)
