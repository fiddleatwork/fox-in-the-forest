package michael.foxintheforest

data class Round(val playersTurn: Int,
                 val players: List<Player>,
                 val drawPile: List<Card>,
                 val decreeCard: Card) {


    fun start() {
        createDeck()

    }

    private fun createDeck() : List<Card> {
        val cards: MutableList<Card> = mutableListOf()
        for (i in 1..12) {
            Suit.values().forEach {
                cards.add(Card(i, it))
            }
        }
        cards.shuffle()
        return cards.toList()
    }
}