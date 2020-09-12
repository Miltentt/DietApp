package com.example.myapplication.models.edamamResponse


class Nutrient(var label: String, var quantity: Double, var unit: String = "mg") {

    init {
        quantity = "%.0f ".format(quantity).toDouble()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Nutrient

        if (label != other.label) return false

        return true
    }

    override fun hashCode(): Int {
        return label.hashCode()
    }
}
