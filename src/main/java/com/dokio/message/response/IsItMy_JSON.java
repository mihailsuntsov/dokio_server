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
package com.dokio.message.response;

public class IsItMy_JSON {
    private boolean itIsDocumentOfMyCompany;
    private boolean itIsDocumentOfMyDepartments;
    private boolean itIsMyDocument;

    public boolean isItIsDocumentOfMyCompany() {
        return itIsDocumentOfMyCompany;
    }

    public void setItIsDocumentOfMyCompany(boolean itIsDocumentOfMyCompany) {
        this.itIsDocumentOfMyCompany = itIsDocumentOfMyCompany;
    }

    public boolean isItIsDocumentOfMyDepartments() {
        return itIsDocumentOfMyDepartments;
    }

    public void setItIsDocumentOfMyDepartments(boolean itIsDocumentOfMyDepartments) {
        this.itIsDocumentOfMyDepartments = itIsDocumentOfMyDepartments;
    }

    public boolean isItIsMyDocument() {
        return itIsMyDocument;
    }

    public void setItIsMyDocument(boolean itIsMyDocument) {
        this.itIsMyDocument = itIsMyDocument;
    }
}