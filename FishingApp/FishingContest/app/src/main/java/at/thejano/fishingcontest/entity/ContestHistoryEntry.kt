package at.thejano.fishingcontest.entity

import java.util.*

class ContestHistoryEntry {
    public lateinit var name: String
    public lateinit var location: String
    public var numberOfParticipants: Int = 0
    public lateinit var date: Date
    public lateinit var winner: String
}