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
package com.dokio.message.request;

import java.util.Set;

public class WriteoffForm {
    private Long id;
    private Long company_id;
    private String description;
    private Long department_id;
    private Long cagent_id;
    private String doc_number;
    private String writeoff_date;
    private boolean is_completed;
    private Set<WriteoffProductForm> writeoffProductTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Long getCagent_id() {
        return cagent_id;
    }

    public void setCagent_id(Long cagent_id) {
        this.cagent_id = cagent_id;
    }

    public String getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public String getWriteoff_date() {
        return writeoff_date;
    }

    public void setWriteoff_date(String writeoff_date) {
        this.writeoff_date = writeoff_date;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public Set<WriteoffProductForm> getWriteoffProductTable() {
        return writeoffProductTable;
    }

    public void setWriteoffProductTable(Set<WriteoffProductForm> writeoffProductTable) {
        this.writeoffProductTable = writeoffProductTable;
    }

    @Override
    public String toString() {
        return "WriteoffForm: id=" + this.id + ", company_id=" + this.company_id + ", description=" + this.description
                + ", department_id=" + this.department_id  + ", cagent_id=" + this.cagent_id + ", doc_number=" + this.doc_number
                + ", is_completed=";
    }
}
