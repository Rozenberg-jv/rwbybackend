package com.example.rwbybackend.model.user;

import lombok.Getter;

public enum RoleName {

    ADMIN("ROLE_ADMIN"),
    EMPLOEEVD("ROLE_EMPLOEEVD"),              // Сотрудник ВД
    DEFEKTOSKOPIST("ROLE_DEFEKTOSKOPIST"),    // Дефектоскопист
    TEKHNIK("ROLE_TEKHNIK"),                  // Сотрудник техотдела
    DISPETCHER("ROLE_ DISPETCHER"),           // Диспетчер ПЧ
    TRACKMAN("ROLE_TRACKMAN"),                // Сотрудник службы пути
    LABORANT("ROLE_LABORANT"),                // Сотрудник ДЛД (Дорожная лаборатория дефектоскопии)
    GUEST("ROLE_GUEST");


    RoleName(String roleName) {

        this.roleName = roleName;
    }

    @Getter
    private final String roleName;
}