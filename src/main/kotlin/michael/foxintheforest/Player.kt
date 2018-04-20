package michael.foxintheforest

data class Player(val hand: List<Card>, val tricks: Int, val score: Int) {

    fun receiveCard(card: Card) : Player {
        val newPlayerHand = hand.toMutableList()
        newPlayerHand.add(0, card)
        return copy(hand = newPlayerHand)
    }

    fun playFollowCard(opponentTricks: Int, decree: Suit, opponentCard: Card, strategy : Strategy) : Pair<Card, Player> {
        val card = strategy.selectCard()
        val newHand = hand.toMutableList()
        newHand.remove(card)
        return Pair(card, copy(hand = newHand))
    }

    fun playLeadCard(opponentTricks: Int, decree: Suit, strategy : Strategy) : Pair<Card, Player> {
        val card = strategy.selectCard()
        val newHand = hand.toMutableList()
        newHand.remove(card)
        return Pair(card, copy(hand = newHand))
    }

    fun cardsOf(suit: Suit) : List<Card> {
        return hand.filter{it.suit == suit}
    }

}