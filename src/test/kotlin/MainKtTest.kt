import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommission_TotalLimits() {
        val tsfAmount = 150_000_00
        val prevSumForMonth = 250_000_00
        val expected = 1_125_00

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = CardTypes.Visa)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_exceedTotalLimits() {
        val tsfAmount = 152_000_00
        val prevSumForMonth = 258_000_00
        val expected = -1

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = CardTypes.Visa)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_exceedTotalLimitsPrevMonth() {
        val tsfAmount = 100_00
        val prevSumForMonth = 599_900_00
        val expected = 35_00

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = CardTypes.Mir)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_TotalLimits_VkPay() {
        val tsfAmount = 15_000_00
        val prevSumForMonth = 25_000_00
        val expected = 0

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = CardTypes.VkPay)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_exceedLimits_VkPay() {
        val tsfAmount = 15_300_00
        val prevSumForMonth = 27_000_00
        val expected = -1

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = CardTypes.VkPay)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_exceedWithPrevMonthLimits_VkPay() {
        val tsfAmount = 0
        val prevSumForMonth = 40_000_00
        val expected = 0

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = CardTypes.VkPay)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_MasterAndMaestro() {
        val tsfAmount = 45_000_00
        val prevSumForMonth = 30_000_00
        val card = CardTypes.MasterCard
        val expected = 290_00

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = card)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_ExceedLimits_MasterAndMaestro() {
        val tsfAmount = 45_000_00
        val prevSumForMonth = 37_000_00
        val card = CardTypes.MasterCard
        val expected = -1

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = card)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_VisaAndMir() {
        val tsfAmount = 115_000_00
        val prevSumForMonth = 270_000_00
        val card = CardTypes.Mir
        val expected = 862_50

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = card)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_VisaAndMir_LessAddition() {
        val tsfAmount = 1_200_00
        val prevSumForMonth = 270_000_00
        val card = CardTypes.Mir
        val expected = 35_00

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = card)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_ExceedLimits_VisaAndMir() {
        val tsfAmount = 190_000_00
        val prevSumForMonth = 270_000_00
        val card = CardTypes.Visa
        val expected = -1

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = card)

        assertEquals(expected, result)
    }

    @Test
    fun calculateCommission_ExceedLimitsPrevMonth_VisaAndMir() {
        val tsfAmount = 125_000_00
        val prevSumForMonth = 490_000_00
        val card = CardTypes.Visa
        val expected = -1

        val result = calculateCommission(
            moneyTransferAmount = tsfAmount,
            previousSumForMonth = prevSumForMonth,
            cardType = card)

        assertEquals(expected, result)
    }
}