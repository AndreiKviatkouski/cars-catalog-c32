package by.catalog.service;

import by.catalog.domain.Message;
import by.catalog.storage.MessageStorage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MessageService {
    private final MessageStorage messageStorage = new MessageStorage();

    public void saveMessage(long idAdvert, long idUser, String body) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy ' время' hh:mm");
        String date = formatForDateNow.format(dateNow);
        messageStorage.addMessage(new Message(idAdvert, idUser, body, date));
    }

    public List<Message> getMessage(long idAdvert) {
        return messageStorage.returnMessageByIdAdvert(idAdvert);
    }
}
