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
package com.dokio.service.company;

import com.dokio.message.request.CompanyForm;
import com.dokio.model.Companies;
import com.dokio.message.response.CompaniesJSON;
import java.util.ArrayList;
import java.util.List;

public interface CompanyService {


    List<Companies> getCompaniesTable(int result, int offsetreal, String searchString, String sortColumn, String sortAsc);

    public Companies getCompanyById(Long id);

    public CompaniesJSON getCompanyValuesById(int id);

    public int getCompaniesSize(String searchString);

    public Long insertCompany(Companies company);

    public boolean updateCompany(CompanyForm company);

    public boolean deleteCompaniesByNumber(ArrayList<Long> delNumbers);

    public List<Companies> getCompaniesList();
}
