package com.example.gramtech.data

data class Lesson(
    val id: String,
    val title: String,
    val subtitle: String,
    val iconName: String,
    val summary: String,
    val whatIsIt: String,
    val whyUseful: List<String>,
    val practicalExample: String,
    val keyTips: List<String>
)

data class Scheme(
    val id: String,
    val name: String,
    val shortName: String,
    val tagline: String,
    val category: String,
    val purpose: String,
    val whoMayBenefit: String,
    val financialSupport: String,
    val keyFeatures: List<String>,
    val officialPortalName: String,
    val officialUrlAdvice: String,
    val officialUrl: String = ""
)


data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val category: String,
    val description: String,
    val emoji: String,
    val artisanOrigin: String
)

data class SuccessStory(
    val id: String,
    val title: String,
    val category: String,
    val entrepreneur: String,
    val location: String,
    val overview: String,
    val challenge: String,
    val techSolution: String,
    val keyResults: List<String>,
    val takeawayMessage: String
)

data class ProfitCalculationResult(
    val revenue: Double,
    val cost: Double,
    val profit: Double,
    val profitMarginPercent: Double,
    val isProfit: Boolean
)

data class EmiCalculationResult(
    val monthlyEmi: Double,
    val totalInterest: Double,
    val totalPayment: Double
)

data class SavingsCalculationResult(
    val monthlySavings: Double,
    val savingsRatePercent: Double,
    val isPositive: Boolean
)
