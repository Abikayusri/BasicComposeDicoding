package com.sinau.mybasiccomposedicoding.data

import com.sinau.mybasiccomposedicoding.model.FakeRewardDataSource
import com.sinau.mybasiccomposedicoding.model.OrderReward
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class RewardRepository {

    private val orderRewards = mutableListOf<OrderReward>()

    init {
        if (orderRewards.isEmpty()) {
            FakeRewardDataSource.dummyRewards.forEach {
                orderRewards.add(OrderReward(it, 0))
            }
        }
    }

    fun getAllRewards(): Flow<List<OrderReward>> {
        return flowOf(orderRewards)
    }

    fun getOrderRewardById(rewardId: Long): OrderReward {
        return orderRewards.first {
            it.reward.id == rewardId
        }
    }

    fun updateOrderReward(rewardId: Long, newCountValue: Int): Flow<Boolean> {
        val index = orderRewards.indexOfFirst { it.reward.id == rewardId }
        val result = if (index >= 0) {
            (orderRewards[index]).apply {
                orderRewards[index] =
                    copy(reward = reward, count = newCountValue)
            }
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderRewards(): Flow<List<OrderReward>> {
        return getAllRewards().map { orderRewards ->
            orderRewards.filter { orderReward ->
                orderReward.count != 0
            }
        }
    }

    companion object {
        @Volatile
        private var instance: RewardRepository? = null

        fun getInstance(): RewardRepository {
            return instance ?: synchronized(this) {
                instance ?: RewardRepository().also { instance = it }
            }
        }
    }
}