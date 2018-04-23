package michael.foxintheforest

class BasicLeadCardStrategy : LeadCardStrategy {
    override fun select(player: Player, opponentTricks: Int, decree: Suit): Card {
        val nonTrumpCards = player.cardsNotOf(decree)
        return if(nonTrumpCards.isNotEmpty()) {
            nonTrumpCards.last()
        } else {
            player.cardsOf(decree).last()
        }
    }
}