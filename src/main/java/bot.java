

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.List;

public class bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
    private void sendMessage(Message msg, String text) {
        SendMessage sendMessage = new SendMessage();
        setButtons(sendMessage);
        sendMessage.setChatId(msg.getChatId());
        sendMessage.setText(text);
        try {
            execute(sendMessage);                    //планирует задачу
        } catch (TelegramApiException e) {
            e.printStackTrace();                     //выводит описание ошибки
        }
    }

    public synchronized void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Что за охинею ты несешь?"));

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("Вишневый сад"));
        keyboardSecondRow.add(new KeyboardButton("Де ти гуляла цілу ніч"));
        keyboardSecondRow.add(new KeyboardButton("Там соловей щебечет"));

        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add(new KeyboardButton("Поле колосьев"));
        keyboardThirdRow.add(new KeyboardButton("Синє небо"));
        keyboardThirdRow.add(new KeyboardButton("Красно-белые одежки"));

        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);

        replyKeyboardMarkup.setKeyboard(keyboard);
    }


        public void onUpdateReceived(Update update) {
            Message msg = update.getMessage();
            String txt = msg.getText();
            if ("/start".equals(txt)) {
                sendMessage(msg, "Hello. Here is the list of the commands that you can use: Привет ; Помощь ; Будь вежливей! ; А что значит это слово? ; Посоветуй мне музыку ; Чем можно заняться? Мне скучно ; Почему ты такой бесполезный? ; Поиграй со мной ; Что ты вообще можешь? ; Почему ты называешь меня товарищем?");

            } else if ("Привет".equals(txt)){
                sendMessage(msg, "Здравия желаю, товарищ");
            } else if ("Помощь".equals(txt)){
                sendMessage(msg, "М? Сам, что, не можешь ничего сделать?");
            } else if ("Будь вежливей!".equals(txt)){
                sendMessage(msg, "О чем вы говорите, товарищ? Из меня вежливость рекой течет");
            } else if ("А что значит это слово?".equals(txt)){
                sendMessage(msg, "Я тебе что, википедия? Уже не маленький, зайти в гугл и узнать значение можешь и сам");
            } else if ("Посоветуй мне музыку".equals(txt)){
                sendMessage(msg, "Сам я меломан, так что ничем помочь не могу. Исходи из своих вкусов");
            } else if ("Чем можно заняться? Мне скучно".equals(txt)){
                sendMessage(msg, "Есть множество дел: спать, рисовать, слушать музыку, играть, гулять. В общем, делай то, что и обычно - деградируй");
            } else if ("Почему ты такой бесполезный?".equals(txt)){
                sendMessage(msg, "а почему ты тогда тратишь свое драгоцеенное время на такого как я, товарищ?");
            } else if ("Поиграй со мной".equals(txt)){
                sendMessage(msg, "Разве что в слова, заодно и увеличу твой словарный запас");
            } else if ("Что ты вообще можешь?".equals(txt)){
                sendMessage(msg, "Я могу все то, что и твое воображение, т.е. ничего");
            } else if ("Почему ты называешь меня товарищем?".equals(txt)){
                sendMessage(msg, "Потому что.. потому что");
            } else if ("Синє небо".equals(txt)){
                sendMessage(msg, "І колосяться поля..");
            } else if ("Вишневый сад".equals(txt)){
                sendMessage(msg, "Кажется мне знакомым это название.. вроде бы в названии одной песни такое есть");
            } else if ("Де ти гуляла цілу ніч".equals(txt)){
                sendMessage(msg, "Это, что, слова из песни, товарищ? Или вы просто надо мной издеваетесь?");
            } else if ("Там соловей щебечет".equals(txt)){
                sendMessage(msg, "Соловей? Где?");
            } else if ("Поле колосьев".equals(txt)) {
                sendMessage(msg, "Пшеничное поле, золотые колосья которого в будущем станут пропитанием человечества, а также могут являться вдохновением для творцов");
            } else if ("Красно-белые одежки".equals(txt)){
                sendMessage(msg, "Красный и белый цвета, чаще всего, являлись основными в нарядах козаков в различных мультипликациях и артах. Ну, и на вышиванках тоже");
            } else if ("Что за охинею ты несешь?".equals(txt)){
                sendMessage(msg, "А что, нельзя? У нас тут свобода слова, как-никак");
            }  else {
                sendMessage(msg, "Извиняюсь, конечно, но моя твоя не понимать");
            }
        }
        public String getBotUsername() {
            return "Whispdraw_bot";
        }
        public String getBotToken() {
            return "809580928:AAHz8tsQLvHxY0wZhf_lIdh7sbeE0_OCnmM";
        }
    }
