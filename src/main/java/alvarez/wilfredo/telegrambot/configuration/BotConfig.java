package alvarez.wilfredo.telegrambot.configuration;

import alvarez.wilfredo.telegrambot.service.TelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfig {
    private final Logger log = LoggerFactory.getLogger(BotConfig.class);

    private final DefaultContext context;

    public BotConfig(DefaultContext context) {
        this.context = context;
    }

    @Bean
    public void botInit() {
        TelegramBot telegramBot = new TelegramBot(this.context);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
