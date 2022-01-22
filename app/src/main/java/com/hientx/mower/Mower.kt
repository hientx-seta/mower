package com.hientx.mower

import com.hientx.mower.Constant.Companion.E_VALUE
import com.hientx.mower.Constant.Companion.MAX_X_VALUE
import com.hientx.mower.Constant.Companion.MAX_Y_VALUE
import com.hientx.mower.Constant.Companion.MIN_XY_VALUE
import com.hientx.mower.Constant.Companion.MODULO_VALUE
import com.hientx.mower.Constant.Companion.N_VALUE
import com.hientx.mower.Constant.Companion.S_VALUE
import com.hientx.mower.Constant.Companion.W_VALUE
import java.lang.Exception

open class Mower {

    /**
     *
     * This function returns the new position from current position and list of steps
     * throw Exception if the data is not valid
     *
     * @param Position current position
     * @param List<Moving> List steps of moving
     *
     */
    fun getDestinationMower(position: Position, movingSteps: List<Moving>): Position {
        if (movingSteps.isEmpty())
            return position
        else {
            //Get value of first position
            var newOrientationValue = position.orientation.ordinal
            var newXValue = position.x
            var newYValue = position.y

            for (step in movingSteps) {
                //Change x,y when step has the changing
                if (step.deltaMoving != 0) {

                    //Stay if the next step is out of the zone
                    when (newOrientationValue) {
                        N_VALUE -> {
                            if (newYValue < MAX_Y_VALUE)
                                newYValue += step.deltaMoving
                        }
                        S_VALUE -> {
                            if (newYValue > MIN_XY_VALUE)
                                newYValue -= step.deltaMoving
                        }
                        E_VALUE -> {
                            if (newXValue < MAX_X_VALUE)
                                newXValue += step.deltaMoving
                        }
                        W_VALUE -> {
                            if (newXValue > MIN_XY_VALUE)
                                newXValue -= step.deltaMoving
                        }
                        else -> {
                            throw Exception()
                        }
                    }
                }

                //Change orientation if have the changing
                if (step.deltaOrientation != 0)
                    newOrientationValue = (newOrientationValue + step.deltaOrientation + MODULO_VALUE) % MODULO_VALUE
            }
            return Position(newXValue, newYValue, getOrientationEnum(newOrientationValue))
        }
    }

    /**
     *
     * This function returns the Enum orientation from value Int
     * throw Exception if the data is not valid
     *
     * @param orientationValue value in Int of orientation from 0 to 3
     *
     */
    fun getOrientationEnum(orientationValue: Int = 0) : Orientation {
        return when (orientationValue) {
            N_VALUE -> Orientation.N
            E_VALUE -> Orientation.E
            S_VALUE -> Orientation.S
            W_VALUE -> Orientation.W
            else -> {
                throw Exception()
            }
        }
    }
}