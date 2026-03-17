package com.example.pr_8;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AlertDialogs(String title, String message){ // спавним метод алерт диалог + параметры
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // билдер на русском строитель создаем хай строит
        builder.setTitle(title) // устанавливаем заголовок
                .setMessage(message) // и сообщение
                .setCancelable(false) // отмена по нажатию
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });  // создаем кнопку
        AlertDialog alter = builder.create(); // создаем диалог алтер типа ссылки на диалог
        alter.show(); // и показываем его
    }

    public void Consider(View view) { // метод консидер
        EditText course = findViewById(R.id.cours); // ищем тексбокс
        EditText count = findViewById(R.id.count); // еще текстбокс
        Switch dollar = findViewById(R.id.switch1); // свитч ищем
        TextView tv = findViewById(R.id.result); // ищем лабел результа

        if(course.getText().length() > 0) { // проверка что курс не 0
            if(count.getText().length() > 0) { // проверка что каунт не 0
                float f_course = Float.parseFloat(String.valueOf(course.getText())); // флоат делаем и конвертим туда значение
                float f_count = Float.parseFloat(String.valueOf(count.getText())); // флоат делаем и конвертим туда значение

                float composition = 0; // выстраиваем композицию
                if(dollar.isChecked() == true) { // если свич он тогда....
                    composition = f_course*f_count; // в композицию записывается курс умнож на каунт
                    tv.setText(composition + " р."); // в рез выводим композицию + р.
                } else { // если что-то не так то...
                    composition = f_count/f_course; // каунт делим на курс
                    tv.setText(composition + " $."); // также выводим композ
                }
            } else AlertDialogs("Уведомление", "Введите кол-во доллара."); // проверки на заполненность вывод ошибки
        } else AlertDialogs("Уведомление", "Введите курс доллара."); // проверки на заполненность вывод ошибки
    }

    public void URL(View view) { // новый метод юрл
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sberbank.ru/ru/quotes/currencies")); // переменная с переходом по ссылке
        startActivity(intent); // сстартуем!!!!
    }
}