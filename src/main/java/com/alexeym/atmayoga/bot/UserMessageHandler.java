package com.alexeym.atmayoga.bot;

import com.alexeym.atmayoga.GlobalContext;
import com.alexeym.atmayoga.asanaguess.AsanaGuessGame;
import com.alexeym.atmayoga.asanaguess.GuessResult;
import com.alexeym.atmayoga.bot.command.*;
import com.alexeym.atmayoga.storage.MessageStorage;
import com.alexeym.atmayoga.storage.UserStorage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.User;

/**
 * Direct users may request for commands.
 * Also they may test reactions.. I think.
 *
 * Created by Alexey Matveev on 6/9/2018.
 */
public class UserMessageHandler {

    UserStorage userStorage = new UserStorage();
    MessageStorage messageStorage = new MessageStorage();

    StartCommand startCommand = new StartCommand();
    LastTrainingCommand lastTrainingCommand = new LastTrainingCommand();
    LinkCommand linkCommand = new LinkCommand();
    KotikCommand kotikCommand = new KotikCommand();
    TavrikCommand tavrikCommand = new TavrikCommand();
    MyActivityCommand myActivityCommand = new MyActivityCommand();
    AsanaGuessCommand asanaGuessCommand = new AsanaGuessCommand();

    public void handleUserMessage(Message message) {
        Long chatId = message.getChatId();
        String text = message.getText();
        User user = message.getFrom();

        // just ping storage that another user is here
        userStorage.anotherUserCame(user);

        // store non-command user messages
        if (text != null && !text.startsWith("/")) {
            messageStorage.addUserMessage(message);
        }

        // handle text command
        if (text != null) {
            // make bot command
            BotCommand command = null;
            if (text.startsWith(BotCommand.START)) command = startCommand;
            else if (text.startsWith(BotCommand.TRAINING_LINK)) command = linkCommand;
            else if (text.startsWith(BotCommand.TRAINING_LAST)) command = lastTrainingCommand;
            else if (text.startsWith(BotCommand.TAVRIK)) command = tavrikCommand;
            else if (text.startsWith(BotCommand.STAT_MY_ACTIVITY)) command = myActivityCommand;
            else if (text.startsWith(BotCommand.KOTIK)) command = kotikCommand;
            else if (text.startsWith(BotCommand.ASANA_GUESS_GAME)) command = asanaGuessCommand;

            // execute it and send response
            if (command != null) {
                String responseToUser = command.executeAndGetUserResponse(message);
                if (responseToUser != null) {
                    GlobalContext.BOT.sendMsgErrorless(BotUtils.createTextMsg(chatId, responseToUser));
                }
            } else {
                // check game status
                AsanaGuessGame game = GlobalContext.GUESS_GAME;
                if (game.isGameStarted(chatId)) {
                    GuessResult guessResult = game.guessMessage(chatId, text);
                    if (guessResult.isCorrect()) {
                        if (guessResult.getMatchPercentage() == 100) {
                            GlobalContext.BOT.sendMsgErrorless(BotUtils.createTextMsg(chatId, "Да 100% верно!)"));
                            game.stopGameForChat(chatId);
                        } else {
                            GlobalContext.BOT.sendMsgErrorless(BotUtils.createTextMsg(chatId, "Почти, верно на " + guessResult.getMatchPercentage() + " процентов, " +
                                    "правильный ответ: " + game.getCorrectResultForChat(chatId)));
                            game.stopGameForChat(chatId);
                        }
                    } else {
                        GlobalContext.BOT.sendMsgErrorless(BotUtils.createTextMsg(chatId, "хм.. нет"));
                    }
                }
            }
        }
    }

}
