package at.thejano.fishingcontest.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import at.thejano.fishingcontest.R
import at.thejano.fishingcontest.StartNewContest
import at.thejano.fishingcontest.adapter.ContestHistoryAdapter

class ContestHistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_contest_history, container, false)

        val historyRecycler: RecyclerView = root.findViewById(R.id.recyclerViewContestHistory)
        historyRecycler.adapter = ContestHistoryAdapter()



        return root
    }
}
