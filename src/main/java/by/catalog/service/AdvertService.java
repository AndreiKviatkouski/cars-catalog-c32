package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.storage.AdvertStorage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvertService {

    private final AdvertStorage advertStorage = new AdvertStorage();

    public void saveAdvert(String mark, String model, String color, int year, double price, long idUser, String specificationAdvert) {
        AdvertStorage advertStorage = new AdvertStorage();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy ' время' hh:mm");
        String date = formatForDateNow.format(dateNow).toString();
        advertStorage.addAdvert(new Advert(mark, model, color, year, price, idUser, date, specificationAdvert));
    }


    public Advert getAdvert(long idAdvert) {
        return advertStorage.returnAdvertById(idAdvert);
    }


    public void saveAdvertToUserAdvertList(long idAdvert, long idUser) {
        advertStorage.addIdUserIdAdvert(idUser, idAdvert);
        // FIXME: 6/13/20
    }

    public List<Advert> findAllInterestingAdverts(long idUser) {
        List<Advert> list = new ArrayList<>();
        List allIdAdvertByIdUser = advertStorage.getAllIdAdvertByIdUser(idUser);
        for (int i = 0; i < allIdAdvertByIdUser.size(); i++) {
            long idAdvert = (long) allIdAdvertByIdUser.get(i);
            Advert advert = advertStorage.returnAdvertById(idAdvert);
            list.add(advert);
        }
        return list;
    }


//    public List<Advert> findAllAdverts() {
////        return advertStorage.findAllAdverts();
//        // FIXME: 6/13/20
//        return null;
//    }


    public List<Advert> getLastAdverts() {
        List<Advert> list = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        for (int i = allAdverts.size() - 1; i > allAdverts.size() - 20 && i > -1; i--) {
            Advert advert = (Advert) allAdverts.get(i);
            list.add(advert);
        }
        return list;
    }


    public Advert findAdvertById(long advertId) {
//        advertStorage.findAdvertById(advertId);
        // FIXME: 6/13/20 
        return null;
    }

    public List<Advert> findAdvertByMark(String mark) {
        List<Advert> listBySearch = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        for (int i = 0; i < allAdverts.size(); i++) {
            Advert advert = (Advert) allAdverts.get(i);
            if (advert.getMarkCar().equals(mark)) {
                listBySearch.add(advert);
            }
        }
        return listBySearch;
    }

    public List<Advert> findAdvertByModel(String mark, String model) {
        List<Advert> listBySearch = new ArrayList<>();
        List markAdverts = findAdvertByMark(mark);
        for (int i = 0; i < markAdverts.size(); i++) {
            Advert advert = (Advert) markAdverts.get(i);
            if (advert.getModelCar().equals(model)) {
                listBySearch.add(advert);
            }
        }
        return listBySearch;
    }

    public List<String> getAdvertMarks() {
        return advertStorage.getAllAdvertMark();
    }

    public List<String> returnModelByMark(String mark) {
        return advertStorage.getModelByMark(mark);
    }

    public List<String> returnMarkByModel(String model) {
        return advertStorage.getMarkByModel(model);
    }

    public List<String> returnSortMark() {
        List<String> listMark = new ArrayList<>();
        boolean b = true;
        List<String> allMark = advertStorage.getAllMark();
        for (String mark : allMark) {
            for (String mark1 : listMark) {
                b = true;
                if (mark.equals(mark1)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                listMark.add(mark);
            }
        }
        return listMark;
    }

    public List<String> returnSortModel() {
        List<String> listModel = new ArrayList<>();
        boolean b = true;
        List<String> allModel = advertStorage.getAllModel();
        for (String mark : allModel) {
            for (String mark1 : listModel) {
                b = true;
                if (mark.equals(mark1)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                listModel.add(mark);
            }
        }
        return listModel;
    }

    public List<Integer> listYear() {
        List<Integer> listYear = new ArrayList<>();
        for (int i = 1980; i < 2021; i++) {
            listYear.add(i);
        }
        return listYear;
    }

    public String[] colorList() {
        return new String[]{"black", "white", "silver", "brown", "gray", "red", "blue"};
    }

    public void deleteInterestingAdvert(long idAdvert, long idUser){
        advertStorage.removeIdAdvertIdUser(idAdvert, idUser);
    }

    public boolean checkIntrAdvert(long idAdvert, long idUser){
       return advertStorage.checkIdUserIdAdvert(idUser, idAdvert);
    }

    public List<Advert> getAllUserAdvert(long idUser){
       return advertStorage.getAllAdvertByIdUser(idUser);
    }
}

