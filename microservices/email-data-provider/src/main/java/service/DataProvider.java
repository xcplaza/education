package service;

import dto.EmailData;

public interface DataProvider {
    EmailData getEmailData(long sensorId);
}
