package estudo.credits.credits2customer.exceptions

data class BusinessException(override val message: String?): RuntimeException(message) {
}