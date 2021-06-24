package com.vbuecker.whatdidilearn.entities

import com.vbuecker.whatdidilearn.R

enum class UnderstandingLevel(val color: Int) {
    LOW(R.color.p_light),
    MEDIUM(R.color.p_darker),
    HIGH(R.color.primary_color)
}
