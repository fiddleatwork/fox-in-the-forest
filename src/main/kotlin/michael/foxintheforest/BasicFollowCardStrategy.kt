package michael.foxintheforest

class BasicFollowCardStrategy : FollowCardStrategy {
    override fun select(player: Player, opponentTricks: Int, decree: Suit, leadCard: Card): Card {
        val cardsOfSuit = player.cardsOf(leadCard.suit)
        if(cardsOfSuit.isNotEmpty()) {
            val higherCards = cardsOfSuit.filter{it.number > leadCard.number}
            if(higherCards.isNotEmpty()) {
                return higherCards.first()
            }
            return cardsOfSuit.first()
        }
        val trumpCards = player.cardsOf(decree)
        if(trumpCards.isNotEmpty()) {
            return trumpCards.first()
        }
        val otherSuit = Suit.values().first {it != decree && it != leadCard.suit}
        return player.cardsOf(otherSuit).first()
    }
}