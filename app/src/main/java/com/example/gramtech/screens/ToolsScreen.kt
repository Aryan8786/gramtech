package com.example.gramtech.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.automirrored.filled.TrendingUp

import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Savings

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gramtech.data.EmiCalculationResult
import com.example.gramtech.data.ProfitCalculationResult
import com.example.gramtech.data.SavingsCalculationResult
import com.example.gramtech.ui.theme.AmberContainer
import com.example.gramtech.ui.theme.AmberOnContainer
import com.example.gramtech.ui.theme.GreenLight
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.pow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolsScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Profit", "EMI", "Savings")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))
            Column {
                Text(
                    text = "Business Tools",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "“Simple calculators for daily business planning.”",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Tab Row
        item {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.clip(RoundedCornerShape(12.dp))
            ) {

                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = title,
                                fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        icon = {
                            when (index) {
                                0 -> Icon(Icons.AutoMirrored.Filled.TrendingUp, contentDescription = null, modifier = Modifier.size(18.dp))

                                1 -> Icon(Icons.Default.CreditCard, contentDescription = null, modifier = Modifier.size(18.dp))
                                else -> Icon(Icons.Default.Savings, contentDescription = null, modifier = Modifier.size(18.dp))
                            }
                        }
                    )
                }
            }
        }

        // Selected Tool Content
        item {
            when (selectedTabIndex) {
                0 -> ProfitCalculatorSection()
                1 -> EmiCalculatorSection()
                2 -> SavingsCalculatorSection()
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun ProfitCalculatorSection() {
    var sellingPriceText by remember { mutableStateOf("") }
    var costPriceText by remember { mutableStateOf("") }
    var quantityText by remember { mutableStateOf("") }

    var result by remember { mutableStateOf<ProfitCalculationResult?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val currencyFormatter = remember { NumberFormat.getNumberInstance(Locale("en", "IN")) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Text(
                text = "Profit Calculator",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Calculate your gross revenue, total expense, and net profit.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = sellingPriceText,
                onValueChange = {
                    sellingPriceText = it
                    errorMessage = null
                },
                label = { Text("Selling Price per item (₹)") },
                placeholder = { Text("e.g. 500") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = costPriceText,
                onValueChange = {
                    costPriceText = it
                    errorMessage = null
                },
                label = { Text("Cost Price per item (₹)") },
                placeholder = { Text("e.g. 300") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = quantityText,
                onValueChange = {
                    quantityText = it
                    errorMessage = null
                },
                label = { Text("Quantity (Units)") },
                placeholder = { Text("e.g. 10") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            if (errorMessage != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = {
                        if (sellingPriceText.isBlank() || costPriceText.isBlank() || quantityText.isBlank()) {
                            errorMessage = "Please enter all values."
                            result = null
                            return@Button
                        }

                        val sp = sellingPriceText.toDoubleOrNull()
                        val cp = costPriceText.toDoubleOrNull()
                        val qty = quantityText.toDoubleOrNull()

                        if (sp == null || cp == null || qty == null || sp < 0 || cp < 0 || qty < 0) {
                            errorMessage = "Please enter valid numbers."
                            result = null
                            return@Button
                        }

                        val revenue = sp * qty
                        val cost = cp * qty
                        val profit = revenue - cost
                        val margin = if (revenue > 0) (profit / revenue) * 100.0 else 0.0

                        result = ProfitCalculationResult(
                            revenue = revenue,
                            cost = cost,
                            profit = profit,
                            profitMarginPercent = margin,
                            isProfit = profit >= 0
                        )
                        errorMessage = null
                    },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Calculate Profit", fontWeight = FontWeight.Bold)
                }

                // Demo preset button for easy college presentation demo
                Button(
                    onClick = {
                        sellingPriceText = "500"
                        costPriceText = "300"
                        quantityText = "10"
                        errorMessage = null
                        val revenue = 500.0 * 10.0
                        val cost = 300.0 * 10.0
                        val profit = revenue - cost
                        result = ProfitCalculationResult(
                            revenue = revenue,
                            cost = cost,
                            profit = profit,
                            profitMarginPercent = (profit / revenue) * 100.0,
                            isProfit = true
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = AmberContainer, contentColor = AmberOnContainer),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Demo Values", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
            }

            AnimatedVisibility(visible = result != null) {
                result?.let { calc ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (calc.isProfit) GreenLight else AmberContainer)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Calculation Summary",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        ResultRow("Total Revenue", "₹${currencyFormatter.format(calc.revenue)}")
                        ResultRow("Total Cost", "₹${currencyFormatter.format(calc.cost)}")

                        HorizontalDivider(modifier = Modifier.padding(vertical = 6.dp))

                        ResultRow(
                            label = if (calc.isProfit) "Net Profit" else "Net Loss",
                            value = "₹${currencyFormatter.format(calc.profit)}",
                            isHighlight = true,
                            color = if (calc.isProfit) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EmiCalculatorSection() {
    var loanAmountText by remember { mutableStateOf("") }
    var interestRateText by remember { mutableStateOf("") }
    var tenureMonthsText by remember { mutableStateOf("") }

    var result by remember { mutableStateOf<EmiCalculationResult?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val currencyFormatter = remember { NumberFormat.getNumberInstance(Locale("en", "IN")) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Text(
                text = "Loan EMI Calculator",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Estimate your monthly installment for MUDRA or business loans.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = loanAmountText,
                onValueChange = {
                    loanAmountText = it
                    errorMessage = null
                },
                label = { Text("Loan Amount (₹)") },
                placeholder = { Text("e.g. 100000") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = interestRateText,
                onValueChange = {
                    interestRateText = it
                    errorMessage = null
                },
                label = { Text("Annual Interest Rate (%)") },
                placeholder = { Text("e.g. 9.5") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = tenureMonthsText,
                onValueChange = {
                    tenureMonthsText = it
                    errorMessage = null
                },
                label = { Text("Loan Duration (Months)") },
                placeholder = { Text("e.g. 36") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            if (errorMessage != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (loanAmountText.isBlank() || interestRateText.isBlank() || tenureMonthsText.isBlank()) {
                        errorMessage = "Please enter all values."
                        result = null
                        return@Button
                    }

                    val p = loanAmountText.toDoubleOrNull()
                    val annualRate = interestRateText.toDoubleOrNull()
                    val n = tenureMonthsText.toDoubleOrNull()

                    if (p == null || annualRate == null || n == null || p <= 0 || annualRate <= 0 || n <= 0) {
                        errorMessage = "Please enter valid numbers."
                        result = null
                        return@Button
                    }

                    val monthlyRate = (annualRate / 12.0) / 100.0
                    val factor = (1.0 + monthlyRate).pow(n)
                    val emi = if (factor != 1.0) {
                        (p * monthlyRate * factor) / (factor - 1.0)
                    } else {
                        p / n
                    }
                    val totalPayment = emi * n
                    val totalInterest = totalPayment - p

                    result = EmiCalculationResult(
                        monthlyEmi = emi,
                        totalInterest = totalInterest,
                        totalPayment = totalPayment
                    )
                    errorMessage = null
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Calculate EMI", fontWeight = FontWeight.Bold)
            }

            AnimatedVisibility(visible = result != null) {
                result?.let { calc ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(GreenLight)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Monthly EMI",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "₹${currencyFormatter.format(calc.monthlyEmi.toLong())} / month",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        HorizontalDivider()
                        Spacer(modifier = Modifier.height(8.dp))

                        ResultRow("Total Interest", "₹${currencyFormatter.format(calc.totalInterest.toLong())}")
                        ResultRow("Total Amount Payable", "₹${currencyFormatter.format(calc.totalPayment.toLong())}")
                    }
                }
            }
        }
    }
}

@Composable
private fun SavingsCalculatorSection() {
    var monthlyIncomeText by remember { mutableStateOf("") }
    var monthlyExpensesText by remember { mutableStateOf("") }

    var result by remember { mutableStateOf<SavingsCalculationResult?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val currencyFormatter = remember { NumberFormat.getNumberInstance(Locale("en", "IN")) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Text(
                text = "Savings Calculator",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Track your monthly surplus to reinvest in your enterprise.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = monthlyIncomeText,
                onValueChange = {
                    monthlyIncomeText = it
                    errorMessage = null
                },
                label = { Text("Monthly Income (₹)") },
                placeholder = { Text("e.g. 25000") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = monthlyExpensesText,
                onValueChange = {
                    monthlyExpensesText = it
                    errorMessage = null
                },
                label = { Text("Monthly Expenses (₹)") },
                placeholder = { Text("e.g. 18000") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            if (errorMessage != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (monthlyIncomeText.isBlank() || monthlyExpensesText.isBlank()) {
                        errorMessage = "Please enter all values."
                        result = null
                        return@Button
                    }

                    val income = monthlyIncomeText.toDoubleOrNull()
                    val expenses = monthlyExpensesText.toDoubleOrNull()

                    if (income == null || expenses == null || income < 0 || expenses < 0) {
                        errorMessage = "Please enter valid numbers."
                        result = null
                        return@Button
                    }

                    val savings = income - expenses
                    val rate = if (income > 0) (savings / income) * 100.0 else 0.0

                    result = SavingsCalculationResult(
                        monthlySavings = savings,
                        savingsRatePercent = rate,
                        isPositive = savings >= 0
                    )
                    errorMessage = null
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Calculate Savings", fontWeight = FontWeight.Bold)
            }

            AnimatedVisibility(visible = result != null) {
                result?.let { calc ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (calc.isPositive) GreenLight else AmberContainer)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Monthly Savings",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "₹${currencyFormatter.format(calc.monthlySavings.toLong())} / month",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = if (calc.isPositive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                        )

                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = if (calc.isPositive) {
                                "Formula: Monthly Savings = Income − Expenses\nYou are saving ${"%.1f".format(calc.savingsRatePercent)}% of your monthly revenue."
                            } else {
                                "Formula: Monthly Savings = Income − Expenses\nExpenses exceed current income by ₹${currencyFormatter.format((-calc.monthlySavings).toLong())}."
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ResultRow(
    label: String,
    value: String,
    isHighlight: Boolean = false,
    color: Color = Color.Unspecified
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = if (isHighlight) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium,
            fontWeight = if (isHighlight) FontWeight.Bold else FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = value,
            style = if (isHighlight) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = if (color != Color.Unspecified) color else MaterialTheme.colorScheme.onSurface
        )
    }
}
