# **MDK - Navegação Entre Telas em Kotlin (Android)**

## **Introdução**
Este material explica como desenvolver um aplicativo Android em Kotlin que realiza a navegação entre diferentes telas (Activities) utilizando o **Intent**. O objetivo é criar um app semelhante ao da imagem fornecida, onde há transição entre telas com botões e interação do usuário.

---

## **1. Configuração do Projeto**
1. Abra o **Android Studio** e crie um novo projeto com **Empty Activity**.
2. Escolha **Kotlin** como linguagem principal.
3. Configure o mínimo SDK conforme necessário.

---

## **2. Criando as Activities**
Cada tela da aplicação será representada por uma **Activity**. Para criar novas telas:

1. No **Android Studio**, vá até o pacote `com.seuprojeto.app`.
2. Clique com o botão direito em **New → Activity → Empty Activity**.
3. Nomeie as Activities conforme necessário, como `MainActivity`, `SecondActivity`, etc.

---

## **3. Layouts das Telas (XML)**
Cada tela tem um **arquivo XML** dentro de `res/layout/`. Exemplo do layout da **MainActivity** (`activity_main.xml`):

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <Button
        android:id="@+id/btnTrocarTela"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Ir para Segunda Tela"/>
</LinearLayout>
```

---

## **4. Código Kotlin para Navegação**
Agora, dentro da `MainActivity.kt`, configuramos o botão para trocar de tela usando **Intent**.

```kotlin
package com.seuprojeto.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTrocarTela = findViewById<Button>(R.id.btnTrocarTela)

        btnTrocarTela.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
```

Na `SecondActivity.kt`, adicionamos um botão para retornar:

```kotlin
package com.seuprojeto.app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish() // Fecha a tela atual e retorna à anterior
        }
    }
}
```

---

## **5. Enviando Dados Entre Telas**
Caso seja necessário enviar dados entre telas, usamos o **Intent.putExtra**:

### **Na MainActivity:**
```kotlin
val intent = Intent(this, SecondActivity::class.java)
intent.putExtra("CHAVE_DADO", "Texto enviado para a outra tela")
startActivity(intent)
```

### **Na SecondActivity:**
```kotlin
val dadoRecebido = intent.getStringExtra("CHAVE_DADO")
textView.text = dadoRecebido
```

---

## **6. Conclusão**
Com esses passos, criamos uma aplicação Android que permite a **navegação entre telas** e o **envio de dados entre Activities** usando `Intent`. Esse é um conceito fundamental no desenvolvimento de aplicativos Android.

