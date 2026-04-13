# 📱 Android Project – Unit Converter App

## 👨‍💻 Author

* Erik Valencia Cardona

---

## 📌 Project Description

This project is an Android mobile application built using **Kotlin** and **Jetpack Compose**.

The app allows users to register through a simple form and then access a **unit converter** with multiple categories and flexible unit selection using dropdown menus.

---

## 🧩 Application Structure

The project follows a **modular architecture**, separating responsibilities into different layers:

```
data/        → Unit definitions
domain/      → Conversion logic
ui/          → Screens and reusable components
navigation/  → Navigation logic
```

This improves scalability, readability, and maintainability.

---

## 📝 Registration Screen

* Simple form with:

  * Name
  * Email
* Register button
* Navigates to the converter screen

---

## 🔄 Converter Screen

Implemented using **TabRow**, with three categories:

### 📏 Length

### ⚖️ Mass

### 🌡️ Temperature

Each tab uses a **reusable component** (`ConverterTab`) to avoid code duplication.

---

## 🔁 Dynamic Unit Conversion

Unlike the initial version, the app now supports:

* ✅ Multiple units per category
* ✅ Bidirectional conversion (any unit → any unit)
* ✅ Dropdown selectors for:

  * "From" unit
  * "To" unit

---

## 🧱 Reusable Components

### 🔽 UnitDropdown

* Built using `ExposedDropdownMenuBox`
* Allows selecting units dynamically
* Fully reusable across all tabs

---

### 🔄 ConverterTab

* Generic composable used for all categories
* Receives:

  * Title
  * List of units
* Handles:

  * Input
  * Unit selection
  * Conversion
  * Result display

---

## ⚙️ Technologies Used

* Kotlin
* Jetpack Compose
* Navigation Compose
* Material 3

---

## 🧠 How It Works

* Navigation is handled using `NavHost` and `NavController`
* UI state is managed with `remember` and `mutableStateOf`
* Conversion logic is abstracted using:

  * `UnitOption` (data model)
  * `convert()` function (domain layer)
* Each unit converts through a **base unit system**, allowing scalable conversions

---

## 📊 Features Implemented

* ✅ User registration screen
* ✅ Tab-based navigation
* ✅ Length conversion
* ✅ Mass conversion
* ✅ Temperature conversion
* ✅ Dynamic unit selection (dropdowns)
* ✅ Reusable composables
* ✅ Clean architecture (data / domain / ui separation)

---

## 🚀 How to Run the Project

1. Clone the repository:

```bash
git clone <YOUR_REPOSITORY_URL>
```

2. Open the project in **Android Studio**

3. Sync Gradle

4. Run the app on:

   * Emulator OR
   * Physical device

---

## 💡 Notes

* The project was refactored to follow better development practices
* Focus was placed on:

  * Code reuse
  * Clean structure
  * Scalability

---

## 🏁 Conclusion

This project demonstrates the implementation of a modern Android application using **Jetpack Compose**, applying clean architecture principles and reusable UI components to build a flexible and scalable unit converter.
