package ru.korkibuchi.SpringBoot.controllers;

import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Scope(SCOPE_PROTOTYPE)
public class CatRequst {

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    public void formatString(){
        this.file.replace('\\', '\u0000');

    }
}
