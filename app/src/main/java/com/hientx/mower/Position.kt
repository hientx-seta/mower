package com.hientx.mower

class Position (
    var x: Int = 0,
    var y: Int = 0,
    var orientation: Orientation = Orientation.N
) {
    override fun toString(): String {
        return x.toString() + " " + y.toString() + " " + orientation.name
    }
}

