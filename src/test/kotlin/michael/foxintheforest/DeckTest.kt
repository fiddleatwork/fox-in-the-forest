package michael.foxintheforest

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DeckTest {

    private val deck = Deck.create()

    @Test
    fun `should create deck`() {
        assertThat(deck.cards).hasSize(11 * 3)
        assertThat(deck.cards.filter { it.suit == Suit.Moon }.size).isEqualTo(11)
    }

    @Test
    fun `should deal card to player`() {
        val player = Player(listOf(), 0, 0,
                BasicLeadCardStrategy(), BasicFollowCardStrategy())
        val (deckWithoutCard, playerWithCard) = deck.dealCardToPlayer(player)
        assertThat(playerWithCard.hand.contains(deck.cards[0]))
        assertThat(deckWithoutCard.cards).doesNotContain(deck.cards[0])
    }

    @Test
    fun `should get top card`() {
        val (deckWithoutCard, card) = deck.getTopCard()
        assertThat(card).isEqualTo(deck.cards[0])
        assertThat(deckWithoutCard.cards).doesNotContain(deck.cards[0])
    }

}