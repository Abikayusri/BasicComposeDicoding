package com.sinau.mybasiccomposedicoding.ui.screen.cart

import com.sinau.mybasiccomposedicoding.model.OrderReward

data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)