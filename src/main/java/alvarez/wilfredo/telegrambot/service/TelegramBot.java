package alvarez.wilfredo.telegrambot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${app.bot.username}")
    private String botUsername;
    @Value("${app.bot.token}")
    private String botToken;

    Logger log = LoggerFactory.getLogger(TelegramBot.class);

    @Override
    public void onUpdateReceived(Update update) {
        // Se obtiene el mensaje escrito por el usuario
        final String messageTextReceived = update.getMessage().getText();

        log.info("Escribieron en el bot {}", messageTextReceived);

        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();

        // Se crea un objeto mensaje
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Gracias por escribirnos");

        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }
}
