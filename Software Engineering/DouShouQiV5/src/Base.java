/**
 * @brief define constants for the board itself.
 *
 * these never move as they are part of the board.
 *
 * Copyright © George J. Grevera, 2016. All rights reserved.
 */
public enum Base {
    cGround,  ///< ordinary ground
    cWater,   ///< water
    cRTrap,   ///< red (side of board) trap
    cBTrap,   ///< black (side of board) trap
    cRDen,    ///< red (side of board) den
    cBDen,    ///< black (side of board) den
    cNone     ///< not used/out of bounds
}
