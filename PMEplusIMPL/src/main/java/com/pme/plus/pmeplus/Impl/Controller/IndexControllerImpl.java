package com.pme.plus.pmeplus.Impl.Controller;

import com.pme.plus.pmeplus.api.Controller.IndexControllerAPI;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gnkali on 7/29/17.
 */

@Controller("indexControllerImpl")
public class IndexControllerImpl implements IndexControllerAPI{

    @Override
    public String getActualTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }
}
