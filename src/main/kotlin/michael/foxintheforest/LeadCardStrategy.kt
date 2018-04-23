package michael.foxintheforest

interface LeadCardStrategy {

    fun select(player: Player,
               opponentTricks: Int,
               decree: Suit) : Card

}