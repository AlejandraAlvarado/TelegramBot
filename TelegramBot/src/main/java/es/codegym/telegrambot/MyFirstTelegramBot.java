package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "Ale";
    public static final String TOKEN = "6374612457:AAHKjXObtSqWs0zn9ZT5Vp4sDpbZ1MPJsTA";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if(getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoTextMessageAsync("step_1_pic",
                    STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoTextMessageAsync("step_2_pic",
                    STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha! +20 de fama","step_2_btn",
                    "¡Tomar un pescado! +20 de fama","step_2_btn",
                    "¡Tirar una lata de pepinillos! +20 de fama","step_2_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoTextMessageAsync("step_3_pic",
                    STEP_3_TEXT,
                    Map.of("Hackear al robot aspirador","step_3_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendPhotoTextMessageAsync("step_4_pic",
                    STEP_4_TEXT,
                    Map.of("Enviar al robot aspirador a por comida! +30 de fama","step_4_btn",
                            "Dar un paseo en el robot aspirador! +30 de fama","step_4_btn",
                            "¡Huir del robot aspirador! +30 de fama","step_4_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            sendPhotoTextMessageAsync("step_5_pic",
                    STEP_5_TEXT,
                    Map.of("¡Encender GoPro!","step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendPhotoTextMessageAsync("step_6_pic",
                    STEP_6_TEXT,
                    Map.of("Hacer que el robot aspirador limpie la habitación! +40 de fama","step_6_btn",
                            "Asustar al perro con el robot aspirador! +40 de fama","step_6_btn",
                            "¡Jugar carreras con el robot aspirador! +40 de fama","step_6_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            sendPhotoTextMessageAsync("step_7_pic",
                    STEP_7_TEXT,
                    Map.of("¡Hackear contraseña!","step_7_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            sendPhotoTextMessageAsync("step_8_pic",
                    STEP_8_TEXT,
                    Map.of("¡Celebrar!","step_8_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            sendPhotoTextMessageAsync("final_pic",
                    FINAL_TEXT,
                    Map.of());
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}