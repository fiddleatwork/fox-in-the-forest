package michael.foxintheforest

data class Deck(val cards: List<Card>) {

    companion object Factory {
        fun create(): Deck {
            val cards: MutableList<Card> = mutableListOf()
            for (i in 1..11) {
                Suit.values().forEach {
                    cards.add(Card(i, it))
                }
            }
            cards.shuffle()
            return Deck(cards.toList())
        }
    }

    fun dealCardToPlayer(player: Player): Pair<Deck, Player> {
        val newDeck = cards.subList(1, cards.size)
        val card = cards[0]
        return Pair(Deck(newDeck), player.receiveCard(card))
    }

    fun getTopCard() : Pair<Deck, Card> {
        val newDeck = cards.subList(1, cards.size)
        val card = cards[0]
        return Pair(Deck(newDeck), card)
    }

    fun addCardToBottom(card: Card) : Deck {
        val newCards = cards.toMutableList()
        newCards.add(card)
        return Deck(newCards)
    }
}