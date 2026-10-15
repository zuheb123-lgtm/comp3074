# COMP3074 – Lab 4: Room Customer Lab (Kotlin + Jetpack Compose + Room)

Android app that stores customers in a SQLite database using the Room library.

- Single Room entity / table: `customers` (`id`, `name`, `age`, `isActive`)
- Customers are displayed with a `LazyColumn` (lazy list)
- Customers can be added (form + Add Customer button) and removed (Delete button)
- The list updates automatically because the DAO returns `Flow<List<Customer>>`

## Structure
```
ca.gbc.comp3074.zuheb_mohamud.lab4/
├── MainActivity.kt               (Compose UI + LazyColumn)
├── Customer.kt                   (@Entity "customers")
├── CustomerDAO.kt                (@Insert, @Delete, @Query)
├── AppDatabase.kt                (RoomDatabase singleton)
├── CustomerViewModel.kt
├── CustomerViewModelFactory.kt
└── ui/theme/                     (Color, Theme, Type)
```
