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
        val p = player.receiveCard(card)
        assertThat(p.hand).contains(card)
        assertThat(p.hand).hasSize(2)
    }
}