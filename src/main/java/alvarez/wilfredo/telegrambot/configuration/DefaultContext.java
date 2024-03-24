package alvarez.wilfredo.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultContext {
    private final String botUsername;
    private final String botToken;

    public DefaultContext(@Value("${application.bot.username}") String botUsername,
                          @Value("${application.bot.token}") String botToken) {
        this.botUsername = botUsername;
        this.botToken = botToken;
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }
}
