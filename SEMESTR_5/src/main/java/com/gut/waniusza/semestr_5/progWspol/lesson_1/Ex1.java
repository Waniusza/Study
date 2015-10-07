package com.gut.waniusza.semestr_5.progWspol.lesson_1;

//  http://enauczanie.pg.gda.pl/moodle/course/view.php?id=558

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ex1 {

    private final Logger log;
    
    public Ex1() {
        this.log = LogManager.getLogger(Ex1.class);
    }

    public  void run() {
        for (char i = 'A'; i <= 'Z'; i++) {
           log.debug(i);
            
        }
    }

}
