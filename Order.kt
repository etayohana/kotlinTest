package com.testkotlin

import android.os.Build
import androidx.annotation.RequiresApi
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDateTime

class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)

    data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: BigDecimal)

    @RequiresApi(Build.VERSION_CODES.O)
    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {

        val tempMap: HashMap<DayOfWeek, Int> = HashMap();
        orders.forEach { it ->

            val day: DayOfWeek = it.creationDate.day

            it.orderLines.forEach {

                if (tempMap.containsKey(day)) {

                    tempMap[day] = it.quantity + tempMap[day]!!

                } else {

                    tempMap[day] = it.quantity

                }
            }
        }

        return returnMap
    }
}
