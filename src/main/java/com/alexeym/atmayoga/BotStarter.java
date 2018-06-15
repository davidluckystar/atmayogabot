package com.alexeym.atmayoga;

import com.alexeym.atmayoga.bot.AtmayogaBot;
import com.alexeym.atmayoga.scheduler.Cron4j;
import com.alexeym.atmayoga.scheduler.ScheduledTasksManager;
import it.sauronsoftware.cron4j.SchedulingPattern;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexey Matveev on 6/4/2018.
 */
public class BotStarter {

     static {
        ApiContextInitializer.init();
    }

    public static void main(String[] args) {
        AtmayogaBot bot = new AtmayogaBot();
        ScheduledTasksManager scheduledTasksManager = new ScheduledTasksManager();

        // horray! I can set everything to global context
        GlobalContext.BOT = bot;
        GlobalContext.SCHEDULING_MANAGER = scheduledTasksManager;
        // yay!!!

        // wait a bit and check one-time messages
        scheduledTasksManager.runTaskWithDelay(scheduledTasksManager::checkOneTimeBroadcastMessage, 2, TimeUnit.SECONDS);

        // setup cron4j scheduler
        scheduledTasksManager.setupSchedulerAndTasks();

        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
