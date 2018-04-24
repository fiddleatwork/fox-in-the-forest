package michael.foxintheforest

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BasicLeadCardStrategyTest {

    @Test
    fun `should select highest non-trump card`() {
        val strategy = BasicLeadCardStrategy()
        val expected = Card(5, Suit.Moon)
        val player = Player(listOf(Card(1,Suit.Key),
                expected,
                Card(11, Suit.Orange)),
                0,
                0,
                strategy,
                BasicFollowCardStrategy())
        val card = strategy.select(player, 0, Suit.Orange)
        assertThat(card).isEqualTo(expected)
    }



}