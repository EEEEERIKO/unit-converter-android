# 📱 Parcial Android – Conversora de Unidades

## 👨‍💻 Integrante
- Erik Valencia Cardona

---

## 📌 Descripción del proyecto

Este proyecto consiste en una aplicación móvil desarrollada en Android utilizando **Kotlin** y **Jetpack Compose**. 

La aplicación permite al usuario registrarse mediante un formulario básico y posteriormente acceder a una conversora de unidades organizada en diferentes pestañas.

---

## 🧩 Estructura de la aplicación

### 📝 Pantalla de Registro
- Formulario simple con:
  - Nombre
  - Email
- Botón de registro
- Redirección a la pantalla principal (conversora)

---

### 🔄 Pantalla de Conversora

Se implementa mediante un sistema de pestañas (**TabRow**) con tres categorías:

#### 📏 Longitud
- Conversión:
  - Centímetros → Pulgadas
- Fórmula: inches = cm / 2.54

---

#### ⚖️ Masa
- Conversión:
  - Kilogramos → Libras
- Fórmula: lbs = kg * 2.20462

---

#### 🌡️ Temperatura (Libre elección)
- Conversión:
  - Celsius → Fahrenheit
- Fórmula: °F = (°C * 9/5) + 32

---

## ⚙️ Tecnologías utilizadas

- Kotlin
- Jetpack Compose
- Navigation Compose
- Material 3

---

## 🧠 Funcionamiento

- La navegación entre pantallas se gestiona con `NavHost` y `NavController`.
- El estado se maneja con `remember` y `mutableStateOf`.
- Cada pestaña tiene su propia lógica de conversión independiente.
- La interfaz sigue un enfoque declarativo con Compose.

---

## 📊 Criterios de evaluación cumplidos

- ✅ Pantalla de registro (1.0)
- ✅ Conversión de longitud (1.3)
- ✅ Conversión de masa (1.3)
- ✅ Conversión libre (temperatura) (1.4)

---

## 🚀 Ejecución del proyecto

1. Clonar el repositorio:
```bash
git clone <URL_DEL_REPOSITORIO>
