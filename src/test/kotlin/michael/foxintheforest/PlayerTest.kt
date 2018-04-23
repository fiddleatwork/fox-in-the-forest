package michael.foxintheforest

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PlayerTest {

    @Test
    fun receiveCard() {
        val player = Player(listOf(Card(1,Suit.Key)),
                0,
                0,
                BasicLeadCardStrategy(),
                BasicFollowCardStrategy())
        val card = Card(2, Suit.Key)
        player.receiveCard(card)
        assertThat(player.hand).contains(card)
        assertThat(player.hand).hasSize(2)
    }
}