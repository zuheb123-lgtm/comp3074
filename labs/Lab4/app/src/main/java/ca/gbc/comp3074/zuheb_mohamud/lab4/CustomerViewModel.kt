package ca.gbc.comp3074.zuheb_mohamud.lab4

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class CustomerViewModel(
    private val customerDao: CustomerDAO
) : ViewModel() {

    val customers: Flow<List<Customer>> = customerDao.getAll()

    suspend fun addCustomer(
        name: String,
        age: Int,
        isActive: Boolean
    ) {
        customerDao.insert(
            Customer(
                name = name,
                age = age,
                isActive = isActive
            )
        )
    }

    suspend fun deleteCustomer(customer: Customer) {
        customerDao.delete(customer)
    }
}
