/*
Приложение Dokio-server - учет продаж, управление складскими остатками, документооборот.
Copyright © 2020 Сунцов Михаил Александрович. mihail.suntsov@yandex.ru
Эта программа является свободным программным обеспечением: Вы можете распространять ее и (или) изменять,
соблюдая условия Генеральной публичной лицензии GNU редакции 3, опубликованной Фондом свободного
программного обеспечения;
Эта программа распространяется в расчете на то, что она окажется полезной, но
БЕЗ КАКИХ-ЛИБО ГАРАНТИЙ, включая подразумеваемую гарантию КАЧЕСТВА либо
ПРИГОДНОСТИ ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Ознакомьтесь с Генеральной публичной
лицензией GNU для получения более подробной информации.
Вы должны были получить копию Генеральной публичной лицензии GNU вместе с этой
программой. Если Вы ее не получили, то перейдите по адресу:
<http://www.gnu.org/licenses/>
 */
package com.dokio.controller.Sprav;
import com.dokio.message.response.Sprav.SpravSysCurrencyJSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Controller
@Repository
public class SpravSysCurrencyController {
    @PersistenceContext
    private EntityManager entityManager;





    @RequestMapping(
            value = "/api/auth/getSpravSysCurrency",
            method = RequestMethod.GET, produces = "application/json; charset=utf8")
    public ResponseEntity<?> getSpravSysCurrency(){
        String stringQuery=
                "select " +
                        " id as id, "+
                        " name_okb as name_okb, "+
                        " name_short as name_short, "+
                        " name_iso as name_iso, "+
                        " name_fraction as name_fraction, "+
                        " name_fraction_short as name_fraction_short, "+
                        " charcode_iso as charcode_iso, "+
                        " numcode_iso as numcode_iso, "+
                        " symbol_unicode as symbol_unicode, "+
                        " show_in_list as show_in_list "+
                        " from sprav_sys_currency order by id asc";
        Query query =  entityManager.createNativeQuery(stringQuery);
        List<Object[]> queryList = query.getResultList();
        List<SpravSysCurrencyJSON> returnList = new ArrayList<>();
        for(Object[] obj:queryList) {
            SpravSysCurrencyJSON doc=new SpravSysCurrencyJSON();
            doc.setId(Long.parseLong(               obj[0].toString()));
            doc.setName_okb((String)                obj[1]);
            doc.setName_short((String)              obj[2]);
            doc.setName_iso((String)                obj[3]);
            doc.setName_fraction((String)           obj[4]);
            doc.setName_fraction_short((String)     obj[5]);
            doc.setCharcode_iso((String)            obj[6]);
            doc.setNumcode_iso((Integer)            obj[7]);
            doc.setSymbol_unicode((String)          obj[8]);
            doc.setShow_in_list((Boolean)           obj[9]);
            returnList.add(doc);
        }
        return new ResponseEntity<List>(returnList, HttpStatus.OK);
    }
}
