package com.easyapp.mathias.adm.mathias.utils;

import com.easyapp.mathias.adm.mathias.MathiasAdmApplication;
import org.slf4j.LoggerFactory;

public class LogUtils {
    public static void log(String msn){
        LoggerFactory.getLogger(MathiasAdmApplication.class).info(msn);
    }
}
