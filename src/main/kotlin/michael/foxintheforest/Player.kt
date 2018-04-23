package michael.foxintheforest

import java.util.*

data class Player(val hand: List<Card>,
                  val tricks: Int,
                  val score: Int,
                  val leadCardStrategy: LeadCardStrategy,
                  val followCardStrategy: FollowCardStrategy) {


    fun receiveCard(card: Card): Player {
        val newPlayerHand = hand.toMutableList()
        newPlayerHand.add(0, card)
        return copy(hand = newPlayerHand)
    }

    fun playFollowCard(opponentTricks: Int, decree: Suit, leadCard: Card)
            : Pair<Card, Player> {
        val card = followCardStrategy.select(this, opponentTricks, decree, leadCard)
        verifyCardFollowsSuite(card, decree)
        val newHand = hand.toMutableList()
        newHand.remove(card)
        return Pair(card, copy(hand = newHand))
    }

    private fun verifyCardFollowsSuite(card: Card, decree: Suit) {
        if (cardsOf(decree).isNotEmpty() && card.suit != decree) {
            throw  IllegalStateException("Card would not follow suit")
        }
    }

    fun playLeadCard(opponentTricks: Int, decree: Suit)
            : Pair<Card, Player> {
        val card = leadCardStrategy.select(this, opponentTricks, decree)
        val newHand = hand.toMutableList()
        newHand.remove(card)
        return Pair(card, copy(hand = newHand))
    }

    fun cardsOf(suit: Suit): List<Card> {
        return hand.filter { it.suit == suit }.sortedBy { it.number }
    }

    fun cardsNotOf(suit: Suit): List<Card> {
        return hand.filter { it.suit != suit }.sortedBy { it.number }
    }

    private fun highestCardOf(suit: Suit): Optional<Card> {
        val cardsOfSuit = cardsOf(suit)
        if(cardsOfSuit.isEmpty()) {
            return Optional.empty()
        }
        return Optional.of(cardsOfSuit[cardsOfSuit.size])
    }

    private fun lowestCardOf(suit: Suit): Optional<Card> {
        val cardsOfSuit = cardsOf(suit)
        if(cardsOfSuit.isEmpty()) {
            return Optional.empty()
        }
        return Optional.of(cardsOfSuit[0])
    }

}