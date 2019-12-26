package com.planatech.salarytracker.model

import com.google.firebase.firestore.Exclude
import java.io.Serializable

data class User(@Exclude val userId: String = "",
                @Exclude val userName: String = "",
                var income: List<Double?> = listOf(0.0),
                var expenses: List<Double?> = listOf(0.0),
                var netWorth: Double? = 0.0): Serializable