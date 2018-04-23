package michael.foxintheforest

data class Round(val playersTurn: Int,
                 val players: List<Player>,
                 val drawPile: List<Card>,
                 val decreeCard: Card) {


}