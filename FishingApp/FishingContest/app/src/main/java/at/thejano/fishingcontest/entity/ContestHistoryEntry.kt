package at.thejano.fishingcontest.entity

import java.util.*

class ContestHistoryEntry {
    constructor(name: String, location: String, numberOfParticipants: Int, winner: String) {
        this.name = name
        this.location = location
        this.numberOfParticipants = numberOfParticipants
        this.winner = winner
    }

    public var name: String
    public var location: String
    public var numberOfParticipants: Int = 0
    public lateinit var date: Date
    public var winner: String
}