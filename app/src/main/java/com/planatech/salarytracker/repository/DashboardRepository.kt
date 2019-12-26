package com.planatech.salarytracker.repository

import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.planatech.salarytracker.model.User

class DashboardRepository {

    private val fireStore = FirebaseFirestore.getInstance()

    companion object {
        @Volatile
        private var INSTANCE: DashboardRepository? = null

        fun getRepository(): DashboardRepository {
            return INSTANCE ?: synchronized(this) {
                DashboardRepository().also {
                    INSTANCE = it
                }
            }
        }
    }

    fun registerUser(userId: String, user: User, success: () -> Unit, failure: () -> Unit) {
        fireStore.document(userId).set(user)
            .addOnSuccessListener {
                success()
            }
            .addOnFailureListener {
                failure()
            }
    }

    fun getUserData(userId: String, success: (user: User?) -> Unit, failure: () -> Unit){
        val docRef = fireStore.collection("users").document(userId)
        docRef.get()
            .addOnSuccessListener {
                success(it.toObject(User::class.java))
            }
            .addOnFailureListener {
                failure()
            }
    }

}