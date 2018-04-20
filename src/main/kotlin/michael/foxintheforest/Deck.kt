package michael.foxintheforest

data class Deck(val cards: List<Card>) {

    fun dealCard(player: Player): Pair<Deck, Player> {
        val newDeck = cards.subList(1, cards.size)
        val card = cards[0]
        return Pair(Deck(newDeck), player.receiveCard(card))
    }

}