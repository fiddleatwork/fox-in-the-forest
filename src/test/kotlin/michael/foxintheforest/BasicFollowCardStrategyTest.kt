package michael.foxintheforest

import org.assertj.core.api.Assertions
import org.junit.Assert.*
import org.junit.Test

class BasicFollowCardStrategyTest {

    private val strategy = BasicFollowCardStrategy()

    @Test
    fun `should take trick by playing higher suited card`() {
        val expected = Card(7, Suit.Moon)
        val player = Player(listOf(Card(1,Suit.Key),
                expected,
                Card(11, Suit.Orange),
                Card(7, Suit.Moon)),
                0,
                0,
                BasicLeadCardStrategy(),
                strategy)
        val card = strategy.select(player, 0, Suit.Orange, Card(6, Suit.Moon))
        Assertions.assertThat(card).isEqualTo(expected)
    }


    @Test
    fun `should take trick by playing lowest trump card`() {
        val expected = Card(1, Suit.Orange)
        val player = Player(listOf(
                Card(1,Suit.Key),
                expected,
                Card(9, Suit.Orange)),
                0,
                0,
                BasicLeadCardStrategy(),
                strategy)
        val card = strategy.select(player, 0, Suit.Orange, Card(6, Suit.Moon))
        Assertions.assertThat(card).isEqualTo(expected)
    }
}