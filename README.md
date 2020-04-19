# Blackjack_java

This game of blackjack runs in consol.

The value of cards two through ten is their pip value (2 through 10). Face cards (Jack, Queen, and King) are all worth ten. Aces can be worth one or eleven. A hand's value is the sum of the card values.

The dealer plays hard seventeen strategy - must hit until the cards total up to 17 points. At 17 points or higher, the dealer must stay.

You are betting that you have a better hand than the dealer. The better hand is the hand where the sum of the card values is closer to 21 without exceeding 21. The detailed outcome of the hand follows:

 - If the player is dealt an Ace and a ten-value card, and the dealer does not, the player wins and receives a bonus. 
 - If the player exceeds a sum of 21 ("busts") and dealer has 21 or less - the player loses. 
 - If the dealer exceeds 21 ("busts") and the player does not; the player wins. 
 - If the player attains a final sum higher than the dealer and does not bust; the player wins. 
 - If both dealer and player bust or receive a blackjack or any other hands with the same sum, called a "push", no one wins. 
 
 After receiving an initial two cards, the player has up to four standard options: "hit", "stay", "double", or "split".  
 - Hit: Take another card from the dealer.  Stay: Take no more cards.  
 - Double: The player is allowed to increase the initial bet by 100% in exchange for committing to stand after receiving exactly one more card. The option is avalible only when the player has two cards.  
 - Split: If the first two cards of a hand have the same value, the player can split them into two hands, separates the two cards and draws an additional card on each, placing one bet with each hand. The player then plays out the two separate hands in turn. They are treated as independent new hands, with the player winning or losing their wager separately for each hand. In the case of ten-valued cards, player is allowed splitting only when the cards have identical ranks; for instance, a hand of 10-10 may be split, but not one of 10-king.
