package com.hientx.mower

import com.hientx.mower.Constant.Companion.E_VALUE
import com.hientx.mower.Constant.Companion.N_VALUE
import com.hientx.mower.Constant.Companion.S_VALUE
import com.hientx.mower.Constant.Companion.W_VALUE

enum class Orientation(orientationValue: Int) {
    N(N_VALUE),
    E(E_VALUE),
    S(S_VALUE),
    W(W_VALUE)
}