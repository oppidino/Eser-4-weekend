package com.uiip.interfaces;

import com.uiip.models.PhoneModel;

public interface PhoneDAO {

    public PhoneModel getPhoneInfo(String tipo);

    public boolean insertPhone(PhoneModel phone);

}
