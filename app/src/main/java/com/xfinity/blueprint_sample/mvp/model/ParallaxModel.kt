package com.xfinity.blueprint_sample.mvp.model

import com.xfinity.blueprint.model.ComponentModel

class ParallaxModel : ComponentModel {
    open var state: ParallaxState = ParallaxState.IDLE
}

enum class ParallaxState {
    IDLE, SCROLL
}