package michael.foxintheforest

interface FollowCardStrategy {

    fun select(player: Player,
               opponentTricks: Int,
               decree: Suit,
               leadCard: Card) : Card

}