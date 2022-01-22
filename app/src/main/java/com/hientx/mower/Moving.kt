package com.hientx.mower

enum class Moving(val deltaMoving: Int, val deltaOrientation: Int) {
    L(0, -1),
    R(0, 1),
    F(1, 0)
}