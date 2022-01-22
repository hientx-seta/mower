package com.hientx.mower

import com.hientx.mower.Constant.Companion.MAX_X_VALUE
import com.hientx.mower.Constant.Companion.MAX_Y_VALUE
import com.hientx.mower.Constant.Companion.MIN_XY_VALUE
import org.junit.Test

import org.junit.Assert.*

/**
 * Test functions getDestinationMower and getOrientationEnum in Mower
 *
 */

class MowerUnitTest {
    @Test
    fun test_getDestination_mower_first_case() {
        val position = Position(1, 2, Orientation.N)
        val expectPosition = Position(1, 3, Orientation.N)

        val mover = Mower()
        //LF LF LF LF F
        val steps = listOf(Moving.L, Moving.F, Moving.L, Moving.F, Moving.L, Moving.F, Moving.L, Moving.F, Moving.F)
        val resultPosition = mover.getDestinationMower(position, steps)

        assertEquals(expectPosition.toString(), resultPosition.toString())
    }

    @Test
    fun test_getDestination_mower_second_case() {
        val position = Position(3, 3, Orientation.E)
        val expectPosition = Position(5, 1, Orientation.E)

        val mover = Mower()
        //FF RF FR FR RF
        val steps = listOf(Moving.F, Moving.F, Moving.R, Moving.F, Moving.F, Moving.R, Moving.F, Moving.R, Moving.R, Moving.F)
        val resultPosition = mover.getDestinationMower(position, steps)

        assertEquals(expectPosition.toString(), resultPosition.toString())
    }

    @Test
    fun test_getDestination_mower_do_not_move_out() {
        val position = Position(1, 1, Orientation.N)

        val expectPositionOutLeft = Position(MIN_XY_VALUE, 2, Orientation.N)
        val expectPositionOutUp = Position(2, MAX_Y_VALUE, Orientation.E)
        val expectPositionOutRight = Position(MAX_X_VALUE, 0, Orientation.S)
        val expectPositionOutDown = Position(0, MIN_XY_VALUE, Orientation.W)

        val mover = Mower()
        //L FFFFF RF
        val stepsLeft = listOf(Moving.L, Moving.F, Moving.F, Moving.F, Moving.F, Moving.F, Moving.R, Moving.F)
        //FFFFF RF
        val stepsUp = listOf(Moving.F, Moving.F, Moving.F, Moving.F, Moving.F, Moving.R, Moving.F)
        //R FFFFF RF
        val stepsRight = listOf(Moving.R, Moving.F, Moving.F, Moving.F, Moving.F, Moving.F, Moving.R, Moving.F)
        //LL FFFFF RF
        val stepsDown = listOf(Moving.L, Moving.L, Moving.F, Moving.F, Moving.F, Moving.F, Moving.F, Moving.R, Moving.F)

        val resultPositionLeft = mover.getDestinationMower(position, stepsLeft)
        val resultPositionUp = mover.getDestinationMower(position, stepsUp)
        val resultPositionRight = mover.getDestinationMower(position, stepsRight)
        val resultPositionDown = mover.getDestinationMower(position, stepsDown)

        assertEquals(expectPositionOutLeft.toString(), resultPositionLeft.toString())
        assertEquals(expectPositionOutUp.toString(), resultPositionUp.toString())
        assertEquals(expectPositionOutRight.toString(), resultPositionRight.toString())
        assertEquals(expectPositionOutDown.toString(), resultPositionDown.toString())
    }

    @Test
    fun test_getOrientationEnum_mower() {
        val valueN = 0
        val expectN = Orientation.N

        val valueE = 1
        val expectE = Orientation.E
        val valueS = 2
        val expectS = Orientation.S
        val valueW = 3
        val expectW = Orientation.W

        val mover = Mower()
        val resultN = mover.getOrientationEnum(valueN)
        val resultE = mover.getOrientationEnum(valueE)
        val resultS = mover.getOrientationEnum(valueS)
        val resultW = mover.getOrientationEnum(valueW)

        assertEquals(expectN.name, resultN.name)
        assertEquals(expectE.name, resultE.name)
        assertEquals(expectS.name, resultS.name)
        assertEquals(expectW.name, resultW.name)
    }
}